/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.ItensSaidaDao;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
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
@WebServlet(name = "PedidosServlet", urlPatterns = {"/carrinho", "/pedido-realizado"})
public class PedidosServlet extends HttpServlet {

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

        Map<Produto, Integer> carrinhoSession = (Map<Produto, Integer>) session.getAttribute("carrinho");
        if (request.getQueryString() != null) {
            if (!request.getParameter("id").isEmpty() && request.getParameter("id").matches("\\d+")) {
                if (!request.getParameter("updt").isEmpty() && request.getParameter("updt").matches("\\d+")) {
                    if (!request.getParameter("updt").equals("1")) {
                        request.getRequestDispatcher("/WEB-INF/views/pedidos/index.jsp").forward(request, response);
                    }
                    int id = Integer.parseInt(request.getParameter("id"));
                } else if (!request.getParameter("id'").isEmpty() && request.getParameter("id").matches("\\d+")) {
                    if (!request.getParameter("del").isEmpty() && request.getParameter("del").matches("\\d+")) {
                        if (!request.getParameter("del").equals("1")) {
                            request.getRequestDispatcher("/WEB-INF/views/pedidos/index.jsp").forward(request, response);
                        }
                        int id = Integer.parseInt(request.getParameter("id"));
                    }
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/views/pedidos/pedido-realizado.jsp").forward(request, response);

        String msg_success = (String) session.getAttribute("msg_success");
        boolean sale_success = (boolean) session.getAttribute("sale_success");
        if (sale_success) {
            session.removeAttribute("sale_success");
            session.removeAttribute("sale_number");
        }
        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
        }
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
        HttpSession session = request.getSession(true);
        session.removeAttribute("msg_success");
        session.removeAttribute("success");
        Produto produto = null;
        int qtd = 0;
        Map<Produto, Integer> carrinhoSession = (Map<Produto, Integer>) session.getAttribute("carrinho");
        if (request.getParameter("id_produto") != null && !request.getParameter("id_produto").isEmpty() && request.getParameter("id_produto").matches("\\d+")) {
            produto = new ProdutoDao().pesquisarPorId(Integer.parseInt(request.getParameter("id_produto")));
            if (produto != null) {
                if (request.getParameter("remover_produto") != null && !request.getParameter("remover_produto").isEmpty() && request.getParameter("remover_produto").matches("\\d+") && request.getParameter("remover_produto").equals("1")) {
                    Produto prodExist = pegarProduto(carrinhoSession, produto);
                    if (prodExist != null) {
                        int valor = carrinhoSession.get(prodExist);
                        carrinhoSession.remove(prodExist);
                        session.setAttribute("success", true);
                        session.setAttribute("msg_success", "Produto removido com sucesso.");
                        session.setAttribute("carrinho", carrinhoSession);
                    }
                } else if (request.getParameter("atualizar_produto") != null && !request.getParameter("atualizar_produto").isEmpty() && request.getParameter("atualizar_produto").matches("\\d+") && request.getParameter("atualizar_produto").equals("1")) {
                    qtd = Integer.parseInt(request.getParameter("qtd_produto"));
                    if (produto.getSaldo() >= qtd) {
                        Produto prodExist = pegarProduto(carrinhoSession, produto);
                        if (prodExist != null) {
                            carrinhoSession.remove(prodExist);
                            session.setAttribute("success", true);
                            if (qtd > 0) {
                                carrinhoSession.put(produto, qtd);
                                session.setAttribute("msg_success", "Carrinho atualizado com sucesso.");
                            } else {
                                session.setAttribute("msg_success", "Produto removido do carrinho com sucesso;");
                            }
                        }

                        session.setAttribute("carrinho", carrinhoSession);
                    } else {
                        session.setAttribute("success", true);
                        session.setAttribute("msg_success", "<strong>Saldo Insuficiente</strong>. <br>saldo atual é de <strong>" + produto.getSaldo() + "</strong> Foi solicitado <strong>" + qtd + "</strong>");
                    }
                }
            }
        } else if (request.getParameter("finalizar") != null && !request.getParameter("finalizar").isEmpty() && request.getParameter("finalizar").matches("\\d+") && request.getParameter("finalizar").equals("1")) {
            if (carrinhoSession != null) {
                Funcionario usuario = (Funcionario) session.getAttribute("usuario");
                for (Map.Entry<Produto, Integer> entry : carrinhoSession.entrySet()) {
                    produto = entry.getKey();
                    int qtdProd = entry.getValue();
                    if (produto.getSaldo() >= qtdProd) {
                        if (new ItensSaidaDao().adicionar(produto, qtdProd, usuario)) {
                            new ProdutoDao().atualizarSaldo(produto, qtdProd);
                        }
                    } else {
                        session.setAttribute("success", true);
                        session.setAttribute("msg_success", "<strong>Saldo Insuficiente</strong>. <br>saldo atual é de <strong>" + produto.getSaldo() + "</strong> Foi solicitado <strong>" + qtdProd + "</strong>");
                        request.getRequestDispatcher("/WEB-INF/views/pedidos/index.jsp").forward(request, response);
                        return;
                    }
                }
                int rand = (new Random().nextInt(8 * 2000));
                session.setAttribute("sale_number", rand);
                session.setAttribute("sale_success", true);
                session.removeAttribute("carrinho");
            }
        }
        response.sendRedirect(request.getContextPath() + "/pedido-realizado");
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
