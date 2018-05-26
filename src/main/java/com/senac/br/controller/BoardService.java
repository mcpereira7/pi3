package com.senac.br.controller;

import com.senac.br.DAO.BoardDAO;
import com.senac.br.exception.UserException;
import com.senac.br.model.Board;
import java.sql.SQLException;

public class BoardService {
    
    public static void CreateBoard(Board board) throws UserException{
        
        try {
            BoardDAO.createBoard(board);
        } catch (Exception e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }
    
    public static void AlterBoard(Board board) throws UserException{
        
        try {
            BoardDAO.alterBoard(board);
        } catch (SQLException e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }
    
    public static void ArquiveBoard(int board) throws UserException{
        
        try {
            BoardDAO.arquiveBoard(board);
        } catch (SQLException e) {
            throw new UserException("Erro ao Criar o Board.", e.getCause());
        }
    }
}
