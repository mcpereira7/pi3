/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoFilial;
import com.senac.pi.floricultura.model.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/ListaFiliais"})
public class ExibeFilialServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Filial> listFilial = ServicoFilial.listar();
        req.setAttribute("listFilial", listFilial);
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/ListarFilial.jsp");
        disp.forward(req, resp);
    
    }
    
    
    
}
