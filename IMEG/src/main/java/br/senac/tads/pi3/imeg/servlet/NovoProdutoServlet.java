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

        String nome = request.getParameter("nome_produto");
        int qtd_min_produto = Integer.parseInt(request.getParameter("qtd_min_produto"));
        int qtd_max_produto = Integer.parseInt(request.getParameter("qtd_max_produto"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        
        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("Nome não pode ser vazio.");
        }
        if (categoria_id == 0) {
            mensagens.add("Selecione uma Categoria.");
            request.setAttribute("error", true);
        }
        if(qtd_max_produto < 1){
            mensagens.add("Valor tem que ser maior que zero.");
            request.setAttribute("error", true);            
        }
        if(qtd_min_produto < 0){
            mensagens.add("Valor tem que ser maior ou igual a zero.");
            request.setAttribute("error", true);            
        }
        
        
        if(mensagens.size() > 0){
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        
        boolean status = Boolean.parseBoolean(request.getParameter("ativo"));
        if (!nome.isEmpty() && categoria_id > 0) {
            Categoria categoria = new CategoriaDao().pesquisarPorId(categoria_id);
            Produto produto = new Produto();
            if (new ProdutoDao().adicionar(produto)) {
                session.setAttribute("msg_success", "Cargo " + nome + " incluído com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect(request.getContextPath() + "/produtos");
            }
        }        
    }


}
