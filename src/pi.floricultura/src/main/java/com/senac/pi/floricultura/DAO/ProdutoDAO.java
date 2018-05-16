/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.model.Produto;
import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.GerarCodigo;
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
    private GerarCodigo cod = new GerarCodigo();

    public static float getPriceById(int id)
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

            float preco = rs.getFloat(1);

            return preco;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static void inserir(Produto produto) throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "INSERT INTO Produto(Nome, Descricao, Preco, Tipo, Disable)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            stmtProduto = cn.prepareStatement(sqlProduto);
            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setString(2, produto.getDescricao());
            stmtProduto.setFloat(3, produto.getPreco());
//            stmtProduto.setInt(4, produto.getTipo());
            stmtProduto.setInt(4, 1);
            stmtProduto.setBoolean(5, false);
            stmtProduto.execute();
        } catch (Exception e) {
        } finally {
            com.senac.pi.floricultura.connection.ConnectionFactory.closeConnection(cn, stmtProduto);
        }
    }

    public static void atualizarProduto(Produto produto) throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "UPDATE Produto(idProduto, nome, descricao, tipo, dt_Cadastro, disable)"
                + "VALUES(?,?,?,?,?,?)";

    }

    public static String getProdutoByNome(String nome)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT Nome FROM produto WHERE Nome = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            rs.next();

            String procura = rs.getString(1);

            return procura;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static int getProdutoByTipo(int tipo)
            throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT Tipo FROM produto WHERE Tipo = ?";
        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setInt(1, tipo);

            rs = stmt.executeQuery();

            rs.next();

            int procura = rs.getInt(1);

            return procura;
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static void excluirProduto(Produto produto) throws SQLException, Exception {
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
