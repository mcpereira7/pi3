package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.exception.CardException;
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

    public static int createBoardDefault(Board novo)
            throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs;
        int idBoard = 0;
        String sql = "INSERT INTO board (idusuario, titulo) "
                + "VALUES (?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setInt(1, novo.getIdUsuario());
            stmt.setString(2, novo.getTitulo());

            stmt.execute();

            //Obter ultimo id adicionado
            String lastIdInserted = "SELECT MAX(board.idboard) AS idBoard FROM board";

            rs = stmt.executeQuery(lastIdInserted);

            while (rs.next()) {
                idBoard = rs.getInt("idBoard");
            }

            return idBoard;

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir board default.(BoardDAO)", e.getCause());
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
                        rs.getString("titulo")
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
                        rs.getString("titulo")
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

    public static Board getBoardById(int idBoard)
            throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Board padrao = null;

        String sql = "SELECT * FROM board WHERE idboard = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idBoard);
            rs = stmt.executeQuery();

            while (rs.next()) {
                padrao = new Board(
                        rs.getInt("idboard"),
                        rs.getString("titulo")
                );
            }

            return padrao;

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Board por id.(BoardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }
}
