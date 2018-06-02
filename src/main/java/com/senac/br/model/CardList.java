/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.model;

import com.senac.br.exception.CardException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aayan
 * @param <E>
 */
public class CardList<E> extends ArrayList<E> {

    //Constructor
    public CardList() {
        
    }
    
    //Metodo de adicionar o elemento a lista de cards
    //adaptando o mesmo de acordo com o seu tipo
    public boolean addCard(Object conteudo, int idCard, String titulo,
            int tipo, Date dataCriacao) throws CardException {

        try {

            switch (tipo) {
                case 1:
                    //cardSimple
                    //Criando objeto
                    Card simples = new CardSimple((String) conteudo,
                            idCard,
                            titulo,
                            tipo,
                            dataCriacao);

                    //Setando o designe do mesmo
                    simples.setDesigne();

                    //Adicionando a lista
                    super.add((E) simples);

                    //retornando valor true
                    return true;

                case 2:
                    //cardVideo
                    //Criando objeto
                    Card video = new CardVideo((String) conteudo,
                            idCard,
                            titulo,
                            tipo,
                            dataCriacao);

                    //Setando o designe do mesmo
                    video.setDesigne();

                    //Adicionando a lista
                    super.add((E) video);

                    //retornando valor true
                    return true;

                case 3:
                    //cardPicture
                    //Criando objeto
                    Card picture = new CardPicture((String) conteudo,
                            idCard,
                            titulo,
                            tipo,
                            dataCriacao);

                    //Setando o designe do mesmo
                    picture.setDesigne();

                    //Adicionando a lista
                    super.add((E) picture);

                    //retornando valor true
                    return true;

                default:
                    return false;
            }
        } catch (Exception e) {
            throw new CardException("Erro ao adicionar card a lista", e.getCause());
        }
    }

}
