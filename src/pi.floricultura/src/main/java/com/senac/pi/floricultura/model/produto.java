/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.util.Date;

public class produto {

    //Atributos
    private int id; //id do banco de dados, auto-increment
    private float preco;
    private String nome;
    private String fornecedor;
    private String descricao;
    private int tipo;
    private int quantidadeVenda;
    private int quantidadeEstoque;
    private Date dataCadastro;
    private boolean disable;

    //Sem Construtor Padrão
    
    //Venda de produtos
    public int Venda(int quantidadeVenda) {
        if (getQuantidadeEstoque() > 0) {
            setQuantidadeEstoque(getQuantidadeEstoque() - quantidadeVenda);
        }
        return getQuantidadeEstoque();
    }

    //métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean Disable) {
        this.disable = Disable;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
