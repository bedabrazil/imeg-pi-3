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
       
        request.getRequestDispatcher("/WEB-INF/views/funcionarios/index.jsp").forward(request, response);

        HttpSession session = request.getSession();
        String msg_success = (String) session.getAttribute("msg_success");

        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
        }
    }
}
