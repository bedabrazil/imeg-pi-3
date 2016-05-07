/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.entity.Categoria;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
public class CategoriasServlet extends HttpServlet {

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
        request.getRequestDispatcher("WEB-INF/views/categorias/novo.jsp").forward(request, response);
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
        String mensagem = (String) session.getAttribute("msg");
        boolean error = (boolean) session.getAttribute("error");
        if (mensagem != null) {
            session.removeAttribute("msg");
            session.removeAttribute("error");
        } else {
            response.sendRedirect("home");
        }
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
        //inicia uma sessao
        HttpSession session = request.getSession(true);
        //instacio o DAO
        CategoriaDao cDao = new CategoriaDao();
        // pega o nome da categoria do formulário
        String nome = request.getParameter("nome_categoria");
        //seta uma  erro false
        session.setAttribute("error", false);
        if (nome.isEmpty()) {
            session.setAttribute("msg", "Nome não pode ser vazio.");
            session.setAttribute("error", true);
            request.getRequestDispatcher("/WEB-INF/views/categorias/novo.jsp").forward(request, response);
        } else if (cDao.incluirCategoria(new Categoria(nome, true))) {
            session.setAttribute("msg", "Categoria " + nome + " incluída com sucesso.");
            response.sendRedirect("sucesso");
        } else {
            session.setAttribute("msg", "Algo deu errado.\nTente novamente mais tarde.");
            session.setAttribute("error", true);
            request.getRequestDispatcher("/WEB-INF/views/categorias/novo.jsp").forward(request, response);
        }

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
