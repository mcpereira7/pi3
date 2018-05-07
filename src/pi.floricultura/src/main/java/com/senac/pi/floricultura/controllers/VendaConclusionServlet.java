/*
 * André de Amorim Yamamoto
 * Github: aayandre
 * Senac
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.model.Venda;
import com.senac.pi.floricultura.teste.TesteVenda;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "VendaConclusionServlet", urlPatterns = {"/venda-conclusion"})
public class VendaConclusionServlet extends HttpServlet {

    //Mostra o formulário da venda
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Recebe os dados na sessao
        HttpSession sessao = request.getSession();

        System.out.println("Esta aqui");

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaConclusion.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("doPost VendaConclusionServlet");

        //Criar Venda a partir do dados do VendaForm
        Venda novaVenda = ServicoVenda.CreateVendaByRequest(request);

//        try {
//            TesteVenda.createVenda();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
    }

}
