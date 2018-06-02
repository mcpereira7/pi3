package com.senac.br.model;

import java.io.File;
import java.util.Date;

public class CardPicture extends Card {

    private File img;

    //Constuctors
    //full
    public CardPicture(File img, int idCard, int idBoard, String titulo,
            int tipo, Date dataCriacao, boolean arquivado) {
        //local
        this.img = img;

        //classe abstrata
        super.setIdCard(idCard);
        super.setIdBoard(idBoard);
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
        super.setArquivado(arquivado);
    }

    public CardPicture(File img, int idCard, String titulo, int tipo,
            Date dataCriacao) {

        //local
        this.img = img;

        //classe abstrata
        super.setIdCard(idCard);
        super.setTitulo(titulo);
        super.setTipo(tipo);
        super.setDataCriacao(dataCriacao);
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
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
        return this.img;
    }

}
