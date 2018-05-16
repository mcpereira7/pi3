package com.senac.br.model;

import java.util.Date;

public class CardSimple extends Card{
    private String conteudo;

    public CardSimple(String conteudo, String cor, String titulo, Date dataCriacao, boolean apagado) {
        super(cor, titulo, dataCriacao, apagado);
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
