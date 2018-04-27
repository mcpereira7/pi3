/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Red
 */
abstract class produto {

    //Atributos
    private int id; //id do banco de dados, auto-increment
    private float preco;
    private Date dataCadastro;
    private String nome;
    private String fornecedor;
    private String descricao;
    private String tipo;
    private int quantidadeVenda;
    private int quantidadeEstoque;//Se precisar
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the quantidadeVenda
     */
    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    /**
     * @param quantidadeVenda the quantidadeVenda to set
     */
    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    /**
     * @return the quantidadeEstoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the Disable
     */
    public boolean isDisable() {
        return Disable;
    }

    /**
     * @param Disable the Disable to set
     */
    public void setDisable(boolean Disable) {
        this.Disable = Disable;
    }
    
}
