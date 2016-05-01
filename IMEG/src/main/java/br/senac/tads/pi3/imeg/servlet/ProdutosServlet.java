/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
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
//        processRequest(request, response, path);
        String nomeProduto = request.getParameter("nome-produto");
        String precoCustoProduto = request.getParameter("preco-custo-produto");
        String precoVendaProduto = request.getParameter("preco-venda-produto");
        String qtdMinProduto = request.getParameter("qtd-min-produto");
        String qtdMaxProduto = request.getParameter("qtd-max-produto");
        String saldoProduto = request.getParameter("saldo-produto");
        String categoriaId = request.getParameter("categoria-id");

        HttpSession session = request.getSession(true);
        session.setAttribute("msg", "Seu Produto:<br> Nome: " + nomeProduto
                + "<br>Preço de Custo: " + precoCustoProduto
                + "<br>Preço de Venda: " + precoVendaProduto
                + "<br>Quantidade Mínima: " + qtdMinProduto
                + "<br>Quantidade Máxima: " + qtdMaxProduto
                + "<br>Saldo do Produto: " + saldoProduto
                + "<br>Categoria do Produto:" + categoriaId);
        response.sendRedirect("sucesso");

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
