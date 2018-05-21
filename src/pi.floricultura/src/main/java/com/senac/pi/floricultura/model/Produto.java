/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Produto {

    //Atributos
    private int id; //id do banco de dados, auto-increment
    private int codigo;
    private float preco;
    private String nome;
    private String fornecedor;
    private String descricao;
    private int tipo;
    private String tipoNome;
    private int quantidadeVenda;
    private int quantidadeEstoque;
    private Date dataCadastro;
    private boolean disable;
    private String[] tipos = {"Tipo não definido", "Flor", "Planta", "Rosa", "Ilícita"};

    //Default
    public Produto() {
    }

    //Construtor usado na consulta de produto
    public Produto(ResultSet rs) throws SQLException {
        this.nome = rs.getString("Nome");
        this.preco = rs.getFloat("Preco");

    }

    //Construtor para testes de listagem
    public Produto(float preco, String nome, String descricao, int tipo, Date dataCadastro) {
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        setTipo(tipo);
        this.dataCadastro = dataCadastro;
    }

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        setTipoNome(tipo);
    }

    public String getTipoNome() {
        return tipoNome;
    }

    public void setTipoNome(int tipo) {
        this.tipoNome = tipos[(tipo - 1)];
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
