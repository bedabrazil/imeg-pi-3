/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
@WebServlet(name = "PedidosServlet", urlPatterns = {"/carrinho"})
public class PedidosServlet extends HttpServlet {

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
//        HttpSession session = request.getSession(true);
//        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
//        ArrayList<Produto> produtos = new ProdutoDao().produtosComSaldo();
//        request.setAttribute("produtos", produtos);
//        request.getRequestDispatcher("/WEB-INF/views/pedidos/index.jsp").forward(request, response);
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
//        HttpSession session = request.getSession(true);
//        Produto produto = null;
//        ArrayList<Produto> carrinhoSession = (ArrayList<Produto>) session.getAttribute("carrinho");
//        if (!request.getParameter("id_produto").isEmpty() && request.getParameter("id_produto").matches("\\d+")) {
//            produto = new ProdutoDao().pesquisarPorId(Integer.parseInt(request.getParameter("id_produto")));
//            int qtd = Integer.parseInt(request.getParameter("quantidade_produto"));
//            if (produto != null) {
//                if(carrinhoSession == null){
//                    carrinhoSession = new ArrayList<Produto>();
//                }
//                for (int i = 0; i < qtd; i++) {
//                    carrinhoSession.add(produto);
//                }
//                session.setAttribute("carrinho", carrinhoSession);
//            }
//            response.sendRedirect(request.getContextPath() + "/vender");
//
//        }
    }
}
