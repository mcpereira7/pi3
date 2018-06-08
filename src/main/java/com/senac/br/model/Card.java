package com.senac.br.model;

import java.util.Date;

public abstract class Card {

    //Attributes
    private int idCard;
    private int idBoard;
    private String titulo;
    private String cor;
    private int tipo;
    private Date dataCriacao;
    private boolean arquivado;

    //Getters & Setters
    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(int idBoard) {
        this.idBoard = idBoard;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    //Methods
    public abstract void setDesigne();

    public abstract void UrgencyCheck();

    public abstract int getCardTipo();

    public abstract Object getCardContent();

}
