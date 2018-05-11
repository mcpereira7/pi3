/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoVenda;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius Presoto
 */
@WebServlet(urlPatterns = {"/RelatorioServlet"})
public class Relatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.getRequestDispatcher("WEB-INF/jsp/Relatorio.jsp").forward(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/relatorio.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dtIni = null;
        Date dtFim = null;
        String auxData  = dtFormat.format(request.getParameter("dtIni"));
        
        List<Venda> venda = null;
        try {
            dtIni = dtFormat.parse(auxData);
            auxData = dtFormat.format(request.getParameter("dtFim"));
            dtFim = dtFormat.parse(auxData);
            venda = ServicoVenda.ConsultaVendaByData(dtIni, dtFim);
            request.setAttribute("listaVenda", venda);
            
        } catch (VendaException | ParseException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/relatorio.jsp");
        dispatcher.forward(request, response);
    }
}
