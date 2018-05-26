/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.servlet;

import com.senac.br.controller.LoginService;
import com.senac.br.exception.UserException;
import com.senac.br.model.User;
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
 * @author aayan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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

        HttpSession sessao = request.getSession();

        try {
            //Obtem login e senha fornecidos na tela de login
            String login = request.getParameter("login");
            String senha = request.getParameter("password");

            //Verifca as informacoes cedidas ao login
            boolean validado = LoginService.ValidateUser(login, senha);

            if (!validado) {
                request.setAttribute("validado", false);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
                disp.forward(request, response);
            } else {
                //Cria o usuario com todas suas informacoes
                User logado = LoginService.GetUser(login, senha);
                //Coloca o usuario na sessao
                sessao.setAttribute("usuario", logado);
                //Redireciona para a tela home
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
                disp.forward(request, response);

            }

        } catch (UserException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
