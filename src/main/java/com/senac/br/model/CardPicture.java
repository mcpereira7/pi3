package com.senac.br.model;

import java.io.File;
import java.util.Date;

public class CardPicture extends Card{
    private File img;

    public CardPicture(File img, String cor, String titulo, Date dataCriacao, boolean apagado) {
        super(cor, titulo, dataCriacao, apagado);
        this.img = img;
    }
    
    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }
}
