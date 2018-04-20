package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.controllers.ServicoVenda;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.ItensVenda;
import com.senac.pi.floricultura.model.Venda;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * André de Amorim Yamamoto
 * Github: aayandre
 * Senac
 */
/**
 *
 * @author mesa
 */
public class TesteVenda {

    public static void main(String[] args) throws Exception {
        createVenda();
    }

    public static void createVenda() throws Exception {

        Venda novaVenda = new Venda();

        double total = 0;

        try {
            novaVenda.setCodigo(ServicoVenda.geraCodVenda());
            novaVenda.setDataVenda(Calendar.getInstance().getTime());
            novaVenda.setIdPessoa(10);
            novaVenda.setIdVendedor(20);
            novaVenda.setListaItensVenda(createCarrinho(3));

            //Calculo do total
            for (ItensVenda item : novaVenda.getListaItensVenda()) {
                total += item.getValor();
            }
            novaVenda.setValorTotal(total);

            VendaDAO.inserir(novaVenda);
            VendaDAO.insertItensVenda(novaVenda.getListaItensVenda(), novaVenda.getCodigo());

        } catch (VendaException e) {
            throw new VendaException("Erro");
        }

    }

    public static ArrayList<ItensVenda> createCarrinho(int numberOfProducts) {

        ArrayList<ItensVenda> carrinho = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {

            ItensVenda item = new ItensVenda();
            item.setIdProduto(i);
            item.setQuantidade(i + 1);
            item.setValor(i * 2.5);

            carrinho.add(item);
        }

        return carrinho;

    }

}
