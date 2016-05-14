/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
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
 * @author marcio.soares <marcio@mail.com>
 */


@WebServlet(name = "ProdutosServlet", urlPatterns = "/produtos")
public class ProdutosServlet extends HttpServlet {

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
        ArrayList<Produto> produtos = new ProdutoDao().listar();
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("/WEB-INF/views/produtos/index.jsp").forward(request, response);
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
        

        String nomeProduto = request.getParameter("nome_produto");
        String qtdMinProduto = request.getParameter("qtd_min_produto");
        String qtdMaxProduto = request.getParameter("qtd_max_produto");
        String categoriaId = request.getParameter("categoria_id");

        HttpSession session = request.getSession(true);

        session.setAttribute("msg", "Seu Produto:<br> Nome: " + nomeProduto
                //+ "<br>Preço de Custo: " + precoCustoProduto
                //+ "<br>Preço de Venda: " + precoVendaProduto
                + "<br>Quantidade Mínima: " + qtdMinProduto
                + "<br>Quantidade Máxima: " + qtdMaxProduto
                //+ "<br>Saldo do Produto: " + saldoProduto
                + "<br>Categoria do Produto:" + categoriaId);
//        response.sendRedirect("sucesso");
        
        Produto produto = new Produto();
        ProdutoDao pDao = new ProdutoDao();
        
        
  
        produto.setNome(nomeProduto);        
        //produto.setPrecoCusto(Integer.parseInt(precoCustoProduto));
        //produto.setPrecoVenda(Integer.parseInt(precoVendaProduto));
        produto.setQtdeMin(Integer.parseInt(qtdMinProduto));
        produto.setQtdeMax(Integer.parseInt(qtdMaxProduto));
        //produto.setSaldo(Integer.parseInt(saldoProduto));
        produto.setCategoria(new CategoriaDao().pesquisarPorId(Integer.parseInt(categoriaId)));
      //categoria.setId(Integer.parseInt(categoriaId));
        
      produto.setCategoria(produto.getCategoria());
       
        pDao.adicionar(produto);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
