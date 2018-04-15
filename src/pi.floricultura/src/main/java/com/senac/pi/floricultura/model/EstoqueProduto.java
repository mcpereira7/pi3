package com.senac.pi.floricultura.model;

import com.senac.pi.floricultura.DAO.EstoqueProdutoDAO;

public class EstoqueProduto {
    private int id_produto;
    private int id_pessoa;
    private int quantidade;

    public EstoqueProduto(int id_produto, int id_pessoa, int quantidade) {
        this.id_produto = id_produto;
        this.id_pessoa = id_pessoa;
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean possuiCadastroEstoque(){
        return EstoqueProdutoDAO.possuiCadastroEstoque(this.id_produto,this.id_pessoa);
    }
}
