/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.AcessoDao;
import br.senac.tads.pi3.imeg.dao.EstadoDao;
import br.senac.tads.pi3.imeg.dao.UnidadeDao;
import br.senac.tads.pi3.imeg.entity.Acesso;
import br.senac.tads.pi3.imeg.entity.Estado;
import br.senac.tads.pi3.imeg.entity.Unidade;
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
 * @author pc
 */
@WebServlet(name = "AlterarUnidadeServlet", urlPatterns = {"/unidades/editar"})
public class AlterarUnidadeServlet extends HttpServlet {

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
//        ArrayList<Acesso> acessos = new AcessoDao().listar();
//        request.setAttribute("acessos", acessos
        ArrayList<Estado> estados = new EstadoDao().listar();
        request.setAttribute("estados", estados);

        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Unidade unidade = new UnidadeDao().pesquisarPorId(id);
                request.setAttribute("unidade", unidade);
            }
            request.getRequestDispatcher("/WEB-INF/views/unidades/editar.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/unidades");

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

        ArrayList<String> mensagens = new ArrayList<>();
        HttpSession session = request.getSession(true);
        session.setAttribute("success", false);

        String nome = request.getParameter("nome_cargo");
        int acesso_id = Integer.parseInt(request.getParameter("acesso_id"));

        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("Nome não pode ser vazio.");
        }
        if (acesso_id == 0) {
            request.setAttribute("error", true);
            mensagens.add("Selecione um Tipo de Permissão.");

        }
        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }

        if (request.getParameter("estado-id") != null) {
            Unidade unidade = new Unidade();
            unidade.setId(Integer.parseInt(request.getParameter("estado-id")));
            unidade.setNome(request.getParameter("nome-unidade"));

            if (new UnidadeDao().alterar(unidade)) {
                mensagens.clear();
                session.setAttribute("success", true);
                session.setAttribute("msg_success", "Unidade <strong>" + unidade.getNome() + "</strong> alterado com sucesso.");
                response.sendRedirect("unidade");
            }
        }

    }

}
