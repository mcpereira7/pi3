package com.senac.pi.floricultura.se;

import com.senac.pi.floricultura.controllers.ServicoTela;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PermissoesCriarServlet", urlPatterns = {"/PermissoesCadastrar"})
public class PermissoesCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listaTelas", ServicoTela.ListarTelas());
        request.getRequestDispatcher("WEB-INF/jsp/PermissoesCriar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
