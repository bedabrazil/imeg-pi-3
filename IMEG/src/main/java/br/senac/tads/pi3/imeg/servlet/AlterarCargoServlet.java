/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.AcessoDao;
import br.senac.tads.pi3.imeg.dao.CargoDao;
import br.senac.tads.pi3.imeg.entity.Acesso;
import br.senac.tads.pi3.imeg.entity.Cargo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author developer
 */
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
        ArrayList<Cargo> cargos = new CargoDao().listar();
        request.setAttribute("cargos", cargos);
        ArrayList<Acesso> acessos = new AcessoDao().listar();
        request.setAttribute("acessos", acessos);
        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Cargo cargo = new CargoDao().pesquisarPorId(id);
                request.setAttribute("cargo", cargo);

            }
        }

        request.getRequestDispatcher("WEB-INF/views/cargos/editar.jsp").forward(request, response);

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
            response.sendRedirect("cargos");
        } else if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
            response.sendRedirect("cargos");
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
        session.setAttribute("error", false);
        session.setAttribute("success", false);

        //instacio o DAO
        CargoDao cDao = new CargoDao();

        // pega o nome do cargo do formulário
        if (request.getParameter("id_cargo") != null) {
            Cargo c = new Cargo();
            c.setId(Integer.parseInt(request.getParameter("id_cargo")));
            c.setNome(request.getParameter("nome_cargo"));
            c.setStatus(Boolean.parseBoolean(request.getParameter("ativo")));
            c.setAcesso(new AcessoDao().pesquisarPorId(Integer.parseInt(request.getParameter("acesso_id"))));
            if (cDao.alterar(c)) {
                session.setAttribute("msg_success", "Cargo <strong>" + c.getNome() + "</strong> alterado com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect("cargos");
                return;
            }
        }

        String nome = request.getParameter("nome_cargo");
        String acesso_id = request.getParameter("acesso_id");
        if (nome.isEmpty()) {
            session.setAttribute("msg_error", "Nome não pode ser vazio.");
            session.setAttribute("error", true);
            processRequest(request, response);
        }
        if (acesso_id.equals("0")) {
            session.setAttribute("msg_error", "Selecione um Tipo de Permissão.");
            session.setAttribute("error", true);
            processRequest(request, response);
        }
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        int id_acesso = Integer.parseInt(acesso_id);
        if (!nome.isEmpty() && id_acesso > 0) {
            Acesso acesso = new AcessoDao().pesquisarPorId(id_acesso);

            if (cDao.adicionar(new Cargo(nome, status, acesso))) {
                session.setAttribute("msg_success", "Cargo " + nome + " incluído com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect("cargos");
            }
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
