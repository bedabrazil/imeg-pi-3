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
@WebServlet(name = "NovaCategoriaServlet", urlPatterns = "/categorias/novo")
public class NovaCategoriaServlet extends HttpServlet {

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

        request.getRequestDispatcher("/WEB-INF/views/categorias/novo.jsp").forward(request, response);

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
        HttpSession session = request.getSession(true);
        ArrayList<String> mensagens = new ArrayList<>();

        session.setAttribute("error", false);
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome_categoria");

        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("O campo *Nome* não pode ser vazio.");
        }
        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        if (!nome.isEmpty()) {
            Categoria categoria = new Categoria(nome, status);
            if (!new CategoriaDao().pesquisarPorNome(categoria)) {
                if (new CategoriaDao().adicionar(categoria)) {
                    mensagens.clear();
                    session.setAttribute("msg_success", "Categoria " + nome + " incluído com sucesso.");
                    session.setAttribute("success", true);
                    response.sendRedirect(request.getContextPath() + "/categorias");
                }
            } else {
                request.setAttribute("error", true);
                mensagens.add("Nome já existe.");
                request.setAttribute("mensagens", mensagens);
                processRequest(request, response);
                return;
            }
        }
    }

}
