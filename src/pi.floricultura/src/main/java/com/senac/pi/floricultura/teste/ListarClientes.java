package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Listar")
public class ListarClientes extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
            ServletException, IOException{
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<title>Teste Listar Clientes</title>");
            writer.println("<style type=\"text/css\">");
            writer.println("@import url(\"\\css\\estilo.css\");");
            writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        
            writer.println("<h1>Clientes</h1>");
            List<PessoaFisica> cliente = ServicoCliente.listarClientes();
            writer.println("<table>");
                    writer.println("<theader>");
                        writer.println("<tr>");
                            writer.println("<td>Nome</td>");
                            writer.println("<td>E-mail</td>");
                            writer.println("<td>Telefone</td>");
                        writer.println("</tr>");
                    writer.println("</theader>");
                    writer.println("");
                    writer.println("<tbody>");
                    for(PessoaFisica pf: cliente){
                        writer.println("<tr>");
                            writer.println("<td>" + pf.getNome() + "</td>");
                            writer.println("<td>" + pf.getEmail()+ "</td>");
                            writer.println("<td>" + pf.getTelefone()+ "</td>");
                        writer.println("</tr>");
                    }
                    writer.println("</tbody>");
            writer.println("</table>");
        writer.println("</body>");
         writer.println("</html>");
        
    }
}
