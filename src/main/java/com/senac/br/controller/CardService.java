package com.senac.br.controller;

import com.senac.br.DAO.CardDAO;
import com.senac.br.exception.CardException;
import com.senac.br.model.Card;
import com.senac.br.model.CardPicture;
import com.senac.br.model.CardSimple;
import com.senac.br.model.CardVideo;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class CardService {

    public static void createCard(HttpServletRequest request) throws CardException {

        Card novo;

        try {

            //Obter informacoes da request
            //id do board atual
            Object idBoardObj = request.getSession().getAttribute("idboard");
            int idBoard = (int) idBoardObj;

            //tipo
            String tipotxt = request.getParameter("tipo");
            int tipo = Integer.parseInt(tipotxt);

            //titulo
            String titulo = request.getParameter("titulo");

            Date atual = new Date();

            //conteudo
            //colocar o objeto de receber imagem aqui tbm
            String conteudo = request.getParameter("conteudo");

            //Insercao do card no banco de acordo com o seu tipo
            switch (tipo) {
                case 1:
                    //cardsimples tipo 1
                    Card simples = new CardSimple(conteudo, titulo, tipo, atual);
                    simples.setIdBoard(idBoard);
                    simples.setDesigne();
                    CardDAO.create(simples);
                    break;
                case 2:
                    //cardvideo tipo 2
                    Card video = new CardVideo(conteudo, titulo, tipo, atual);
                    video.setIdBoard(idBoard);
                    video.setDesigne();
                    CardDAO.create(video);
                    break;
                case 3:
                    //Aqui seria criado um cardPicture tipo 3
                    System.out.println("Ainda nao implementei o card de imagem");
                    throw new CardException("Erro ao Inserir o Card.");
                default:
                    throw new CardException("Erro ao identificar tipo.");
            }

        } catch (SQLException e) {
            throw new CardException("Erro ao Inserir o Card.", e.getCause());
        }
    }

    public static void alterCard(Card card) throws CardException {

        try {
            CardDAO.alterCard(card);
        } catch (SQLException e) {
            throw new CardException("Erro ao Atualizar o Card.", e.getCause());
        }
    }

    public static void arquiveCard(int card) throws CardException {

        try {
            CardDAO.arquiveCard(card);
        } catch (SQLException e) {
            throw new CardException("Erro ao Arquivar o Card.", e.getCause());
        }
    }

    public static Card getCardById(int id) throws CardException {

        try {
            return CardDAO.read(id);
        } catch (SQLException e) {
            throw new CardException("Erro ao obter o Card.", e.getCause());
        }
    }
}
