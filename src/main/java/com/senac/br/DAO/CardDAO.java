/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aayan
 */
public class CardDAO {

    private static Connection cn = null;

    public static boolean createCard(Card novo)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO card (titulo, descricao, dataCriacao) "
                + "VALUES (?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setString(1, novo.getTitulo());
            stmt.setString(2, novo.getCor());
            stmt.setDate(3, (java.sql.Date) novo.getDataCriacao());

            boolean inserido = stmt.execute();

            return inserido;

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static void alterCard(Card card) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE Card SET titulo = ?, cor = ?"
                + "WHERE idCard = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, card.getTitulo());
            stmt.setString(2, card.getCor());
            //WHERE
            stmt.setInt(3, card.getIdCard());
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Atulizar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void arquiveCard(int card) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE Card SET arquivado = ? "
                + "WHERE idCard = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, card);
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Arquivar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<Card> listCardByBoard(int idBoard) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "";
        List<Card> listaCard = new ArrayList<>();

        sql = "SELECT * FROM card WHERE idBoard = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idBoard);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Card card = new Card(
                        rs.getInt("idCard"),
                        rs.getInt("idBoard"),
                        rs.getString("cor"),
                        rs.getString("titulo"),
                        rs.getDate("dataCriacao")
                );
                listaCard.add(card);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaCard;
    }

}
