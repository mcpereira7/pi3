/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.model.produto;
import com.senac.pi.floricultura.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static void inserir(produto produto) throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "INSERT INTO Produto(idProduto, nome, descricao, tipo, dt_Cadastro, disable)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            stmtProduto = cn.prepareStatement(sqlProduto);
            stmtProduto.setInt(1, produto.getId());
            stmtProduto.setString(2, produto.getNome());
            stmtProduto.setString(3, produto.getDescricao());
            stmtProduto.setString(4, produto.getTipo());
        } catch (Exception e) {
        } finally {
            com.senac.pi.floricultura.connection.ConnectionFactory.closeConnection(cn, stmtProduto);
        }
    }

    public static void atualizarProduto(produto produto) throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "UPDATE Produto(idProduto, nome, descricao, tipo, dt_Cadastro, disable)"
                + "VALUES(?,?,?,?,?,?)";

    }

    public static void excluirProduto(produto produto) throws SQLException, Exception {
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
