/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.servlet;

import com.senac.pi.floricultura.controllers.ServicoVenda;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/RelatorioServlet"})
public class RelatorioServlet extends HttpServlet {

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

        //request.getRequestDispatcher("WEB-INF/jsp/Relatorio.jsp").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/relatorio.jsp");
        dispatcher.forward(request, response);
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

        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dtIni = null;
        Date dtFim = null;
        String auxData = dtFormat.format(request.getParameter("dtIni"));

        List<Venda> venda = null;
        try {
            dtIni = dtFormat.parse(auxData);
            auxData = dtFormat.format(request.getParameter("dtFim"));
            dtFim = dtFormat.parse(auxData);
            venda = ServicoVenda.ConsultaVendaByData(dtIni, dtFim);
            request.setAttribute("listaVenda", venda);

        } catch (VendaException | ParseException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/relatorio.jsp");
        dispatcher.forward(request, response);
    }

}
