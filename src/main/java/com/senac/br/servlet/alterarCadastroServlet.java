package com.senac.br.servlet;

import com.senac.br.DAO.UserDAO;
import com.senac.br.model.User;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leand
 */
@WebServlet(name = "alterarCadastroServlet", urlPatterns = {"/alterarCadastro"})
public class alterarCadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/alterarCadastro.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        try {
            User usuario = new User(
                    request.getParameter("nome"),
                    request.getParameter("login"),
                    request.getParameter("email"),
                    request.getParameter("senhaAtual")
            );

            String newPass = request.getParameter("novaSenha");

            User usuarioAutent = UserDAO.getUserByLogin(usuario.getLogin(), usuario.getSenha());
            if (usuarioAutent != null) {
                usuario.setIdUser(usuarioAutent.getIdUser());
                UserDAO.alterUser(usuario, newPass);
            } else {
                //Mensagem de erro porque não encontrou o usuário com a senha informada.
            }

            RequestDispatcher disp = getServletContext().getRequestDispatcher("index.jsp");
            disp.forward(request, response);

        } catch (Exception e) {
        }
    }
}
