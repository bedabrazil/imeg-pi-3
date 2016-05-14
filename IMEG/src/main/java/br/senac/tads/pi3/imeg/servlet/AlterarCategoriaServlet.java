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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
@WebServlet(name = "AlterarCategoriaServlet", urlPatterns = "/categorias/editar")
public class AlterarCategoriaServlet extends HttpServlet {

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
        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Categoria categoria = new CategoriaDao().pesquisarPorId(id);
                request.setAttribute("categoria", categoria);
            }
            request.getRequestDispatcher("/WEB-INF/views/categorias/editar.jsp").forward(request, response);
        }else{
            response.sendRedirect("categorias");
        }
        
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
        ArrayList<String> mensagens = new ArrayList<>();
        HttpSession session = request.getSession(true);
        session.setAttribute("success", false);
        //instacio o DAO
        String nome = request.getParameter("nome_categoria");

        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("Nome não pode ser vazio.");
        }
        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        // pega o nome do cargo do formulário
        if (request.getParameter("id_categoria") != null) {
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(request.getParameter("id_categoria")));
            categoria.setNome(request.getParameter("nome_categoria"));
            categoria.setStatus(Boolean.parseBoolean(request.getParameter("ativo")));

            if (new CategoriaDao().alterar(categoria)) {
                mensagens.clear();
                session.setAttribute("success", true);
                session.setAttribute("msg_success", "Categoria <strong>" + categoria.getNome() + "</strong> alterado com sucesso.");
                response.sendRedirect("categorias");
            }
        }
    }

}
