/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.CategoriaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Categoria;
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
 * @author Márcio Soares <marcio@mail.com>
 */
@WebServlet(name = "NovoProdutoServlet", urlPatterns = "/produtos/novo")
public class NovoProdutoServlet extends HttpServlet {

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
        ArrayList<Categoria> categorias = new CategoriaDao().listar();
        request.setAttribute("categorias", categorias);
        // cria um array para apresentar na lista de categorias 
        ArrayList<Categoria> Listacategoria = new CategoriaDao().listar();
        request.setAttribute("Listacategorias", Listacategoria);

        request.getRequestDispatcher("/WEB-INF/views/produtos/novo.jsp").forward(request, response);

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
        
        
        
        //instacio o DAO

        
        if (request.getParameter("nome_produto").isEmpty()) {
            mensagens.add("Nome não pode ser vazio.");
        }
        if (request.getParameter("categoria_id").equals("0")) {
            mensagens.add("Selecione uma Categoria.");
        }
        if(!request.getParameter("qtd_max_produto").matches("\\d+")){
            mensagens.add("Adicionar um numero valido.");
                        
        }
        if(!request.getParameter("qtd_min_produto").matches("\\d+")){
            mensagens.add("Adicionar um numero valido.");
        }
        
        
        if(mensagens.size() > 0){
            request.setAttribute("mensagens", mensagens);                        
            request.setAttribute("error", true);
            processRequest(request, response);
            return;
        }
        String nome = request.getParameter("nome_produto");
        int qtd_min_produto = Integer.parseInt(request.getParameter("qtd_min_produto"));
        int qtd_max_produto = Integer.parseInt(request.getParameter("qtd_max_produto"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
       
        
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));// Não está sendo usado
        if (!nome.isEmpty() && categoria_id > 0) {
           
             Categoria categoria = new CategoriaDao().pesquisarPorId(categoria_id); // Não está sendo usado
            Produto produto = new Produto();            
            
                produto.setNome(nome);        
                produto.setQtdeMin(qtd_min_produto);
                produto.setQtdeMax(qtd_max_produto);
                produto.setStatus(status);
                produto.setCategoria(new CategoriaDao().pesquisarPorId(categoria_id));
        
          
            
        produto.setCategoria(produto.getCategoria());
        
            if (new ProdutoDao().adicionar(produto)) {
                session.setAttribute("msg_success", "Produto " + nome + " incluído com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect(request.getContextPath() + "/produtos");
            }
        }        
    }


}
