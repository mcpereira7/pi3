/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.model.ItensVenda;
import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.model.Venda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vinicius
 */
public class ServicoVenda {

    public static Venda CreateVendaByRequest(HttpServletRequest request)
            throws VendaException {

        try {

            //Cliente
            String cpf = "";
            if (request.getParameter("cliente") != null
                    && !request.getParameter("cliente").equals("")) {

                cpf = request.getParameter("cliente");
                //Retira os pontos e trassos do cpf que foram adicionados
                //pelo .mask do jquery
                cpf = cpf.replaceAll(".", "");
                cpf = cpf.replaceAll("-", "");
                cpf = cpf.trim();

            } else {
                System.out.println("Cliente nao inserido.");
            }
            //Pegar idCliente por cpf
            List<PessoaFisica> listaClientes = ServicoCliente.ConsultarClientes(cpf);
            int idpessoa = listaClientes.get(0).getId();

            //Vendedor
            //int idVendedor = Pegar o id do usuario logado
            //Produtos
            String[] nomesProduto = request.getParameterValues("produto");

            //Pegar idProduto por codigo do produto
            List<Integer> idProdutos = ServicoProduto.getProdutoIdByNomes(nomesProduto);

            //Quantidade de produtos
            String[] quantProdutos = request.getParameterValues("quantidadeProduto");

            //Verifica o tamanho dos arrays adquiridos do request
            if (nomesProduto.length != quantProdutos.length) {
                throw new VendaException("Os ParameterValues nao tem o mesmo tamanho");
            }
            //Lista de ItensVenda
            ArrayList<ItensVenda> lista = new ArrayList<>();

            int countForList = idProdutos.size() - 1;

            for (int i = 0; i < nomesProduto.length; i++) {

                int idProduto = idProdutos.get(countForList);
                String nome = nomesProduto[i];
                int quantidade = Integer.parseInt(quantProdutos[i]);
                double valor = ServicoProduto.getPrecoProdutoById(idProduto);

                ItensVenda item = new ItensVenda(idProduto, quantidade, valor, nome);

                lista.add(item);
                countForList--;
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

    public static List<EstoqueProduto> AlteraEstoqueAtual(Venda novaVenda)
            throws VendaException {

        List<EstoqueProduto> listaAtualizada = new ArrayList<>();

        //O hardcode 7 seria a  filial
        int filial = 7;

        try {
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

                        if (estoqueProduto.getQuantidade() < 0) {
                            throw new VendaException("Não possuimos está quantidade de produtos em estoque");
                        }
                    }
                }
            }
            //Fim da ateracao

            return listaAtualizada;
        } catch (VendaException e) {
            throw new VendaException("Erro ao alterar estoque do produto");
        }

    }

    public static boolean ValidaQuantidades(Venda quaseConcluida) {

        int idFilial = 7;

        List<EstoqueProduto> listaAtual = ServicoEstoqueProduto.ListarEstoquePorIdsProduto(quaseConcluida.getListaItensVenda(), idFilial);

        //Alterar a listaAtual
        for (ItensVenda item : quaseConcluida.getListaItensVenda()) {
            for (EstoqueProduto estoqueProduto : listaAtual) {
                if (item.getIdProduto() == estoqueProduto.getId_produto()) {

                    //VErifica se tem a quantidade de produtos em estoque
                    if ((estoqueProduto.getQuantidade() - item.getQuantidade()) < 0) {
                        return false;
                    }
                }
            }
        }
        //Fim da ateracao
        return true;

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
                //Quantidade enviada na lista é a quantidade em estoque 
                //já subtraida dos produtos na venda
                ServicoEstoqueProduto.AtualizarEstoqueVenda(produtoComQuantidadeAlterada);
            }

            VendaDAO.inserir(novaVenda);

            //Inserir itensVenda com o id da venda
            int id = VendaDAO.getLastVendaID();
            VendaDAO.insertItensVenda(novaVenda.getListaItensVenda(), id);

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<ItensVenda> GetItensVendaByVendaId(Venda venda) {

        List<ItensVenda> lista = new ArrayList<>();

        try {
            lista = (ArrayList) VendaDAO.getItensVenda(venda.getId());
        } catch (Exception ex) {
            Logger.getLogger(ServicoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static List<Venda> ConsultaVendaByData(Date de, Date ate)
            throws VendaException {

        List<Venda> listaVendas;
        List<ItensVenda> listaItens;
        List<Venda> listaVendasComItens = new ArrayList<>();

        try {

            listaVendas = VendaDAO.getVendaByDates(de, ate);

            for (Venda venda : listaVendas) {

                listaItens = GetItensVendaByVendaId(venda);
                venda.setListaItensVenda((ArrayList<ItensVenda>) listaItens);
                listaVendasComItens.add(venda);
            }

            return listaVendasComItens;

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static int geraCodVenda()
            throws VendaException {
        try {

            int codigo = VendaDAO.getMaxCodigo();
            codigo++;

            return codigo;

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

}
