/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.servlet;

import com.senac.br.controller.SignupService;
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
@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

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

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp");
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

            boolean cadastrado = SignupService.signupUser(request);

            //Se o usuario nao for cadastrado
            if (!cadastrado) {
                System.out.println("Tela de erro talvez");
            }

            //Se nao mostrar a tela de login para o mesmo se logar
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario",
                    new User(request.getParameter("nome"),
                            request.getParameter("login"),
                            request.getParameter("email"),
                            request.getParameter("pass")));

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
            disp.forward(request, response);

        } catch (UserException ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
