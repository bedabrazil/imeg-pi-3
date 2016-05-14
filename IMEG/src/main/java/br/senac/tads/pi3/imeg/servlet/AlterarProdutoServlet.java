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
 * @author matheus.ssouza1
 */
@WebServlet(name = "AlterarProdutoServlet", urlPatterns = "/produtos/editar")
public class AlterarProdutoServlet extends HttpServlet {

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
        // pega dados dos produtos para ser alterado 
        if (request.getQueryString() != null) {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Produto produto = new ProdutoDao().pesquisarPorId(id);
                request.setAttribute("produto", produto);
            }
            request.getRequestDispatcher("/WEB-INF/views/produtos/editar.jsp").forward(request, response);
        } else {
            response.sendRedirect("/produtos");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response); //To change body of generated methods, choose Tools | Templates.
        // talvez inicie a sessao
        ArrayList<String> mensagens = new ArrayList<>();
        HttpSession session = request.getSession(true);
        session.setAttribute("success", false);

        String nome = request.getParameter("nome_produto");
        if (nome.isEmpty()) {
            request.setAttribute("error", true);
            mensagens.add("Nome não pode ser vazio.");

        }
        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            processRequest(request, response);
            return;
        }
        if (request.getParameter("nome") != null) {
            Produto produto = new Produto();
            produto.setId(Integer.parseInt(request.getParameter("id")));
            produto.setNome(request.getParameter("nome_produto"));
            produto.setQtdeMin(Integer.parseInt(request.getParameter("qtd_min_produto")));
            produto.setQtdeMax(Integer.parseInt(request.getParameter("qtd_max_produto")));
            produto.setCategoria(new CategoriaDao().pesquisarPorId(Integer.parseInt(request.getParameter("categoria_id"))));
            // alterar produto 
            if (new ProdutoDao().alterar(produto)) {
                mensagens.clear();
                session.setAttribute("success", true);
                session.setAttribute("msg_success", "Produto <strong>" + produto.getNome() + "</strong> alterado com sucesso.");
                response.sendRedirect("/produtos");
            }
        }

    }

}
