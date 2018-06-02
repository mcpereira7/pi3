package com.senac.br.model;

import java.util.Date;

public class CardPicture extends Card {

    private String imgLink;

    //Constuctors
    //full
    public CardPicture(String img, int idCard, int idBoard, String titulo,
            int tipo, Date dataCriacao, boolean arquivado) {
        //local
        this.imgLink = img;

        //classe abstrata
        super.setIdCard(idCard);
        super.setIdBoard(idBoard);
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
        super.setArquivado(arquivado);
    }

    public CardPicture(String img, int idCard, String titulo, int tipo,
            Date dataCriacao) {

        //local
        this.imgLink = img;

        //classe abstrata
        super.setIdCard(idCard);
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
    }

    public CardPicture(String img, String titulo, int tipo,
            Date dataCriacao) {

        //local
        this.imgLink = img;

        //classe abstrata
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
    }

    public String getImg() {
        return imgLink;
    }

    public void setImg(String img) {
        this.imgLink = img;
    }

    //Methods
    @Override
    public void setDesigne() {

        //modificacoes nessessarias para o tipo de objeto File
        setCor("#6699ff");
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
        return this.imgLink;
    }

}
