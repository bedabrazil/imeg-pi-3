/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eilane
 */
@WebServlet(name = "InserirProdutoServlet", urlPatterns = {"/produtos/inserir"})
public class InserirProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //  ArrayList<Categoria> categorias = new CategoriaDao().listar();
        // request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/WEB-INF/views/produtos/inserir.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

        HttpSession session = request.getSession(true);
        String nomeProduto = request.getParameter("nm_produto");
        String preco_custo_produto = request.getParameter("preco_custo_produto");
        String quantidade = request.getParameter("quantidade");

        HistoricoEntrada histEntrada = new HistoricoEntrada();

//        histEntrada.setPreco_custo(Double.parseDouble(preco_custo_produto));
        histEntrada.setQtde_produtos(Integer.parseInt(quantidade));

      //produto.setCategoria(produto.getCategoria());
//        new HistoricoEntradaDao().adicionar(histEntrada);

        session.setAttribute("success", true);
        response.sendRedirect(request.getContextPath() + "/produtos/inserir");

    }

}
