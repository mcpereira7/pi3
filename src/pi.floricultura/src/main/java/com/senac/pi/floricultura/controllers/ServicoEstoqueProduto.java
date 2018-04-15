package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.DAO.EstoqueProdutoDAO;

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
        } catch (Exception e) {
            
        }
    }
    
    public static void listarEstoque(Integer id_produto, Integer id_pessoa){
        
        try {
            EstoqueProdutoDAO.ListarEstoque(id_produto, id_pessoa);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
