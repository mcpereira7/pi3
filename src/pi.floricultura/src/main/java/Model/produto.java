/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

public class produto {

    //Atributos
    private int id; //id do banco de dados, auto-increment
    private float preco;
    private String nome;
    private String fornecedor;
    private String descricao;
    private String tipo;
    private int quantidadeVenda;
    private int quantidadeEstoque;//Se precisar
    private Date dataCadastro;
    private boolean Disable;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
        return Disable;
    }

    public void setDisable(boolean Disable) {
        this.Disable = Disable;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
