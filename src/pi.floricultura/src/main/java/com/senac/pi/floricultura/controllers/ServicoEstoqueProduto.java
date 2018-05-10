package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.DAO.EstoqueProdutoDAO;
import com.senac.pi.floricultura.model.ItensVenda;
import com.senac.pi.floricultura.model.MovimentoEstoque;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoEstoqueProduto {

    //Esse metodo irá checar se é nessário chamar o cadastro ou atualização de estoque.
    public static void AtualizarEstoque(EstoqueProduto estoqueProduto) {
        //Deverá conter validações para que não seja permitido realizar uma transação inválida (estoque negativo).
        try {
            if (estoqueProduto.possuiCadastroEstoque()) {
                EstoqueProdutoDAO.AtualizarEstoque(estoqueProduto);
            } else {
                EstoqueProdutoDAO.CadastrarEstoque(estoqueProduto);
            }

            //Após atualizar o estoque, chamar o serviço para armazenar a movimentação.
            Date dataAtual = Calendar.getInstance().getTime();
            MovimentoEstoque movimentoEstoque = new MovimentoEstoque(
                    estoqueProduto.getId_produto(),
                    estoqueProduto.getId_pessoa(),
                    estoqueProduto.getQuantidade(),
                    dataAtual,
                    1, //Falta definir 
                    1);//Falta definir
            ServicoMovimentoEstoque.CadastrarMovimentoEstoque(movimentoEstoque);
        } catch (Exception e) {

        }
    }

    public static List<EstoqueProduto> ListarEstoquePorIdsProduto(List<ItensVenda> produtos, int idPessoaJuridica) {

        int[] idsProdutos = new int[produtos.size()];
        List<EstoqueProduto> listaAtual = new ArrayList<>();

        int counter = 0;
        for (ItensVenda produto : produtos) {
            idsProdutos[counter] = produto.getIdProduto();
            counter++;
        }

        try {
            listaAtual = EstoqueProdutoDAO.ListaProdutosEstoqueById(idsProdutos, idPessoaJuridica);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoEstoqueProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAtual;
    }

    public static void listarEstoque(Integer id_produto, Integer id_pessoa) {

        try {
            EstoqueProdutoDAO.ListarEstoque(id_produto, id_pessoa);
        } catch (Exception e) {

        }
    }
}
