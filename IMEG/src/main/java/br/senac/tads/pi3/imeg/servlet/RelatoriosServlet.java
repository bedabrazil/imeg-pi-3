package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import br.senac.tads.pi3.imeg.util.RelatorioExcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author iosato
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/relatorios"})
public class RelatoriosServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date hoje = cal.getTime();
        request.setAttribute("hoje", hoje);
        cal.add(Calendar.MONTH, -3);
        Date tresMesesAtras = cal.getTime();
        request.setAttribute("tresMesesAtras", tresMesesAtras);


        List<RelatorioVenda> unidadesQueMaisVenderamUltimosTresMeses = new RelatorioDao().unidadesQueMaisVenderamUltimosTresMeses();
        request.setAttribute("unidadesQueMaisVenderamUltimosTresMeses", unidadesQueMaisVenderamUltimosTresMeses);
        List<RelatorioVenda> relatorioTresMesesAtras = new RelatorioDao().ultimosTresMeses();
        request.setAttribute("relatorioTresMesesAtras", relatorioTresMesesAtras);
        List<RelatorioVenda> funcionariosQueMaisVenderam = new RelatorioDao().listarFuncionariosQueMaisVenderamNosUltimosTresMeses(hoje, tresMesesAtras);
        request.setAttribute("funcionariosQueMaisVenderam", funcionariosQueMaisVenderam);
        List<RelatorioVenda> faturamentoTotalDaMatriz = new RelatorioDao().faturamentoTotalPorMes();
        request.setAttribute("faturamentoTotalDaMatriz", faturamentoTotalDaMatriz);
//        ArrayList<RelatorioVenda> tresMaisVendidos = new RelatorioDao().listarTresMaisVendidos();
//        request.setAttribute("tresMaisVendidos", tresMaisVendidos);
//        
//        ArrayList<RelatorioVenda> maisVendidos = new RelatorioDao().listarTresMaisVendidos();
//        request.setAttribute("maisVendidos", maisVendidos);
//        
        request.getRequestDispatcher("/WEB-INF/views/relatorios/index.jsp").forward(request, response);

        HttpSession session = request.getSession();
        String msg_success = (String) session.getAttribute("msg_success");

        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
        }            
        
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        ArrayList<String> mensagens = new ArrayList<>();
        RelatorioExcel relatorio = new RelatorioExcel();
        
        String dt_inicio = (request.getParameter("date-ini-mais-vendidos"));
        String dt_fim = (request.getParameter("date-end-mais-vendidos"));// recebe os valores de data em String
        
        
        
        if (request.getParameter("mais_vendidos") != null && request.getParameter("mais_vendidos").equals("1") && request.getParameter("mais_vendidos").matches("\\d+")) {
            if (!request.getParameter("date-ini-mais-vendidos").isEmpty()) {
                mensagens.add("O campo data inicio não pode ser vazio.");
            }
            if (!request.getParameter("date-end-mais-vendidos").isEmpty()) {
                mensagens.add("O campo data fim não pode ser vazio.");
            }
            
        }
        
        if(mensagens.size() > 0){
            request.setAttribute("error", true);
            request.setAttribute("msg_error", mensagens);
            processRequest(request, response);
            return;
        }
        else{
            HSSFWorkbook wb = relatorio.MAIS_VENDIDOS_E(dt_inicio, dt_fim);
        }
        if (request.getParameter("funcionarios_que_mais_venderam") != null && request.getParameter("funcionarios_que_mais_venderam").equals("1") && request.getParameter("funcionarios_que_mais_venderam").matches("\\d+")) {
            if (!request.getParameter("date-ini-mais-vendidos").isEmpty()) {
                mensagens.add("O campo data inicio não pode ser vazio.");
            }
            if (!request.getParameter("date-end-mais-vendidos").isEmpty()) {
                mensagens.add("O campo data fim não pode ser vazio.");
            }
            
        }
        if(mensagens.size() > 0){
            request.setAttribute("error", true);
            request.setAttribute("msg_error", mensagens);
            processRequest(request, response);
            return;
        }
        else{
            HSSFWorkbook wb = relatorio.FUNCIONARIO_MAIS_VENDEU_E(dt_inicio, dt_fim);
        }
        
        
        

        try {
            
            HSSFWorkbook wb = relatorio.MAIS_VENDIDOS_E(dt_inicio, dt_fim);

            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0");
            response.setHeader("Content-Disposition", "attachment; filename=ototo.xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
            response.sendRedirect(request.getContextPath() + "/relatorios");
        } catch (IOException e) {
        }

    }

}
