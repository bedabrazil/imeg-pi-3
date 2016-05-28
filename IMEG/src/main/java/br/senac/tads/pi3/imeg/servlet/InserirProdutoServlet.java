/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.FuncionarioDao;
import br.senac.tads.pi3.imeg.dao.HistoricoEntradaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
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
@WebServlet(name = "InserirProdutoServlet", urlPatterns = {"/produtos/inserir"})
public class InserirProdutoServlet extends HttpServlet {

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

        if (request.getQueryString() != null) {

            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));
                Produto produto = new ProdutoDao().pesquisarPorId(id);
                request.setAttribute("produto", produto);
            }
            request.getRequestDispatcher("/WEB-INF/views/produtos/inserir.jsp").forward(request, response);
        }
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
        ArrayList<String> mensagens = new ArrayList<>();

        if (request.getParameter("preco_custo_produto").isEmpty() && !request.getParameter("preco_custo_produto").matches("\\d+")) {
            mensagens.add("Informe o Preço.");
        } else {
            double preco = Double.parseDouble(request.getParameter("preco_custo_produto").replaceAll(",","."));
            if (preco <= 0) {
                mensagens.add("Preço deve ser Maior que 0");
            }
        }

        if (request.getParameter("quantidade").isEmpty() && !request.getParameter("quantidade").matches("\\d+")) {
            mensagens.add("Informe a Quantidade.");
        } else {
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            if (quantidade <= 0) {
                mensagens.add("Quantidade tem que ser maior que 0.");
            }
        }

        if (mensagens.size() > 0) {
            request.setAttribute("mensagens", mensagens);
            request.setAttribute("error", true);
            processRequest(request, response);
            return;
        }
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if (usuario != null) {
            double preco_custo_produto = Double.parseDouble(request.getParameter("preco_custo_produto").replaceAll(",","."));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            int id = Integer.parseInt(request.getParameter("id_produto"));

            HistoricoEntrada histEntrada = new HistoricoEntrada();

            histEntrada.setPreco_custo(preco_custo_produto);
            histEntrada.setQtde_produtos(quantidade);
            histEntrada.setProduto(new ProdutoDao().pesquisarPorId(id));
            histEntrada.setFuncionario(usuario);

            if (new HistoricoEntradaDao().adicionar(histEntrada)) {
                new HistoricoEntradaDao().atualizaSaldo(histEntrada);

                session.setAttribute("msg_success", " Entrada realizada com sucesso.");
                session.setAttribute("success", true);
                response.sendRedirect(request.getContextPath() + "/produtos");
            }
        }

    }

}
