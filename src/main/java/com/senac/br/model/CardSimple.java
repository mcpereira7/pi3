package com.senac.br.model;

import java.util.Date;

public class CardSimple extends Card{
    private String conteudo;

    public CardSimple(String conteudo, int idCard, int idBoard, String cor, String titulo, Date dataCriacao) {
        super(idCard, idBoard, cor, titulo, dataCriacao);
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
