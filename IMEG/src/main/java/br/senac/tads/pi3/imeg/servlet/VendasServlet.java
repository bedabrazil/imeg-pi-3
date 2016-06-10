/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        ArrayList<Produto> produtos = new ProdutoDao().produtosComSaldo();
        request.setAttribute("produtos", produtos);

        request.getRequestDispatcher("/WEB-INF/views/vendas/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Map<Produto, Integer> carrinhoSession = (Map<Produto, Integer>) session.getAttribute("carrinho");
        if (!request.getParameter("id_produto").isEmpty() && request.getParameter("id_produto").matches("\\d+")) {
            Produto produto = new ProdutoDao().pesquisarPorIdItensEntrada(Integer.parseInt(request.getParameter("id_produto")));
            int qtd = Integer.parseInt(request.getParameter("quantidade_produto"));

            if (produto != null) {
                if (carrinhoSession == null) {
                    carrinhoSession = new HashMap<>();
                }
                Produto prodExist = pegarProduto(carrinhoSession, produto);

                if (prodExist != null) {
                    int valor = carrinhoSession.get(prodExist);
                    carrinhoSession.remove(prodExist);
                    carrinhoSession.put(produto, valor + qtd);
                } else {
                    carrinhoSession.put(produto, qtd);
                }
                session.setAttribute("carrinho", carrinhoSession);
            }
            response.sendRedirect(request.getContextPath() + "/carrinho");

        }
    }

    private Produto pegarProduto(Map<Produto, Integer> map, Produto produto) {
        for (Map.Entry<Produto, Integer> entry : map.entrySet()) {
            Produto key = entry.getKey();
            if (key.getId() == produto.getId()) {
                return key;
            }
        }
        return null;
    }

}
