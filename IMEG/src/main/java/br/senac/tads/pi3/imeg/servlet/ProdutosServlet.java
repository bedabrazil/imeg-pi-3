/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */

@WebServlet
@MultipartConfig
public class ProdutosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        request.setAttribute("path", path);
        request.getRequestDispatcher("WEB-INF/views/produtos/novo.jsp").forward(request, response);
    }

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
        String path = request.getPathInfo();
        processRequest(request, response, path);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();

        String nomeProduto = request.getParameter("nome_produto");
        String precoCustoProduto = request.getParameter("preco_custo_produto");
        String precoVendaProduto = request.getParameter("preco_venda_produto");
        String qtdMinProduto = request.getParameter("qtd_min_produto");
        String qtdMaxProduto = request.getParameter("qtd_max_produto");
        String saldoProduto = request.getParameter("saldo_produto");
        String categoriaId = request.getParameter("categoria_id");

        HttpSession session = request.getSession(true);
        session.setAttribute("msg", "Seu Produto:<br> Nome: " + nomeProduto
                + "<br>Preço de Custo: " + precoCustoProduto
                + "<br>Preço de Venda: " + precoVendaProduto
                + "<br>Quantidade Mínima: " + qtdMinProduto
                + "<br>Quantidade Máxima: " + qtdMaxProduto
                + "<br>Saldo do Produto: " + saldoProduto
                + "<br>Categoria do Produto:" + categoriaId);
        out.println('success');

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
