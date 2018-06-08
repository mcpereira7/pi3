package com.senac.pi.floricultura.model;

public class EstoqueProdutoRelatorio extends EstoqueProduto{
    private double preco;
    private String nome;
    
    public EstoqueProdutoRelatorio(int id_produto, int id_pessoa, int quantidade, double preco, String nome) {
        super(id_produto, id_pessoa, quantidade);
        this.preco = preco;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
