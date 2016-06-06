/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.Produto;
import br.senac.tads.pi3.imeg.entity.RelatorioEstoque;
import br.senac.tads.pi3.imeg.entity.RelatorioFaturamento;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import br.senac.tads.pi3.imeg.util.RelatorioExcel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * @author Márcio Soares <marcio@mail.com>
 */
@WebServlet(name = "DashBoardServlet", urlPatterns = {"/dashboard", "/painel"})
public class DashBoardServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");

        ArrayList<RelatorioVenda> maisVendidos = null;
        ArrayList<RelatorioEstoque> estoqueBaixo = null;
        ArrayList<RelatorioVenda> unidadeMaisVendeu = null;
        List<Produto> produtos = null;
        String search = request.getParameter("search");
        if (search != null && request.getQueryString() != null) {
            produtos = new ProdutoDao().pesquisarProdutos(search);
            if (produtos == null) {

                request.setAttribute("search", search);
                request.setAttribute("msg_error", true);
            }
        }

        if (usuario != null && usuario.getUnidade().isMatriz()) {
            maisVendidos = new RelatorioDao().listarTresMaisVendidos();
            estoqueBaixo = new RelatorioDao().listarProdutosComBaixoEstoque();
            unidadeMaisVendeu = new RelatorioDao().listarUnidadesQueMaisVenderam();
        } else if (usuario.getAcesso().getNome().equals("GERENTE") || usuario.getAcesso().getNome().equals("ADMIN")) {
            maisVendidos = new RelatorioDao().listarMaisVendidosFilial(usuario);
        } else if (usuario.getAcesso().getNome().equals("VENDEDOR")) {
            maisVendidos = new RelatorioDao().listarMaisVendidosVendedor(usuario);
        }
        request.setAttribute("produtos", produtos);
        request.setAttribute("maisVendidos", maisVendidos);
        request.setAttribute("estoqueBaixo", estoqueBaixo);
        request.setAttribute("unidadeMaisVendeu", unidadeMaisVendeu);

        request.getRequestDispatcher("/WEB-INF/views/home/bemvindo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String> mensagens = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        if (!request.getParameter("date-ini-mais-vendidos").isEmpty()) {
            mensagens.add("O campo data inicio não pode ser vazio.");
        }
        if (!request.getParameter("date-end-mais-vendidos").isEmpty()) {
            mensagens.add("O campo data fim não pode ser vazio.");
        }

        String dt_inicio = (request.getParameter("date-ini-mais-vendidos"));
        String dt_fim = (request.getParameter("date-end-mais-vendidos"));// recebe os valores de data em String
        Date dataInicio = null;
        Date dataFim = null;

        try {
            dataInicio = (Date) format.parse(dt_inicio);
            dataInicio = (Date) format.parse(dt_fim);
            RelatorioExcel relatorio = new RelatorioExcel();
            HSSFWorkbook wb = relatorio.relatorio(dataInicio, dataFim);

            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0");
            response.setHeader("Content-Disposition", "attachment; filename=vendas.xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();

        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
