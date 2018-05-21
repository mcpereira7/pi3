/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.model.Produto;
import com.senac.pi.floricultura.teste.ProdutoTestes;
import java.io.IOException;
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
@WebServlet(name = "ProdutoAlteracaoServlet", urlPatterns = {"/produtoalteracao"})
public class ProdutoAlteracaoServlet extends HttpServlet {

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

        //Produto selecionado
        String nomeProduto = request.getParameter("produtoSelecionado");

        //Pega as informacoes do produto selecionado na consulta
        //Metodo de procurar produto por nome
        //Pegar tbm a quantidade do produto em estoque
        
        Produto seraAlterado = ProdutoTestes.gerarProdutoUnico(nomeProduto);
        
        request.setAttribute("produtoCadastrado", seraAlterado);
        
        //Redirecionar
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ProdutoAlteracao.jsp");
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

        HttpSession sessao = request.getSession();

        //Envia as alteracoes para o banco
    }

}
