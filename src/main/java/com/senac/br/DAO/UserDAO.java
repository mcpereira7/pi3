/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class UserDAO {

    private static Connection cn = null;

    public static void createUser(User user)
            throws SQLException {

        String sql = "INSERT INTO usuario (nome, login, email, senha) "
                + "VALUES(?, ?, ?, ?)";

        PreparedStatement stmt;

        cn = ConnectionFactory.getConnection();

        stmt = cn.prepareStatement(sql);

        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getLogin());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getSenha());

        stmt.execute();
    }

}
