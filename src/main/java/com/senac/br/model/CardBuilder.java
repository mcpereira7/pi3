/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.model;

import java.util.Date;

/**
 *
 * @author aayan
 */
public class CardBuilder {

    public static Card build(Object conteudo, int idCard, int idBoard,
            String titulo, int tipo, Date dataCriacao, boolean arquivado) {

        switch (tipo) {
            case 1:
                //cardSimple
                //Criando objeto
                Card simples = new CardSimple((String) conteudo,
                        idCard,
                        idBoard,
                        titulo,
                        tipo,
                        dataCriacao,
                        arquivado);

                //Setando o designe do mesmo
                simples.setDesigne();

                //retornando o card
                return simples;

            case 2:
                //cardVideo
                //Criando objeto
                Card video = new CardVideo((String) conteudo,
                        idCard,
                        idBoard,
                        titulo,
                        tipo,
                        dataCriacao,
                        arquivado);

                //Setando o designe do mesmo
                video.setDesigne();

                //retornando o card
                return video;

            case 3:
                //cardPicture
                //Criando objeto
                Card picture = new CardPicture((String) conteudo,
                        idCard,
                        idBoard,
                        titulo,
                        tipo,
                        dataCriacao,
                        arquivado);

                //Setando o designe do mesmo
                picture.setDesigne();

                //retornando o card
                return picture;

            default:
                return null;
        }

    }

}
