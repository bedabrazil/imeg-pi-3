/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.ItensEntradaDao;
import br.senac.tads.pi3.imeg.dao.ItensEntradaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author marcio.soares <marcio@mail.com>
 */


@WebServlet(name = "ProdutosServlet", urlPatterns = {"/produtos", "/produtos/"})
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Produto> produtos = null;
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if(usuario != null && usuario.getUnidade().isMatriz()){
            produtos = new ProdutoDao().listarMatriz();
        }else if(usuario != null){
            produtos = new ItensEntradaDao().listarProdutosVendidos(usuario);
        }
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("/WEB-INF/views/produtos/index.jsp").forward(request, response);
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
        processRequest(request, response);
        
        HttpSession session = request.getSession();
        String msg_success = (String) session.getAttribute("msg_success");
        
        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
        }
    }

}
