/*
 * André de Amorim Yamamoto
 * Github: aayandre
 * Senac
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.teste.TesteVenda;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mesa
 */
@WebServlet(name = "CreateVendaServlet", urlPatterns = {"/create-venda"})
public class CreateVendaServlet extends HttpServlet {

    //Mostra o formulário da venda
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Recebe os dados na sessao
        HttpSession sessao = request.getSession();

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CreateVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Chegou aqui");

        try {
            TesteVenda.createVenda();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
