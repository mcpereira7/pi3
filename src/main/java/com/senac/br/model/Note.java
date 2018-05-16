package com.senac.br.model;

import java.util.Date;
import java.util.List;

public class Note {
    private String titulo;
    private Date dataCriacao;
    private List<Card> listCards;

    public Note(String titulo, Date dataCriacao, List<Card> listCards) {
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
        this.listCards = listCards;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Card> getListCards() {
        return listCards;
    }

    public void setListCards(List<Card> listCards) {
        this.listCards = listCards;
    }
    
    
}
