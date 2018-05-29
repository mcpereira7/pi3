package com.senac.br.controller;

import com.senac.br.DAO.CardDAO;
import com.senac.br.exception.CardException;
import com.senac.br.model.Card;
import java.sql.SQLException;

public class CardService {

    public static void createCard(Card card) throws CardException {

        try {
            CardDAO.createCard(card);
        } catch (Exception e) {
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
}
