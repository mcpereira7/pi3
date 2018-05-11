/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.Servlet;

import com.senac.pi.floricultura.controllers.ServicoProduto;
import com.senac.pi.floricultura.model.produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Produto", urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/cadastroProduto.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            produto produto = new produto();
            produto.setNome(request.getParameter("nome"));
//            produto.setTipo(request.getParameter("tipo")); 
            produto.setTipo(1);
            produto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
            produto.setPreco(Float.parseFloat(request.getParameter("preco")));
            produto.setDescricao(request.getParameter("descricao"));
            
            ServicoProduto.cadastrarProduto(produto);
//        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/cadastroProduto.jsp").forward(request, response);
    }
}
