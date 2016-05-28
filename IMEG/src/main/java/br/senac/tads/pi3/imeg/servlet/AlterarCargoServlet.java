/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CargoDao;
import br.senac.tads.pi3.imeg.entity.Cargo;
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
 * @author developer
 */
@WebServlet(name = "AlterarCargoServlet", urlPatterns = "/cargos/editar")
public class AlterarCargoServlet extends HttpServlet {

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
//        request.setAttribute("acessos", acessos);
        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Cargo cargo = new CargoDao().pesquisarPorId(id);
                request.setAttribute("cargo", cargo);
            }
            request.getRequestDispatcher("/WEB-INF/views/cargos/editar.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cargos");
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
        String nome = request.getParameter("nome_cargo");

        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("O campo *Nome* não pode ser vazio.");
        }
        
        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        // pega o nome do cargo do formulário
        if (request.getParameter("id_cargo") != null) {
            Cargo cargo = new Cargo();
            cargo.setId(Integer.parseInt(request.getParameter("id_cargo")));
            cargo.setNome(request.getParameter("nome_cargo"));
            cargo.setStatus(Boolean.parseBoolean(request.getParameter("ativo")));

            if (new CargoDao().alterar(cargo)) {
                mensagens.clear();
                session.setAttribute("success", true);
                session.setAttribute("msg_success", "Cargo <strong>" + cargo.getNome() + "</strong> alterado com sucesso.");
                response.sendRedirect(request.getContextPath() + "/cargos");
            }
        }

    }
}
