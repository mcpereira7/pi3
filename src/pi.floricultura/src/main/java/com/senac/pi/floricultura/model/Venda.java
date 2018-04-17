/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class Venda {

    private int id;
    private int idVenda;
    private Date data;
    private Pessoa pessoa;
    private List<ItensVenda> itensVenda = new ArrayList<>();
    private float valorTotal;

    public Venda() {
    }

    public Venda(ResultSet rs) throws SQLException, Exception {
        idVenda = rs.getInt("id");
        //   cliente = DAO.ClienteDAO.obter(rs.getInt("idCliente"));
        valorTotal = rs.getFloat("ValorTotal");
        data = rs.getDate("Data");
        itensVenda = com.senac.pi.floricultura.DAO.VendaDAO.getItensVenda(rs.getInt("idVenda"));

    }

    /*public void setProdutoNoItensVenda(Produto entrada) {

        ItensVenda item = new ItensVenda();

        item.setCodProduto(entrada.getId());
        item.setNome(entrada.getNome());
        item.setQuantidade(entrada.getQuantidadeVenda());
        item.setPreco(entrada.getPreco());

        itensVenda.add(item);
    } */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodVenda() {
        return idVenda;
    }

    public void setCodVenda(int codVenda) {
        this.idVenda = codVenda;
    }

    public Date getDataVenda() {
        return data;
    }

    public void setDataVenda(Date dataVenda) {
        this.data = dataVenda;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ItensVenda> getListaItensVenda() {
        return itensVenda;
    }

    public void setListaItensVenda(List<ItensVenda> listaProdutos) {
        this.itensVenda = listaProdutos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
