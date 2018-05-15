/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class ItensVenda {

    private int idVenda;
    private int idProduto;
    private int codigoProduto;
    private int quantidade;
    private double valor;

    public ItensVenda() {

    }

    public ItensVenda(int idProduto, int quantidade, double valor, int codigoProd) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigoProduto = codigoProd;
    }

    public ItensVenda(ResultSet rs) throws SQLException {
        this.idProduto = rs.getInt("id_Produto");
        this.codigoProduto = rs.getInt("Codigo");
        this.idVenda = rs.getInt("id_Venda");
        this.quantidade = rs.getInt("Quantidade");
        this.valor = rs.getDouble("Valor");
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
