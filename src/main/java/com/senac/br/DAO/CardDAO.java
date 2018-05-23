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
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class CardDAO {

    private static Connection cn = null;

    public static boolean createCard(Card novo)
            throws SQLException, Exception {

        PreparedStatement stmt;

        String sql = "INSERT INTO card (titulo, descricao) "
                + "VALUES (?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setString(1, novo.getTitulo());
            stmt.setString(2, novo.getCor());

            boolean inserido = stmt.execute();

            return inserido;

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir card.(CardDAO)", e.getCause());
        }

    }

}
