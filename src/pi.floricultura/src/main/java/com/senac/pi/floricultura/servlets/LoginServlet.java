/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoFuncionario;
import com.senac.pi.floricultura.model.Funcionario;
import java.io.IOException;
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

        // Logica para evitar que o usuario logado acesse pagina de login
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/home.jsp");
            return;
        }
        request.getRequestDispatcher("index.jsp")
                .forward(request, response);

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

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String msg = "";
        HttpSession sessao = request.getSession();
        Funcionario func = null;

        /*Validar as informações
        Usar um servoco de login para verificar se o usuario existe no banco
        e verificar sua senha
         */
        try {
            func = ServicoFuncionario.LogarUsuario(user, password);
            if (func.getUser().equals(user)) {
                if (func.checkPassword(password)) {
                    //Se estiver tudo ok 
                    
                    sessao.setAttribute("user", user);
                }else{
                    msg = "Senha incorreta";
                    sessao.setAttribute("msg", msg);
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }

            }else{
                    msg = "Usuário não encontrado";
                    sessao.setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
        } catch (Exception e) {
        }
        
        response.sendRedirect(request.getContextPath() + "/home");

    }

}
