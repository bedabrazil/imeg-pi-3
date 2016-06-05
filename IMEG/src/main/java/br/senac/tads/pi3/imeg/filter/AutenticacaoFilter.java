/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.tads.pi3.imeg.entity.Funcionario;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
@WebFilter(filterName = "AutenticacaoFilter", servletNames = {
    "AlterarCargoServlet",
    "AlterarCategoriaServlet",
    "AlterarFuncionarioServlet",
    "AlterarProdutoServlet",
    "AlterarUnidadeServlet",
    "CargosServlet",
    "CategoriasServlet",
    "FuncionariosServlet",
    "InserirProdutoServlet",
    "NovaCategoriaServlet",
    "NovaUnidadeServlet",
    "NovoCargoServlet",
    "NovoFuncionarioServlet",
    "NovoProdutoServlet",
    "MeusDadosServlet",
    "ProdutosServlet",
    "UnidadesServlet",
    "RelatorioServlet",
    "PedidosServlet",
    "VendasServlet",
    "DashBoardServlet"
})
public class AutenticacaoFilter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        Funcionario usuario = (Funcionario) session.getAttribute("usuario");
        if (usuario == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        try {
            boolean possoAcessar = verificarAcesso(usuario, httpRequest, httpResponse);
            if (possoAcessar) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
            }
        } catch (IOException | ServletException t) {
        }
    }

    /**
     * Método que verifica se o usuário possui o(s) papel(is) necessário(s) para
     * acessar a funcionalidade
     *
     * @param usuario
     * @param req
     * @param resp
     * @return
     */
    private static boolean verificarAcesso(Funcionario func, HttpServletRequest req, HttpServletResponse resp) {
        String pagina = req.getRequestURI();
        if ((pagina.endsWith("/relatorio") && pagina.endsWith("/produtos")) && (func.getAcesso().getNome().equals("GERENTE"))) {
            return true;
        } else if ((pagina.endsWith("/produtos") || pagina.endsWith("/funcionarios") || pagina.endsWith("/cargos") || pagina.endsWith("/categorias") || pagina.endsWith("/unidades")) && (func.getAcesso().getNome().equals("GERENTE") && func.getUnidade().isMatriz())) {
            return true;
        } else if ((pagina.endsWith("/pedido-realizado") || pagina.endsWith("/vender") || pagina.endsWith("/vendidos") || pagina.endsWith("/carrinho")) && ((func.getAcesso().getNome().equals("GERENTE") || (func.getAcesso().getNome().equals("ADMIN") && !func.getUnidade().isMatriz()) || func.getAcesso().getNome().equals("VENDEDOR")))) {
            return true;
        } else if (pagina.endsWith("/meusdados/editar") || pagina.endsWith("/dashboard")) {
            return true;
        } else if (func.getAcesso().getNome().equals("ADMIN")) {
            return true;
        }
        return false;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }

}
