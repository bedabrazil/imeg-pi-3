/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import java.io.IOException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/views/login/index.jsp").forward(request, response);
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
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("funcionario") == null) {
            processRequest(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/home");
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
//        Cargo cargo = new CargoDao().pesquisarPorId(1);
//        Unidade unidade = new UnidadeDao().pesquisarPorId(1);
//        Acesso acesso = new AcessoDao().pesquisarPorId(2);
//        Funcionario funcionario = new Funcionario("MARCIO", cargo, unidade, acesso, "marcio@mail.com", "12345");
//        HttpSession session = request.getSession(true);
//        session.setAttribute("funcionario", funcionario);

        String email = request.getParameter("email_funcionario");
        String senha = request.getParameter("senha_funcionario");
        // Implementar aqui a validação do usuário com os dados
        // armazenados no banco de dados.
    }
    private Funcionario validar(String email, String senha) {
      Funcionario funcionario = new FuncionarioDao().pesquisarPorEmail(email);
//      if (funcionario != null && funcionario.autenticar(email, senha)) {
//        return funcionario;
//      }
      return null;
    }

    

}
