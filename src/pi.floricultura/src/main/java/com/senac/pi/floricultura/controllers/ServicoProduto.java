/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.Produto;
import com.senac.pi.floricultura.DAO.ProdutoDAO;
//import com.senac.pi.floricultura.model.GerarCodigo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

    public static void cadastrarProduto(Produto produto) throws SQLException, Exception {
        try {
            ProdutoDAO.inserir(produto);
        } catch (SQLException e) {
            System.err.println("Erro");
        }
    }

    public static void atualizarProduto(Produto produto) {
        try {
            ProdutoDAO.atualizarProduto(produto);
        } catch (Exception e) {
        }
    }

    public static void excluidProduto(Produto produto) {
        try {
            ProdutoDAO.excluirProduto(produto);
        } catch (Exception e) {
        }
    }

    public static float getPrecoProdutoById(int idProduto) {

        float preco;

        try {

            preco = ProdutoDAO.getPriceById(idProduto);

            return preco;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

//    public static List<Integer> getProdutoIdByCodigo(String[] codigos) {
//
//        int[] codigosNum = new int[codigos.length];
//        try {
//
//            for (int i = 0; i < codigos.length; i++) {
//                codigosNum[i] = Integer.parseInt(codigos[i]);
//            }
//
//            List<Integer> resultado = ProdutoDAO.getProdutoByCodigo(codigosNum);
//
//            return resultado;
//        } catch (Exception ex) {
//            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public static String getProdutoByName(String nome) {
        String procura;
        try {
            procura = ProdutoDAO.getProdutoByNome(nome);
            return procura;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
            return "não encontrado.";
        }
    }

    public static int getProdutoByTipo(int tipo) {
        int procura;
        try {
            procura = ProdutoDAO.getProdutoByTipo(tipo);
            return procura;
        } catch (Exception e) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, e);
            return - 1;
        }
    }

}
