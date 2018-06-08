/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.controllers.ServicoEstoqueProduto;
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

/**
 *
 * @author aayan
 */
@WebServlet(name = "EstoqueAlteracaoServlet", urlPatterns = {"/alterarestoque"})
public class EstoqueAlteracaoServlet extends HttpServlet {

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

        String consulta = request.getParameter("consulta");

        try {
            if (consulta != null) {

                //Procura o produto
                List<Produto> consultado = ServicoProduto.getProdutosByNome(consulta);

                //Cria o produto
                Produto mostrar = consultado.get(0);

                //Verifica se o produto esta preenchido/encontrado
                if (mostrar == null) {
                    request.setAttribute("semproduto", true);
                    //Redireciona para a pagina
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AlterarEstoque.jsp");
                    dispatcher.forward(request, response);
                    return;
                }

                //obtem a quantidade em estoque atual
                int quantidadeAtual = ServicoEstoqueProduto.ObtemQuantidadeByIdProduto(mostrar.getId());

                //Coloca o produto na request
                request.setAttribute("produto", mostrar);

                //Adiciona a quantidade de produto atual ao request
                request.setAttribute("quantidadeAtual", quantidadeAtual);

                //Redireciona para a pagina
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AlterarEstoque.jsp");
                dispatcher.forward(request, response);
                return;

            }

            //Redireciona para a pagina
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AlterarEstoque.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(EstoqueMovimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
