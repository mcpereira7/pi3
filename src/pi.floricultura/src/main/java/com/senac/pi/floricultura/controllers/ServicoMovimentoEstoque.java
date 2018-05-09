package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.MovimentoEstoque;
import com.senac.pi.floricultura.DAO.MovimentoEstoqueDAO;
import java.util.Date;

public class ServicoMovimentoEstoque {

    public static void CadastrarMovimentoEstoque(MovimentoEstoque movimentoEstoque) {

        try {
            MovimentoEstoqueDAO.CadastrarMovimentoEstoque(movimentoEstoque);
        } catch (Exception e) {
        }
    }

    public static void ListarMovimentoEstoque(Integer id_produto, Integer id_pessoa,
            Date dataInicial, Date dataFinal, Integer tipo, Integer natureza) {
        
        try {
            MovimentoEstoqueDAO.ListarMovimentoEstoque(id_produto, id_pessoa, 
                    dataInicial, dataFinal, tipo, natureza);
        } catch (Exception e) {
        }
    }
}
