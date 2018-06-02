/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.servlet;

import com.senac.br.controller.CardService;
import com.senac.br.exception.CardException;
import java.io.IOException;
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
 * @author aayan
 */
@WebServlet(name = "CriadorServlet", urlPatterns = {"/novo"})
public class CriadorServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Redireciona para a pagina de criar novo card
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/criador.jsp");
        disp.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //testes de imagem
            Object imagem = request.getPart("img");
            
            //utilizar o servico para criar o card e adiciona-lo ao banco
            CardService.createCard(request);

            //redirecionar para home
            response.sendRedirect("/poonotes/home");

        } catch (CardException ex) {
            Logger.getLogger(CriadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
