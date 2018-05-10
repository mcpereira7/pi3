/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Cliente;
import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.model.ItensVenda;
import com.senac.pi.floricultura.model.Pessoa;
import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.model.Venda;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ServicoVenda {

    //Ainda não tem consulta de pessoa
//    public static List<Pessoa> ConsultaClienteByNomeOuCodigo(String campoDaConsulta,
//            List<ItensVenda> listaItensVenda, List<Pessoa> listaDeClientes, Component tela)
//            throws VendaException {
//
//        try {
//            if (!campoDaConsulta.isEmpty()) {
//                if (!listaItensVenda.isEmpty() || !listaDeClientes.isEmpty()) {
//                    JOptionPane.showMessageDialog(tela, "Venda em andamento.");
//                    return null;
//                } else {
//                    if (isParsable(campoDaConsulta)) {
//
//                        listaDeClientes = ServicoCliente.procuraCliente(Integer.parseInt(campoDaConsulta), campoDaConsulta);
//
//                        if (listaDeClientes.size() > 1) {
//                            JOptionPane.showMessageDialog(tela, "Foi encontrado multiplos clientes com o mesmo nome.");
//                            return listaDeClientes;
//                        } else {
//                            return listaDeClientes;
//                        }
//
//                    } else {
//                        listaDeClientes = ServicoCliente.procuraCliente(-1, campoDaConsulta);
//                        return listaDeClientes;
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(tela, "Digite um nome ou valor valido.");
//                return null;
//            }
//        } catch (VendaException e) {
//            throw new VendaException("Erro na fonte de dados.", e.getCause());
//        }
//    }
    public static Venda CreateVendaByRequest(HttpServletRequest request)
            throws VendaException {

        try {

            //Cliente
            String cpf = "";
            if (request.getParameter("cliente") != null && !request.getParameter("cliente").equals("")) {
                cpf = request.getParameter("cliente");
            } else {
                System.out.println("Cliente nao inserido.");
            }
            //Pegar idCliente por cpf
            List<PessoaFisica> listaClientes = ServicoCliente.ConsultarClientes(cpf);
            int idpessoa = listaClientes.get(0).getId();

            //Vendedor
            //int idVendedor = Pegar o id do usuario logado
            //Produtos
            String[] idProdutos = request.getParameterValues("produto");

            //Quantidade de produtos
            String[] quantProdutos = request.getParameterValues("quantidadeProduto");

            //Verifica o tamanho dos arrays adquiridos do request
            if (idProdutos.length != quantProdutos.length) {
                System.out.println("Os ParameterValues nao tem o mesmo tamanho");
            }

            //Lista de ItensVenda
            ArrayList<ItensVenda> lista = new ArrayList<>();

            for (int i = 0; i < idProdutos.length; i++) {

                int idProduto = Integer.parseInt(idProdutos[i]);
                int quantidade = Integer.parseInt(quantProdutos[i]);
                double valor = ServicoProduto.getPrecoProdutoById(idProduto);//Retornando -1 por enquanto

                ItensVenda item = new ItensVenda(idProduto, quantidade, valor);

                lista.add(item);
            }

            //Criando venda com os dados adquiridos acima
            Venda novaVenda = new Venda();

            novaVenda.setCodigo(ServicoVenda.geraCodVenda());

            //Pegar id_pessoa por cpf
            novaVenda.setIdPessoa(idpessoa);
            novaVenda.setDataVenda(Calendar.getInstance());
            //novaVenda.setIdVendedor(idVendedor); Ainda sem metodo
            novaVenda.setListaItensVenda(lista);
            novaVenda.sumValorTotal(); //Adiciona o valorTotal a venda

            return novaVenda;

        } catch (VendaException | NumberFormatException e) {
            throw new VendaException("Erro na criacao da venda do request do formulario", e.getCause());
        }

    }

    public static List<EstoqueProduto> AlteraEstoqueAtual(Venda novaVenda) {

        List<EstoqueProduto> listaAtualizada = new ArrayList<>();

        //O hardcode 7 seria a  filial
        int filial = 7;

        List<EstoqueProduto> listaAtual = ServicoEstoqueProduto.ListarEstoquePorIdsProduto(novaVenda.getListaItensVenda(), filial);

        //Alterar a listaAtual
        for (ItensVenda item : novaVenda.getListaItensVenda()) {
            for (EstoqueProduto estoqueProduto : listaAtual) {
                if (item.getIdProduto() == estoqueProduto.getId_produto()) {
                    listaAtualizada.add(
                            new EstoqueProduto(
                                    estoqueProduto.getId_produto(),
                                    filial,
                                    (estoqueProduto.getQuantidade() - item.getQuantidade())
                            ));
                }
            }
        }
        //Fim da ateracao

        return listaAtualizada;

    }

    public static void ConcluirVenda(Venda novaVenda) throws VendaException {
        try {
            //O 7 nesse hardcode seria a filial
            int filial = 7;

            //Altera o estoque atual subtraindo com a quantidade em venda
            List<EstoqueProduto> listaAtualizada = AlteraEstoqueAtual(novaVenda);

            //Antes de inserir a venda atualizar o estoque
            for (EstoqueProduto produtoComQuantidadeAlterada : listaAtualizada) {
                //Atualizacao do estoque
                ServicoEstoqueProduto.AtualizarEstoque(produtoComQuantidadeAlterada);
            }

            VendaDAO.inserir(novaVenda);

            //Inserir itensVenda com o id da venda
            int id = VendaDAO.getLastVendaID();
            VendaDAO.insertItensVenda(novaVenda.getListaItensVenda(), id);

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<Venda> ConsultaVendaByData(Date de, Date ate)
            throws VendaException {
        try {
            return VendaDAO.getVendaByDates(de, ate);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static int geraCodVenda()
            throws VendaException {
        try {

            int codigo = VendaDAO.countVendas();
            codigo++;

            while (codigo == VendaDAO.countVendas()) {
                codigo++;
            }

            return codigo;

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

}
