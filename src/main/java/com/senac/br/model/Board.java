package com.senac.br.model;

import java.util.Date;
import java.util.List;

public class Board {

    private int idBoard;
    private int idUsuario;
    private String titulo;
    private Date dataCriacao;
    private CardList<Card> listCards;
    
    //Constructors
    public Board(int idBoard, String titulo, Date dataCriacao) {
        this.idBoard = idBoard;
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
    }

    public Board(String titulo, Date dataCriacao, int idUsuario) {
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
        this.idUsuario = idUsuario;
    }

    public Board(int idBoard, String titulo, CardList<Card> listCards) {
        this.idBoard = idBoard;
        this.titulo = titulo;
        this.listCards = listCards;
    }

    public Board(int idBoard, String titulo) {
        this.idBoard = idBoard;
        this.titulo = titulo;
    }
    
    //Getters & Settters
    public int getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(int idBoard) {
        this.idBoard = idBoard;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public void setListCards(CardList<Card> listCards) {
        this.listCards = listCards;
    }

}
