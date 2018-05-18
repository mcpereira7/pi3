/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.Produto;
import com.senac.pi.floricultura.DAO.ProdutoDAO;
import com.senac.pi.floricultura.exceptions.ProdutoException;
import com.senac.pi.floricultura.teste.ProdutoTestes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

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

    public static List<Integer> getProdutoIdByNomes(String[] nomes) {

        try {

            List<Integer> resultado = ProdutoDAO.getIdByNomes(nomes);

            return resultado;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Produto createProductByRequest(HttpServletRequest request) {

        Produto novo = new Produto();
        //ID eh auto incremental

        //Nome sempre armazenar em UPPERCASE
        novo.setNome(request.getParameter("nome").toUpperCase());

        //Tipo
        String tipo = request.getParameter("tipo");
        int tipoNum = Integer.parseInt(tipo);
        novo.setTipo(tipoNum);

        //Quantidade
        novo.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));

        //Cuidado porque no banco o campo eh DOUBLE
        novo.setPreco(Float.parseFloat(request.getParameter("preco")));

        //Descricao
        novo.setDescricao(request.getParameter("descricao"));

        return novo;

    }

    public static List<Produto> getProdutosByNome(String nome) {

        //Deixar  nome em UPPERCASE
        nome = nome.toUpperCase();

        //Lista de resultado
        List<Produto> listaConsultada = ProdutoTestes.geraProdutosHARDCODE(10);

        //Tem que criar o metodo
        //listaConsultada = ProdutoDAO.getProdutosByNome(nome);
        //return listaConsultada;
        return listaConsultada;
    }

}
