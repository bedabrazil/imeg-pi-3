/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
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
@WebServlet(name = "MeusDadosServlet", urlPatterns = {"/meusdados", "/meusdados/editar"})
public class MeusDadosServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        request.getRequestDispatcher("/WEB-INF/views/meusdados/editar.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if (request.getQueryString() == null && request.getParameter("id_usuario").matches("\\d+")) {
            ArrayList<String> mensagens = new ArrayList<>();
            if (request.getParameter("nome_usuario").isEmpty()) {
                mensagens.add("Nome de Funcionário não pode ser vazio");
            }
            if (!request.getParameter("senha_nova_usuario").isEmpty() || !request.getParameter("confirmar_nova_senha_usuario").isEmpty()) {
                if (!request.getParameter("senha_nova_usuario").equals(request.getParameter("confirmar_nova_senha_usuario"))) {
                    mensagens.add("Nova Senha e Cofirmar Nova Senha devem ser iguais.");
                }
            }

            if (mensagens.size() > 0) {
                request.setAttribute("error", true);
                request.setAttribute("mensagens", mensagens);
                processRequest(request, response);
                return;
            }
            int id = Integer.parseInt(request.getParameter("id_usuario"));
            if (id == usuario.getId()) {

                if (request.getParameter("senha_nova_usuario").isEmpty() && !usuario.getNome().equals(request.getParameter("nome_usuario"))) {
                    if (new FuncionarioDao().alterarMeusDados(new Funcionario(id, request.getParameter("nome_usuario"), null))) {
                        usuario.setNome(request.getParameter("nome_usuario"));
                        session.setAttribute("success", true);
                        session.setAttribute("msg_success", "Dados alterados com sucesso");
                        response.sendRedirect(request.getContextPath() + "/bemvindo");
                    }
                } else if (new FuncionarioDao().alterarMeusDados(new Funcionario(id, request.getParameter("nome_usuario"), request.getParameter("senha_nova_usuario")))) {
                    usuario.setNome(request.getParameter("nome_usuario"));
                    session.setAttribute("success", true);
                    session.setAttribute("msg_success", "Dados alterados com sucesso");
                    response.sendRedirect(request.getContextPath() + "/bemvindo");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        }
    }

}
