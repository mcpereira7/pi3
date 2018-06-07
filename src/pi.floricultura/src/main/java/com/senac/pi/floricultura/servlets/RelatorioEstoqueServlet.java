/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.DAO.EstoqueProdutoDAO;
import com.senac.pi.floricultura.DAO.FilialDAO;
import com.senac.pi.floricultura.controllers.ServicoProduto;
import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.model.EstoqueProdutoRelatorio;
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
public class RelatorioEstoqueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("listaFiliais", FilialDAO.listaFilial());
        } catch (Exception ex) {
            Logger.getLogger(RelatorioEstoqueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RelatorioEstoque.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List<EstoqueProdutoRelatorio> estoqueProduto;

            if (request.getParameter("listaFilial") != null) {
                int filial = Integer.parseInt(request.getParameter("listaFilial"));
                request.setAttribute("filialSelecionada", filial);
                estoqueProduto = EstoqueProdutoDAO.ListarEstoque(null, filial);
            } else {
                estoqueProduto = EstoqueProdutoDAO.ListarEstoque(null, null);
            }

            request.setAttribute("listaEstoqueProduto", estoqueProduto);

            request.setAttribute("listaFiliais", FilialDAO.listaFilial());
        } catch (Exception ex) {
            Logger.getLogger(RelatorioEstoqueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RelatorioEstoque.jsp");
        dispatcher.forward(request, response);
    }

}
