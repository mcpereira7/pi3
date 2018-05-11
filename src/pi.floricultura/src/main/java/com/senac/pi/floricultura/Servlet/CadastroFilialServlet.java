/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.Servlet;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.controllers.ServicoFilial;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.Filial;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.utilitarios.Auxiliares;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/CadastroFilial"})
public class CadastroFilialServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date dtCadastro = new Date(System.currentTimeMillis());
        req.setAttribute("dtCadastro", dtCadastro);
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/CadastroFilial.jsp");
        disp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Filial filial = new Filial(req.getParameter("codFilial")
                , req.getParameter("cnpj")
                , req.getParameter("inscEst")
                , false
                , true
                , req.getParameter("gerente")
                , req.getParameter("email")
                , req.getParameter("tel1")
                , req.getParameter("tel2")
                , new GerarCodigo().setCodigoCli()
                , req.getParameter("rSocial")
                , req.getParameter("nFant")
                , 3
                , Auxiliares.ftmtData()
                , false);
        Endereco end = new Endereco(filial.getId()
                , req.getParameter("cep")
                , req.getParameter("endereco")
                , req.getParameter("numero")
                , req.getParameter("comp")
                , req.getParameter("bairro")
                , req.getParameter("cid")
                , req.getParameter("uf"));
        try {
            ServicoFilial.cadastrar(filial);
            EnderecoDAO.inserirEndereco(end, filial.getId());
        } catch (Exception e) {
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/CadastroFilial.jsp");
        dispatcher.forward(req, resp);
    }
    
}
