package com.senac.br.controller;

import com.senac.br.DAO.BoardDAO;
import com.senac.br.DAO.CardDAO;
import com.senac.br.exception.BoardException;
import com.senac.br.exception.CardException;
import com.senac.br.exception.UserException;
import com.senac.br.model.Board;
import java.sql.SQLException;
import java.util.Date;

public class BoardService {

    public static void CreateBoard(Board board) throws UserException {

        try {
            BoardDAO.createBoard(board);
        } catch (Exception e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }

    public static int CreateBoardDefault(int idUser) throws BoardException {

        try {

            Board padrao = new Board(
                    "Default",
                    new Date(),
                    idUser);

            int idBoard = BoardDAO.createBoardDefault(padrao);

            return idBoard;

        } catch (SQLException e) {
            throw new BoardException("Erro ao Criar o Board.", e.getCause());
        }
    }

    public static Board GetBoardById(int idBoard)
            throws BoardException, CardException {

        try {
            Board padrao = BoardDAO.getBoardById(idBoard);

            padrao.setListCards(CardDAO.listCardByBoard(idBoard));

            return padrao;
        } catch (SQLException e) {
            throw new BoardException("Erro ao obter board padrao.(BoardService)", e.getCause());
        }
    }

    public static void AlterBoard(Board board) throws UserException {

        try {
            BoardDAO.alterBoard(board);
        } catch (SQLException e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }

    public static void ArquiveBoard(int board) throws UserException {

        try {
            BoardDAO.arquiveBoard(board);
        } catch (SQLException e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }
}
