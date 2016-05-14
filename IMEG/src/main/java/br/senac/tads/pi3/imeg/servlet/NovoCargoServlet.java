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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
@WebServlet(name = "NovoCargoServlet", urlPatterns = "/cargos/novo")
public class NovoCargoServlet extends HttpServlet {

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
        ArrayList<Acesso> acessos = new AcessoDao().listar();
        request.setAttribute("acessos", acessos);

        request.getRequestDispatcher("/WEB-INF/views/cargos/novo.jsp").forward(request, response);
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
        
        //instacio o DAO

        String nome = request.getParameter("nome_cargo");
        String acesso_id = request.getParameter("acesso_id");
        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("Nome não pode ser vazio.");
        }
        if (acesso_id.equals("0")) {
            mensagens.add("Selecione um Tipo de Permissão.");
            request.setAttribute("error", true);
        }
        if(mensagens.size() > 0){
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        int id_acesso = Integer.parseInt(acesso_id);
        if (!nome.isEmpty() && id_acesso > 0) {
            Acesso acesso = new AcessoDao().pesquisarPorId(id_acesso);
            Cargo cargo = new Cargo(nome, status, acesso);
            if (new CargoDao().adicionar(cargo)) {
                session.setAttribute("msg_success", "Cargo " + nome + " incluído com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect("cargos");
            }
        }

    }
}
