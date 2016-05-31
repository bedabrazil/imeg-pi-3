/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Categoria;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.ItemVenda;
import br.senac.tads.pi3.imeg.entity.ListaItensVenda;
import br.senac.tads.pi3.imeg.entity.Produto;
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
 * @author Eilane
 */
@WebServlet(name = "VendasServlet", urlPatterns = {"/vender"})
public class VendasServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        ArrayList<Produto> produtos = new ProdutoDao().produtosComSaldo();
        request.setAttribute("produtos", produtos);
        
        request.getRequestDispatcher("/WEB-INF/views/vendas/index.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
              
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Produto produto = null;
        ArrayList<Produto> carrinhoSession = (ArrayList<Produto>) session.getAttribute("carrinho");
        if (!request.getParameter("id_produto").isEmpty() && request.getParameter("id_produto").matches("\\d+")) {
            produto = new ProdutoDao().pesquisarPorId(Integer.parseInt(request.getParameter("id_produto")));
            int qtd = Integer.parseInt(request.getParameter("quantidade_produto"));
            if (produto != null) {
                if(carrinhoSession == null){
                    carrinhoSession = new ArrayList<>();
                }
                for (int i = 0; i < qtd; i++) {
                    carrinhoSession.add(produto);
                }
                session.setAttribute("carrinho", carrinhoSession);
            }
            response.sendRedirect(request.getContextPath() + "/vender");

        }
    }
        
        
  }



