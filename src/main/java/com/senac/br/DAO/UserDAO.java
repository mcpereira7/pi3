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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class UserDAO {

    private static Connection cn = null;

    public static int createUser(User user)
            throws SQLException {

        String sql = "INSERT INTO usuario (nome, login, email, senha) "
                + "VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        ResultSet rs;
        int idUser = 0;

        try {

            cn = ConnectionFactory.getConnection();

            stmt = cn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());

            stmt.execute();

            //Obter ultimo id adicionado
            String lastIdInserted = "SELECT MAX(usuario.idusuario) AS idUser FROM usuario";

            rs = stmt.executeQuery(lastIdInserted);

            while (rs.next()) {
                idUser = rs.getInt("idUser");
            }

            return idUser;

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuario no banco.(UserDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void alterUser(User user, String newPass) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE Usuario SET nome = ?, email = ?, senha = ?"
                + "WHERE idUsuario = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, newPass);
            //WHERE
            stmt.setInt(4, user.getIdUser());
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Atulizar Usuário.(UserDAO)", e.getCause());
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
                        rs.getInt("idboarddefault"),
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

    public static void updateUserBoardDefault(int idUser, int idBoard)
            throws SQLException {

        String sql = "UPDATE usuario SET usuario.idboarddefault = ? "
                + "WHERE usuario.idusuario = ?";

        cn = ConnectionFactory.getConnection();

        PreparedStatement stmt;

        stmt = cn.prepareStatement(sql);

        try {

            stmt.setInt(1, idBoard);
            stmt.setInt(2, idUser);

            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar o board default do usuario.(UserDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

}
