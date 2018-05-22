/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoProduto;
import com.senac.pi.floricultura.model.Produto;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ProdutoConsultaServlet", urlPatterns = {"/listarprodutos"})
public class ProdutoConsultaServlet extends HttpServlet {

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

        HttpSession sessao = request.getSession();

        String nome = request.getParameter("consulta");

        try {
            if (nome != null) {

                List<Produto> listaConsultada = ServicoProduto.getProdutosByNome(nome);
                request.setAttribute("listaProdutos", listaConsultada);
                request.setAttribute("procura", nome);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ProdutoConsulta.jsp");
                dispatcher.forward(request, response);

            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/ProdutoConsulta.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProdutoConsultaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }

}
