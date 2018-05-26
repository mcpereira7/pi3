package com.senac.br.model;

import java.util.Date;

public class Card {
    private int idCard;
    private int idBoard;
    private String cor;
    private String titulo;
    private Date dataCriacao;

    public Card(int idCard, int idBoard, String cor, String titulo, Date dataCriacao) {
        this.idCard = idCard;
        this.cor = cor;
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
}
