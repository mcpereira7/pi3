/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class UsuarioDAO {

    private static Connection cn = null;

    public static Usuario getUser(String user) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usuarios WHERE Login = '?'";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            rs = stmt.executeQuery();

            rs.next();

            Usuario logado = new Usuario(rs);

            return logado;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

}
