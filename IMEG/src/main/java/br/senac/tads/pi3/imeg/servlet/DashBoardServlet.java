/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import au.com.bytecode.opencsv.CSVWriter;
import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "DashBoardServlet", urlPatterns = {"/dashboard", "/painel"})
public class DashBoardServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");

        ArrayList<RelatorioVenda> maisVendidos = null;
        if (usuario != null && usuario.getUnidade().isMatriz()) {
            maisVendidos = new RelatorioDao().listarTresMaisVendidos();
        } else if (usuario.getAcesso().getNome().equals("GERENTE") || usuario.getAcesso().getNome().equals("ADMIN")) {
            maisVendidos = new RelatorioDao().listarMaisVendidosFilial(usuario);
        } else if (usuario.getAcesso().getNome().equals("VENDEDOR")) {
            maisVendidos = new RelatorioDao().listarMaisVendidosVendedor(usuario);
        }
        request.setAttribute("maisVendidos", maisVendidos);
        request.getRequestDispatcher("/WEB-INF/views/home/bemvindo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/dashboard");

        ArrayList<String> mensagens = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        if (!request.getParameter("date-ini-mais-vendidos").isEmpty()) {
            mensagens.add("O campo data inicio não pode ser vazio.");
        }
        if (!request.getParameter("date-end-mais-vendidos").isEmpty()) {
            mensagens.add("O campo data fim não pode ser vazio.");
        }

        String dt_inicio = (request.getParameter("date-ini-mais-vendidos"));
        String dt_fim = (request.getParameter("date-end-mais-vendidos"));// recebe os valores de data em String

        try {
            java.sql.Date dataInicio = new java.sql.Date(format.parse(dt_inicio).getTime());
            java.sql.Date dataFim = new java.sql.Date(format.parse(dt_fim).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DashBoardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }// converte a data de String para sql do Date

        CSVWriter writer = new CSVWriter(new FileWriter("Relatorio.csv"), '\t');

        writer.close();
    }
}
