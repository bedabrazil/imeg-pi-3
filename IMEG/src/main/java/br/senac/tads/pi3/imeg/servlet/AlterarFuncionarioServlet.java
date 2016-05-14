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
import br.senac.tads.pi3.imeg.entity.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlterarFuncionarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarFuncionarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        processRequest(request, response);

        //inicia uma sessao
        HttpSession session = request.getSession(true);
        session.setAttribute("error", false);
        session.setAttribute("success", false);

        //instacio o DAO
        FuncionarioDao fDao = new FuncionarioDao();
        CargoDao cDao = new CargoDao();
        UnidadeDao uDao = new UnidadeDao();

        if (request.getParameter("nome-funcionario") != null) {
            Funcionario f = new Funcionario();
            f.setNome(request.getParameter("nome-funcionario"));
            if (fDao.alterar(f)) {
                session.setAttribute("msg_success", "Funcionário " + f.getNome() + " alterado com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect("funcionarios");
                return;
            }
        }

        String nome = request.getParameter("nome-funcionario");
        int cargo = Integer.parseInt(request.getParameter("cargo-id"));
        int unidade = Integer.parseInt(request.getParameter("unidade-id"));
        int acesso_id = Integer.parseInt(request.getParameter("acesso_id"));
        
        //seta uma  erro false
        session.setAttribute("error", false);
        if (nome != null && nome.isEmpty() && cargo <= 0 && unidade <= 0) {
            session.setAttribute("msg_error", "Campos não prenchidos.");
            session.setAttribute("error", true);
            request.getRequestDispatcher("//WEB-INF/views/funcionarios/novo.jsp").forward(request, response);
        } else if (fDao.adicionar(new Funcionario(nome, cDao.pesquisarPorId(cargo), uDao.pesquisarPorId(unidade), new AcessoDao().pesquisarPorId(acesso_id), "TesteHardCode@imeg.com", "Implementar igual Novo"))) {
            session.setAttribute("msg_success", "Funcionário incluído com sucesso.");
            session.setAttribute("success", true);
            response.sendRedirect("funcionarios");
        } else {
            session.setAttribute("msg_error", "Erro na transação. Contate o administrador do sistema.");
            session.setAttribute("error", true);
        }
    }
}
