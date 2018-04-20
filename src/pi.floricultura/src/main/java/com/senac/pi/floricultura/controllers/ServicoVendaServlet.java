/*
 * André de Amorim Yamamoto
 * Github: aayandre
 * Senac
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.teste.TesteVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServicoVendaServlet", urlPatterns = {"/insert-venda"})
public class ServicoVendaServlet extends HttpServlet {

    //Mostra o formulário da venda
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Recebe os dados do form ACHO
        HttpSession sessao = request.getSession();
        
        //Pega a venda do form
        Object venda = sessao.getAttribute("venda");
        
        if(venda != null) {
            //Mostrar tela de resultado da venda
            System.out.println("RESULTADO");
        } else {
            System.out.println("Available?");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/FormVenda.jsp");
            dispatcher.forward(request, response);
        }
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
