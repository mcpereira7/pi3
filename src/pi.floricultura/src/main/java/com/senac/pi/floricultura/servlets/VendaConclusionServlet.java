/*
 * André de Amorim Yamamoto
 * Github: aayandre
 * Senac
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoVenda;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.io.IOException;
import java.util.Date;
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
 * @author mesa
 */
@WebServlet(name = "VendaConclusionServlet", urlPatterns = {"/venda-conclusion"})
public class VendaConclusionServlet extends HttpServlet {

    //Mostra o formulário da venda
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("doGet VendaConclusionServlet");

        HttpSession sessao = request.getSession();

        try {

            //Pega o CPF
            String cpf = request.getParameter("cliente");

            //Criar Venda a partir do dados do VendaForm
            Venda novaVenda = ServicoVenda.CreateVendaByRequest(request);

            //Adiciona a venda no request
            sessao.setAttribute("novaVenda", novaVenda);
            request.setAttribute("dataVenda", new Date());

            //Pega o cpf
            request.setAttribute("clienteCPF", cpf);

            //Redireciona para a pagina de conclusao de venda
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/VendaConclusion.jsp");
            dispatcher.forward(request, response);

        } catch (VendaException ex) {
            Logger.getLogger(VendaConclusionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //Conclui a venda e envia pro banco
            Object venda = request.getSession().getAttribute("novaVenda");
            Venda concluir = (Venda) venda;

            //Hardcode do id vendedor pois a sessao ainda não foi implantada
            concluir.setIdVendedor(1);

            ServicoVenda.ConcluirVenda(concluir);

            //Apago a venda da sessao
            request.getSession().removeAttribute("novaVenda");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);

        } catch (IOException | ServletException | VendaException e) {
            Logger.getLogger(VendaConclusionServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
