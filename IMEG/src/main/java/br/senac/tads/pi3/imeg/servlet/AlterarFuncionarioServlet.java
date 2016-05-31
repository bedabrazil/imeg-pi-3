/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.AcessoDao;
import br.senac.tads.pi3.imeg.dao.CargoDao;
import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.dao.UnidadeDao;
import br.senac.tads.pi3.imeg.entity.Acesso;
import br.senac.tads.pi3.imeg.entity.Cargo;
import br.senac.tads.pi3.imeg.entity.Funcionario;
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
 * @author iosato
 */
@WebServlet(name = "AlterarFuncionarioServlet", urlPatterns = "/funcionarios/editar")
public class AlterarFuncionarioServlet extends HttpServlet {

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
                Funcionario funcionario = new FuncionarioDao().pesquisarPorId(id);
                request.setAttribute("funcionario", funcionario);
            }

            ArrayList<Funcionario> funcionarios = new FuncionarioDao().listar();
            request.setAttribute("funcionarios", funcionarios);

            ArrayList<Cargo> cargo = new CargoDao().listar();
            request.setAttribute("cargos", cargo);

            ArrayList<Unidade> unidade = new UnidadeDao().listar();
            request.setAttribute("unidades", unidade);

            ArrayList<Acesso> acessos = new AcessoDao().listar();
            request.setAttribute("acessos", acessos);

            request.getRequestDispatcher("/WEB-INF/views/funcionarios/editar.jsp").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/funcionarios");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //inicia uma sessao
        HttpSession session = request.getSession(true);
        ArrayList<String> mensagens = new ArrayList<>();

        //instacio o DAO
        FuncionarioDao fDao = new FuncionarioDao();
        CargoDao cDao = new CargoDao();
        UnidadeDao uDao = new UnidadeDao();
        AcessoDao aDao = new AcessoDao();

        session.setAttribute("error", false);
                
        if (request.getParameter("nome_funcionario").isEmpty()) {
//            request.setAttribute("nome_funcionario", nome_funcionario);
            mensagens.add("O campo *Nome* não pode ser vazio.");
        }
        if (request.getParameter("email_funcionario").isEmpty()) {
            mensagens.add("O campo *Email* não pode ser vazio.");
        }
        if (!request.getParameter("email_funcionario").matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            mensagens.add("*Email* inválido.");
        }

        if (!request.getParameter("cargo_id").matches("\\d+") || request.getParameter("cargo_id").equals("0")) {
            mensagens.add("Selecione um cargo.");
        }
        if (!request.getParameter("unidade_id").matches("\\d+") || request.getParameter("unidade_id").equals("0")) {
            mensagens.add("Selecione uma unidade.");
        }
        if (!request.getParameter("acesso_id").matches("\\d+") || request.getParameter("acesso_id").equals("0")) {
            mensagens.add("Selecione um tipo de permissão.");
        }
        
        if (mensagens.size() > 0) {
            request.setAttribute("error", true);
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        
        int id = Integer.parseInt(request.getParameter("id_funcionario"));
        String nome = request.getParameter("nome_funcionario");
        int cargo = Integer.parseInt(request.getParameter("cargo_id"));
        int unidade = Integer.parseInt(request.getParameter("unidade_id"));
        String email = request.getParameter("email_funcionario");
        int acesso = Integer.parseInt(request.getParameter("acesso_id"));
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        
        if (nome.isEmpty() || cargo <= 0 || unidade <= 0 || email.isEmpty() || acesso <= 0) {
            session.setAttribute("msg_error", "Campos não prenchidos.");
            session.setAttribute("error", true);
            request.getRequestDispatcher("/WEB-INF/views/funcionarios/editar.jsp").forward(request, response);
        } else if (fDao.alterar(new Funcionario(id, nome, cDao.pesquisarPorId(cargo), uDao.pesquisarPorId(unidade), aDao.pesquisarPorId(acesso), email,status))) {
            mensagens.clear();
            session.setAttribute("msg_success", "Funcionário alterado com sucesso.");
            session.setAttribute("success", true);
            response.sendRedirect(request.getContextPath() + "/funcionarios");
        } else {
            session.setAttribute("msg_error", "Erro na transação. Contate o administrador do sistema.");
            session.setAttribute("error", true);
        }
    }
}
