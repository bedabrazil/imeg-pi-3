/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.dao.ItensEntradaDao;
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
@WebServlet(name = "VendaProdutoServlet", urlPatterns = {"/vendas"})
public class VendaProdutoServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Produto> produtos = null;
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if(usuario != null && usuario.getUnidade().isMatriz()){
            produtos = new ProdutoDao().listarMatriz();
        }else if(usuario != null){
            produtos = new ItensEntradaDao().listarProdutosUnidade(usuario);
        }        
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
        
        
        HttpSession session = request.getSession();
        

 
                int id=1;// Ajustar
                Produto produto = new ProdutoDao().pesquisarPorId(id);
                Categoria categoria = new CategoriaDao().pesquisarPorId(id); // Ajustar
                
                request.setAttribute("produto", produto);
                
                ItemVenda ItemProduto = new ItemVenda();
                ItemProduto.setId(id);
                ItemProduto.setProduto(produto);
                ItemProduto.setCategoria(categoria);
                ItemProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                        
                ListaItensVenda lista  = new ListaItensVenda();
                
                lista.adicionar(ItemProduto);
                
                processRequest(request, response);
  
        }
        
        
  }



