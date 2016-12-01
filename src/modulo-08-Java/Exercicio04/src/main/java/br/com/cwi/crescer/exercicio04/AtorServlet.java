package br.com.cwi.crescer.exercicio04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diiego
 */
@WebServlet(name = "ator", urlPatterns = {"/ator"})
public class AtorServlet extends HttpServlet{
    @EJB
    private AtorBean atorBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            
            atorBean.findAll().forEach(p-> {
                out.append("<tr><td>").append(p.getNmAtor()).append("</td></tr>");
            });
            
            out.append("</tbody></table>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
            final Ator ator = new Ator();
            ator.setNmAtor(nome);
            atorBean.insert(ator);
        }
        resp.sendRedirect("/aula4");
    }
}
