package br.senac.tads.pi3.imeg.servlet;

import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import br.senac.tads.pi3.imeg.entity.Relatorio;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iosato
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/dashboard"})
public class RelatoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<RelatorioVenda> maisVendidos = new RelatorioDao().listarMaisVendidos();
        request.setAttribute("maisVendidos", maisVendidos);
        
        request.getRequestDispatcher("/WEB-INF/views/home/bemvindo.jsp").forward(request, response);

        HttpSession session = request.getSession();
        String msg_success = (String) session.getAttribute("msg_success");

        if (msg_success != null) {
            session.removeAttribute("msg_success");
            session.removeAttribute("success");
        }
    }
}
