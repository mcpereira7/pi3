package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.model.Board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    
    private static Connection cn = null;
    
    public static boolean createBoard(Board novo)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO board (titulo, dataCriacao) "
                + "VALUES (?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setString(1, novo.getTitulo());
            stmt.setDate(3, (java.sql.Date) novo.getDataCriacao());

            boolean inserido = stmt.execute();

            return inserido;

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir board.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static void alterBoard(Board board) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE board SET titulo = ? "
                + "WHERE idBoard = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, board.getTitulo());
            //WHERE
            stmt.setInt(3, board.getIdBoard());
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Atulizar Board.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void arquiveBoard(int board) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE board SET arquivado = ? "
                + "WHERE idBoard = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, board);
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Arquivar Board.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<Board> listBoard() throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "";
        List<Board> listaBoard = new ArrayList<>();

        sql = "SELECT * FROM board";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Board board = new Board(
                        rs.getInt("idBoard"),
                        rs.getString("titulo"),
                        rs.getDate("dataCriacao"),
                        CardDAO.listCardByBoard(rs.getInt("idBoard"))
                );
                listaBoard.add(board);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Board.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaBoard;
    }
    
    public static List<Board> listBoardByUser(int idUsuario) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "";
        List<Board> listaBoard = new ArrayList<>();

        sql = "SELECT * FROM card WHERE idUsuario = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Board board = new Board(
                        rs.getInt("idboard"),
                        rs.getString("titulo"),
                        rs.getDate("dataCriacao"),
                        CardDAO.listCardByBoard(rs.getInt("idboard"))
                );
                listaBoard.add(board);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Board.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaBoard;
    }
}
