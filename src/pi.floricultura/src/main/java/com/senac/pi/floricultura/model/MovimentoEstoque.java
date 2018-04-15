package com.senac.pi.floricultura.model;

import java.util.Date;

public class MovimentoEstoque {
    private int id_movimento;
    private int id_produto;
    private int id_pessoa;
    private int quantidade;
    private Date Data;
    private int tipo;
    private int natureza;

    public MovimentoEstoque(int id_movimento, int id_produto, int id_pessoa, int quantidade, Date Data, int tipo, int natureza) {
        this.id_movimento = id_movimento;
        this.id_produto = id_produto;
        this.id_pessoa = id_pessoa;
        this.quantidade = quantidade;
        this.Data = Data;
        this.tipo = tipo;
        this.natureza = natureza;
    }

    public int getId_movimento() {
        return id_movimento;
    }

    public void setId_movimento(int id_movimento) {
        this.id_movimento = id_movimento;
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

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNatureza() {
        return natureza;
    }

    public void setNatureza(int natureza) {
        this.natureza = natureza;
    }
}
