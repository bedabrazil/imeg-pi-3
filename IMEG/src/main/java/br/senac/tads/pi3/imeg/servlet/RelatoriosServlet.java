package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iosato
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/relatorios"})
public class RelatoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date hoje = cal.getTime();
        request.setAttribute("hoje", hoje);        
        cal.add(Calendar.MONTH, -3);
        Date tresMesesAtras = cal.getTime();
        request.setAttribute("tresMesesAtras", tresMesesAtras);
        
        List<RelatorioVenda> relatorioTresMesesAtras = new RelatorioDao().ultimosTresMeses(hoje, tresMesesAtras);
        request.setAttribute("relatorioTresMesesAtras", relatorioTresMesesAtras);
        List<RelatorioVenda> funcionariosQueMaisVenderam = new RelatorioDao().listarFuncionariosQueMaisVenderamNosUltimosTresMeses(hoje, tresMesesAtras);
        request.setAttribute("funcionariosQueMaisVenderam", funcionariosQueMaisVenderam);
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
}
