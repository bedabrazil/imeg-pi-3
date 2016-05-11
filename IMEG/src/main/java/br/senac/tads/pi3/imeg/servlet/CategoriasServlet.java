/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.entity.Categoria;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Categoria> categorias = new CategoriaDao().listar();
        request.setAttribute("categorias", categorias);
        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Categoria categoria = new CategoriaDao().editarCategoria(id);
                request.setAttribute("categoria", categoria);
            }
        }
        
        request.getRequestDispatcher("WEB-INF/views/categorias/index.jsp").forward(request, response);
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
        String msg_error = (String) session.getAttribute("msg_error");
        String msg_success = (String) session.getAttribute("msg_success");
        if (msg_error != null) {
            session.removeAttribute("msg_error");
            session.removeAttribute("error");
            response.sendRedirect("categorias");
        } else if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
            response.sendRedirect("categorias");
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
        if (request.getParameter("id_categoria") != null) {
            Categoria c = new Categoria();
            c.setId(Integer.parseInt(request.getParameter("id_categoria")));
            c.setNome(request.getParameter("nome_categoria"));
            c.setStatus(Boolean.parseBoolean(request.getParameter("ativo")));
            if (cDao.alterarCategoria(c)) {
                session.setAttribute("msg_success", "Categoria " + c.getNome() + " alterada com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect("categorias");
                return;
            }
        }

        String nome = request.getParameter("nome_categoria");
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        if (nome != null && nome.isEmpty()) {
            session.setAttribute("msg_error", "Nome não pode ser vazio.");
            session.setAttribute("error", true);
            processRequest(request, response);
        } else if (cDao.incluirCategoria(new Categoria(nome, status))) {
            session.setAttribute("msg_success", "Categoria " + nome + " incluída com sucesso.");
            session.setAttribute("success", true);
            response.sendRedirect("categorias");
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
