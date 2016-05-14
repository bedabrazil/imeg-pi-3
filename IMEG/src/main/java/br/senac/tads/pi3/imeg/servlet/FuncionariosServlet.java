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
 * @author marcio.soares <marcio@mail.com>
 */
@WebServlet(name = "FuncionariosServlet", urlPatterns = "/funcionarios")
public class FuncionariosServlet extends HttpServlet {

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
        ArrayList<Funcionario> funcionarios = new FuncionarioDao().listar();
        request.setAttribute("funcionarios", funcionarios);
        request.getRequestDispatcher("WEB-INF/views/funcionarios/index.jsp").forward(request, response);

        HttpSession session = request.getSession();
        String msg_success = (String) session.getAttribute("msg_success");

        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
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
//        processRequest(request, response);
        
//        //inicia uma sessao
//        HttpSession session = request.getSession(true);
//        session.setAttribute("error", false);
//        session.setAttribute("success", false);        
//                
//        //instacio o DAO
//        FuncionarioDao fDao = new FuncionarioDao();
//        CargoDao cDao = new CargoDao();
//        UnidadeDao uDao = new UnidadeDao();
//        AcessoDao aDao = new AcessoDao();
//        
//
//        
//        if (request.getParameter("nome_funcionario") != null) {
//            Funcionario f = new Funcionario();           
//            f.setNome(request.getParameter("nome_funcionario"));
//            if (fDao.alterar(f)) {
//                session.setAttribute("msg_success", "Funcionário " + f.getNome() + " alterado com sucesso.");
//                session.setAttribute("success", true);
//                response.sendRedirect("funcionarios");
//                return;
//            }
//        }
//        int acesso_id = Integer.parseInt(request.getParameter("acesso_id"));
//        String nome = request.getParameter("nome-funcionario");
//        int cargo = Integer.parseInt(request.getParameter("cargo-id"));
//        int unidade = Integer.parseInt(request.getParameter("unidade-id"));
//        //seta uma  erro false
//        session.setAttribute("error", false);
//        if (nome != null && nome.isEmpty() && cargo<=0 && unidade<=0) {
//            session.setAttribute("msg_error", "Campos não prenchidos.");
//            session.setAttribute("error", true);
//            request.getRequestDispatcher("//WEB-INF/views/funcionarios/novo.jsp").forward(request, response);
//        }else{
//            if (fDao.adicionar(new Funcionario(nome, cDao.pesquisarPorId(cargo), uDao.pesquisarPorId(unidade), new AcessoDao().pesquisarPorId(acesso_id) , "TesteHardCode@imeg.com"))) {
//            session.setAttribute("msg_success", "Funcionário incluído com sucesso.");
//            session.setAttribute("success", true);            
//            response.sendRedirect("funcionarios");
//            }
//            else{
//                session.setAttribute("msg_error", "Erro na transação. Contate o administrador do sistema.");
//            session.setAttribute("error", true);
//            }
//        }
    }
}
