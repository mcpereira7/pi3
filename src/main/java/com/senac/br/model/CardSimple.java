package com.senac.br.model;

import java.util.Date;

public class CardSimple extends Card {

    private String conteudo;

    public CardSimple(String conteudo, int idCard, String titulo, int tipo, Date dataCriacao) {

        //local
        this.conteudo = conteudo;

        //classe abstrata
        super.setIdCard(idCard);
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
    }
    
    public CardSimple(String conteudo, String titulo, int tipo, Date dataCriacao) {

        //local
        this.conteudo = conteudo;

        //classe abstrata
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    //Methods
    @Override
    public void setDesigne() {
        setCor("#ffff66");
    }

    @Override
    public void UrgencyCheck() {

    }

    @Override
    public int getCardTipo() {
        return super.getTipo();
    }

    @Override
    public Object getCardContent() {
        return this.conteudo;
    }
}
