/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.exception.UserException;
import com.senac.br.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        PreparedStatement stmt = null;

        try {

            cn = ConnectionFactory.getConnection();

            stmt = cn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());

            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuario no banco.(UserDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static User getUserByLogin(String login, String senha)
            throws SQLException {

        ResultSet rs = null;
        User logado = null;

        String sql = "SELECT * FROM usuario WHERE usuario.login = ? AND usuario.senha = ?";

        PreparedStatement stmt;

        cn = ConnectionFactory.getConnection();

        stmt = cn.prepareStatement(sql);

        stmt.setString(1, login);
        stmt.setString(2, senha);

        try {

            rs = stmt.executeQuery();

            while (rs.next()) {

                logado = new User(
                        rs.getInt("idusuario"),
                        rs.getString("nome"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("senha"));
            }

            return logado;

        } catch (SQLException e) {
            throw new SQLException("Erro ao obter usuario com login e senha.(UserDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

}
