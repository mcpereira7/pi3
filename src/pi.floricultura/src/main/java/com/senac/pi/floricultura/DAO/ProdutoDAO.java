/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static List<Integer> getIdByNomes(String[] nomes)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Integer> ids = new ArrayList<>();

        String sql = "SELECT id_produto FROM produto WHERE ";

        cn = ConnectionFactory.getConnection();

        int counter = 0;
        for (String nome : nomes) {
            if (counter == 0) {
                sql += "Nome = " + "'" + nome + "'";
            } else {
                sql += " or Nome = " + "'" + nome + "'";
            }

            counter++;
        }

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

    public static Produto getProdutoByNome(String nome)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM produto WHERE Nome = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            rs.next();

            Produto consultado = new Produto(rs);

            return consultado;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static List<Integer> getProdutoByTipo(int[] tipos)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Integer> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto WHERE Tipo = ?";

        cn = ConnectionFactory.getConnection();

        int counter = 0;
        for (int tipo : tipos) {
            if (counter == 0) {
                sql += "Tipo = " + "'" + tipo + "'";
            } else {
                sql += " or Tipo = " + "'" + tipo + "'";
            }
            counter++;
        }

        try {

            stmt = cn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt("Tipo"));
            }

            return lista;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

    }

    public static void inserir(Produto produto)
            throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "INSERT INTO produto(Nome, Descricao, Preco, Tipo, Disable) "
                + "VALUES(?,?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            stmtProduto = cn.prepareStatement(sqlProduto);
            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setString(2, produto.getDescricao());
            stmtProduto.setFloat(3, produto.getPreco());
            stmtProduto.setInt(4, produto.getTipo());
            stmtProduto.setBoolean(5, false);
            stmtProduto.execute();
        } catch (Exception e) {
        } finally {
            com.senac.pi.floricultura.connection.ConnectionFactory.closeConnection(cn, stmtProduto);
        }
    }

    public static void atualizarProduto(Produto produto)
            throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        cn = ConnectionFactory.getConnection();

        String sqlProduto = "UPDATE Produto(Nome, Descricao, Preco, Tipo, Disable)"
                + "VALUES(?,?,?,?,?)";

        try {
            stmtProduto = cn.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS);

            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setString(2, produto.getDescricao());
            stmtProduto.setFloat(3, produto.getPreco());
            stmtProduto.setInt(4, produto.getTipo());
            stmtProduto.setBoolean(5, produto.isDisable());
            stmtProduto.execute();

            ResultSet rs = stmtProduto.getGeneratedKeys();

        } catch (SQLException e) {
        } finally {
            ConnectionFactory.closeConnection(null, stmtProduto);
        }
    }

    public static void excluirProduto(Produto produto)
            throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "UPDATE Produto SET disable=? WHERE (id_produto =?) ";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, produto.getId());
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }
   
}
