/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.EstadoDao;
import br.senac.tads.pi3.imeg.dao.UnidadeDao;
import br.senac.tads.pi3.imeg.entity.Estado;
import br.senac.tads.pi3.imeg.entity.Unidade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "NovaUnidadeServlet", urlPatterns = "/unidades/novo")
public class NovaUnidadeServlet extends HttpServlet {

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

        request.getRequestDispatcher("/WEB-INF/views/unidades/novo.jsp").forward(request, response);
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

        //inicia uma sessao
        HttpSession session = request.getSession(true);
        ArrayList<String> mensagens = new ArrayList<>();

        //Instancia o DAO
        UnidadeDao uDao = new UnidadeDao();

        session.setAttribute("error", false);
        request.setCharacterEncoding("UTF-8");

        if (request.getParameter("nome-unidade").isEmpty()) {
            mensagens.add("O campo *Nome* não pode ser vazio.");
        }
        if (!request.getParameter("estado-id").matches("\\d+") || request.getParameter("estado-id").equals("0")) {
            mensagens.add("Selecione uma cidade.");
        }

        if (mensagens.size() > 0) {
            session.setAttribute("error", true);
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
        }

        String nome = request.getParameter("nome-unidade");
        int idCidade = Integer.parseInt(request.getParameter("estado-id"));
        boolean status = Boolean.parseBoolean(request.getParameter("ativo_unidades"));
        boolean matriz = Boolean.parseBoolean(request.getParameter("ativo_matriz"));
        
        if (!nome.isEmpty() && idCidade > 0) {
            EstadoDao eDao = new EstadoDao();
            
            uDao.resetaMatrizes();
            
            Unidade unidade = new Unidade(nome, eDao.pesquisarPorId(idCidade), status, matriz);
            if (uDao.adicionar(unidade)) {
                mensagens.clear();
                session.setAttribute("msg_success", "Unidade " + nome + " incluída com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect(request.getContextPath() + "/unidades");
            }
        }
    }
}
