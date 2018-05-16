package com.senac.br.model;

import java.util.Date;

public class CardVideo extends Card{
    private String link;

    public CardVideo(String link, String cor, String titulo, Date dataCriacao, boolean apagado) {
        super(cor, titulo, dataCriacao, apagado);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
