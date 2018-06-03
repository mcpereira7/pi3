/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoProduto;
import com.senac.pi.floricultura.model.Produto;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(name = "RelatorioEstoque", urlPatterns = {"/RelatorioEstoque"})
public class RelatorioEstoque extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RelatorioEstoque.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<Produto> listaProduto = new ArrayList<>();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date dataInicial = (Date) format.parse(request.getParameter("dataInicial"));
            Date dataFinal = (Date) format.parse(request.getParameter("dataFinal"));

            listaProduto = ServicoProduto. *faltaCriarOMetodo *;
            request.setAttribute("listaProduto", listaProduto);

        } catch (ParseException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RelatorioEstoque.jsp");
        dispatcher.forward(request, response);
    }

}


