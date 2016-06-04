/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.tads.pi3.imeg.dao.EstadoDao;
import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.dao.UnidadeDao;
import br.senac.tads.pi3.imeg.entity.Estado;
import br.senac.tads.pi3.imeg.entity.Unidade;

/**
 *
 * @author pc
 */
@WebServlet(name = "AlterarUnidadeServlet", urlPatterns = {"/unidades/editar"})
public class AlterarUnidadeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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

        ArrayList<Estado> estados = new EstadoDao().listar();
        request.setAttribute("estados", estados);

        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Unidade unidade = new UnidadeDao().pesquisarPorId(id);
                request.setAttribute("unidade", unidade);
            }
            request.getRequestDispatcher("/WEB-INF/views/unidades/editar.jsp").forward(request, response);
            HttpSession session = request.getSession(true);
            boolean success = (boolean) session.getAttribute("success");
            if (success) {
                session.removeAttribute("msg_success");
                session.removeAttribute("success");
            }

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

        HttpSession session = request.getSession(true);
        ArrayList<String> mensagens = new ArrayList<>();
        FuncionarioDao fDao = new FuncionarioDao();


        if (request.getParameter("nome-unidade").isEmpty()) {
            mensagens.add("O campo *Nome* não pode ser vazio.");
        }
        if (!request.getParameter("estado-id").matches("\\d+") || request.getParameter("estado-id").equals("0")) {
            mensagens.add("Selecione uma cidade.");
        }

        if (Boolean.parseBoolean(request.getParameter("ativo_matriz"))) {
            if (!fDao.estaEmMatriz(Integer.parseInt(request.getParameter("unidade_id")))) {
                mensagens.add("Erro ao ativar Matriz. Esta unidade não possui um usuário ADM ativo.");
            }
        }

        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            request.setAttribute("error", true);
            processRequest(request, response);
            return;
        }

        int id = Integer.parseInt(request.getParameter("unidade_id"));
        String nome = request.getParameter("nome-unidade");
        int estado = Integer.parseInt(request.getParameter("estado-id"));
        boolean status = Boolean.parseBoolean(request.getParameter("ativo_unidades"));
        boolean matriz = Boolean.parseBoolean(request.getParameter("ativo_matriz"));

        if (id > 0 && !(nome.isEmpty()) && estado > 0) {

            EstadoDao eDao = new EstadoDao();
            UnidadeDao uDao = new UnidadeDao();

            uDao.resetaMatrizes();

            if (uDao.alterar(new Unidade(id, nome, eDao.pesquisarPorId(estado), status, matriz))) {
                mensagens.clear();
                session.setAttribute("msg_success", "Unidade alterada com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect(request.getContextPath() + "/unidades");
            }
        }

    }

}
