package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.EstoqueProduto;
import com.senac.pi.floricultura.utilitarios.AuxiliaresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstoqueProdutoDAO {

    //Metodo para verificar se já existe uma linha no banco para o produto + pessoa informado no objeto.
    public static boolean PossuiCadastroEstoque(int id_produto, int id_pessoa) {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT id_produto FROM estoqueProduto WHERE id_produto = ? AND id_pessoa = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            stmt.setInt(2, id_pessoa);

            rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return false;
    }

    public static void CadastrarEstoque(EstoqueProduto estoqueProduto) {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO estoqueProduto (id_produto, id_pessoa, quantidade) VALUES (?, ?, ?)";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setInt(1, estoqueProduto.getId_produto());
            stmt.setInt(2, estoqueProduto.getId_pessoa());
            stmt.setInt(3, estoqueProduto.getQuantidade());
            stmt.execute();

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void AtualizarEstoque(EstoqueProduto estoqueProduto) {
        PreparedStatement stmt = null;

        String sql = "UPDATE estoqueItem SET id_produto = ?, id_pessoa = ?, quantidade = ? "
                + "WHERE id_produto = ?, idPessoa = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setInt(1, estoqueProduto.getId_produto());
            stmt.setInt(2, estoqueProduto.getId_pessoa());
            stmt.setInt(3, estoqueProduto.getQuantidade());
            //WHERE
            stmt.setInt(4, estoqueProduto.getId_produto());
            stmt.setInt(5, estoqueProduto.getId_pessoa());
            stmt.execute();

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    // Poderá ser listado estoque por: item ou empresa
    public static List<EstoqueProduto> ListarEstoque(Integer id_produto, Integer id_pessoa) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[2];
        String sql = "";
        List<EstoqueProduto> listaEstoqueProduto = new ArrayList<>();

        if (id_produto != null) {
            strWhere[0] = "id_produto = " + id_produto;
        }
        if (id_pessoa != null) {
            strWhere[1] = "id_pessoa = " + id_pessoa;
        }

        if (strWhere[0] != null || strWhere[1] != null) {
            sql = "SELECT * FROM estoqueProduto WHERE " + AuxiliaresDAO.ligaVetorAND(strWhere);
        } else {
            sql = "SELECT * FROM estoqueProduto";
        }

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EstoqueProduto estoqueProduto = new EstoqueProduto(
                        rs.getInt("id_produto"),
                        rs.getInt("id_pessoa"),
                        rs.getInt("quantidade"));
                listaEstoqueProduto.add(estoqueProduto);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaEstoqueProduto;
    }
}
