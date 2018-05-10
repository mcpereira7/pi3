/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.Servlet;

import com.senac.pi.floricultura.controllers.ServicoVenda;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius Presoto
 */
@WebServlet(name = "Relatorio", urlPatterns = {"/Relatorio"})
public class Relatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dtIni = null;
        Date dtFim = null;
        List<Venda> venda = null;
        try {
            dtIni = dtFormat.parse(request.getParameter("dataInicial"));
            dtFim = dtFormat.parse(request.getParameter("dataFinal"));
        } catch (ParseException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             venda = ServicoVenda.ConsultaVendaByData(dtIni, dtFim);
        } catch (VendaException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("WEB-INF/jsp/Relatorio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
