package com.senac.br.model;

import java.util.Date;

public class CardVideo extends Card{
    private String link;

    public CardVideo(String link, int idCard, int idBoard, String cor, String titulo, Date dataCriacao) {
        super(idCard, idBoard, cor, titulo, dataCriacao);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
