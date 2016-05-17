/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.AcessoDao;
import br.senac.tads.pi3.imeg.entity.Acesso;
import br.senac.tads.pi3.imeg.dao.CargoDao;
import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.dao.UnidadeDao;
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
@WebServlet(name = "NovoFuncionarioServlet", urlPatterns = "/funcionarios/novo")
public class NovoFuncionarioServlet extends HttpServlet {

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

        ArrayList<Funcionario> funcionarios = new FuncionarioDao().listar();
        request.setAttribute("funcionarios", funcionarios);

        ArrayList<Cargo> cargo = new CargoDao().listar();
        request.setAttribute("cargos", cargo);

        ArrayList<Unidade> unidade = new UnidadeDao().listar();
        request.setAttribute("unidades", unidade);

        ArrayList<Acesso> acessos = new AcessoDao().listar();
        request.setAttribute("acessos", acessos);

        request.getRequestDispatcher("/WEB-INF/views/funcionarios/novo.jsp").forward(request, response);

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

        //instancio o DAO
        FuncionarioDao fDao = new FuncionarioDao();
        CargoDao cDao = new CargoDao();
        UnidadeDao uDao = new UnidadeDao();
        AcessoDao aDao = new AcessoDao();

        session.setAttribute("error", false);

        if (request.getParameter("nome_funcionario").isEmpty()) {
            mensagens.add("Nome não pode ser vazio.");
        }
        if (request.getParameter("email_funcionario").isEmpty()) {
            mensagens.add("*Email* não pode ser vazio.");
        }
        if (request.getParameter("senha_funcionario").isEmpty()) {
            mensagens.add("*Senha* não pode ser vazio.");
        }
        if (request.getParameter("confSenha_funcionario").isEmpty()) {
            mensagens.add("*Confirmar Senha* não pode ser vazio.");
        }
        if (!request.getParameter("cargo_id").matches("\\d+") || request.getParameter("cargo_id").equals("0")) {
            mensagens.add("É preciso selecionar um Cargo.");
        }
        if (!request.getParameter("unidade_id").matches("\\d+") || request.getParameter("unidade_id").equals("0")) {
            mensagens.add("É preciso selecionar uma Unidade.");
        }
        if (!request.getParameter("acesso_id").matches("\\d+") || request.getParameter("acesso_id").equals("0")) {
            mensagens.add("É preciso selecionar um tipo de permissão.");
        }
        if (!request.getParameter("senha_funcionario").equals(request.getParameter("senha_funcionario"))){
            mensagens.add("*Senha* deve coincidir com *Confirmar Senha*.");
        }  
        if (mensagens.size() > 0) {
            request.setAttribute("error", true);
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }

        String nome = request.getParameter("nome_funcionario");
        int cargo = Integer.parseInt(request.getParameter("cargo_id"));
        int unidade = Integer.parseInt(request.getParameter("unidade_id"));
        String email = request.getParameter("email_funcionario");
        int acesso = Integer.parseInt(request.getParameter("acesso_id"));
        String senha = request.getParameter("senha_funcionario");
        String confSenha = request.getParameter("confSenha_funcionario");
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));

        if (nome.isEmpty() && cargo <= 0 && unidade <= 0 && email.isEmpty() && acesso <= 0 && !(senha.equals(confSenha))) {
            session.setAttribute("msg_error", "Campos não prenchidos.");
            session.setAttribute("error", true);
            request.getRequestDispatcher("/WEB-INF/views/funcionarios/novo.jsp").forward(request, response);
        } else if (fDao.adicionar(new Funcionario(nome, cDao.pesquisarPorId(cargo), uDao.pesquisarPorId(unidade), aDao.pesquisarPorId(acesso), email, senha, status))) {
            session.setAttribute("msg_success", "Funcionário incluído com sucesso.");
            session.setAttribute("success", true);
            response.sendRedirect(request.getContextPath() + "/funcionarios");
        } else {
            session.setAttribute("msg_error", "Erro na transação. Contate o administrador do sistema.");
            session.setAttribute("error", true);
        }
    }
}
