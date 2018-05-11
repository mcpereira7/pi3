/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
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
public class ProdutoDAO {

    private static Connection cn = null;

    public static double getPriceById(int id)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT Preco FROM produto WHERE id_produto = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            double preco = rs.getDouble(1);

            return preco;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static List<Integer> getIdByCodigo(int[] codigos)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Integer> ids = new ArrayList<>();

        String sql = "SELECT id_produto FROM produto WHERE ";

        int counter = 0;
        for (int i : codigos) {
            if (counter == 0) {
                sql += "Codigo = " + i;
            } else {
                sql += " or Codigo = " + i;
            }
            if (counter == codigos.length - 1) {
                //sql += ")";
            }
            counter++;
        }

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt("id_produto"));
            }

            return ids;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }
}
