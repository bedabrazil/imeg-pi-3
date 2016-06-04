/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.ItensSaidaDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.ItemSaida;
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
 * @author Márcio Soares <marcio@mail.com>
 */
@WebServlet(name = "ProdutosVendidosServlet", urlPatterns = {"/vendidos"})
public class ProdutosVendidosServlet extends HttpServlet {


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
        ArrayList<ItemSaida> itensSaida = null;
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if(usuario.getAcesso().getNome().equals("GERENTE") && !usuario.getUnidade().isMatriz()){
          itensSaida = new ItensSaidaDao().produtosVendidosPorUnidade(usuario);
        }else if (usuario.getAcesso().getNome().equals("VENDEDOR")){
            itensSaida = new ItensSaidaDao().produtosVendidosPorVendedor(usuario);
        }else{
            itensSaida = new ItensSaidaDao().produtosVendidos();
        }
        request.setAttribute("itensSaida", itensSaida);
        request.getRequestDispatcher("/WEB-INF/views/vendas/vendidos.jsp").forward(request, response);
        
    }
}
