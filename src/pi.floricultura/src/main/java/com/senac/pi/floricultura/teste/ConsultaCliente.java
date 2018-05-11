package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = "/ConsultarCliente")
public class ConsultaCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpf");
        List<PessoaFisica> listaCliPF = ServicoCliente.ConsultarClientes(cpf);
        req.setAttribute("listaCliPF", listaCliPF);
        req.getRequestDispatcher("/WEB-INF/jsp/ListarClientes.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/ListarClientes.jsp").forward(req, resp);
        
    }
    
}
