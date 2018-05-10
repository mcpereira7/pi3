/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.produto;
import com.senac.pi.floricultura.DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

    public static void cadastrarProduto(produto produto) throws SQLException, Exception {
        try {
            ProdutoDAO.inserir(produto);
        } catch (SQLException e) {
            System.err.println("Erro");
        }
    }

    public static void atualizarProduto(produto produto) {
        try {
            ProdutoDAO.atualizarProduto(produto);
        } catch (Exception e) {
        }
    }

    public static void excluidProduto(produto produto) {
        try {
            ProdutoDAO.excluirProduto(produto);
        } catch (Exception e) {
        }
    }

    public static double getPrecoProdutoById(int idProduto) {

        double preco;

        try {

            preco = ProdutoDAO.getPriceById(idProduto);

            return preco;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

}
