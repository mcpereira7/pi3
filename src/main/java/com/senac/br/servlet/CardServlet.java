/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.servlet;

import com.senac.br.controller.CardService;
import com.senac.br.exception.CardException;
import com.senac.br.model.Card;
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
@WebServlet(name = "CardServlet", urlPatterns = {"/card"})
public class CardServlet extends HttpServlet {

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

        try {

            //pegar as informacoes do card
            Card obtido = CardService.getCardById(Integer.parseInt(request.getParameter("cardId")));

            //adicionar o car ao request
            request.setAttribute("card", obtido);

            //Redireciona para a pagina de alterar o card
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/card.jsp");
            disp.forward(request, response);

        } catch (CardException ex) {
            Logger.getLogger(CardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        //enviar as informacoes do card alterado
        //redireciona para home
        response.sendRedirect("/poonotes/home");

    }

}
