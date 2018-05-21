package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.exceptions.MovimentoEstoqueException;
import com.senac.pi.floricultura.model.MovimentoEstoque;
import com.senac.pi.floricultura.utilitarios.AuxiliaresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentoEstoqueDAO {

    public static void CadastrarMovimentoEstoque(MovimentoEstoque movimentoEstoque)
            throws MovimentoEstoqueException {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO movimentoestoque (Data, Quantidade, id_pessoa, Tipo, Natureza, id_produto) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(movimentoEstoque.getDataCalendar().getTimeInMillis()));
            stmt.setInt(2, movimentoEstoque.getQuantidade());
            stmt.setInt(3, movimentoEstoque.getId_pessoa());
            stmt.setInt(4, movimentoEstoque.getTipo());
            stmt.setInt(5, movimentoEstoque.getNatureza());
            stmt.setInt(6, movimentoEstoque.getId_produto());

            boolean eae = stmt.execute();
            
            System.out.println(eae);

        } catch (Exception e) {
            throw new MovimentoEstoqueException("Erro ao cadastrar movimento de estoque.", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<MovimentoEstoque> ListarMovimentoEstoque(Integer id_produto,
            Integer id_pessoa, Date dataInicial, Date dataFinal, Integer tipo, Integer natureza) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[6];
        String sql = "";
        List<MovimentoEstoque> listaMovimentoEstoque = new ArrayList<>();

        if (id_produto != null) {
            strWhere[0] = "id_produto = " + id_produto;
        }
        if (id_pessoa != null) {
            strWhere[1] = "id_pessoa = " + id_pessoa;
        }
        if (dataInicial != null || dataFinal != null) {
            strWhere[2] = AuxiliaresDAO.filtraRangeDate("data", dataInicial, dataFinal);
        }
        if (tipo != null) {
            strWhere[3] = "tipo = " + tipo;
        }
        if (natureza != null) {
            strWhere[4] = "natureza = " + natureza;
        }

        if (strWhere[0] != null || strWhere[1] != null || strWhere[2] != null
                || strWhere[3] != null || strWhere[4] != null) {
            sql = "SELECT * FROM movimentoEstoque WHERE " + AuxiliaresDAO.ligaVetorAND(strWhere);
        } else {
            sql = "SELECT id_produto FROM estoqueProduto";
        }

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MovimentoEstoque movimentoEstoque = new MovimentoEstoque(
                        rs.getInt("id_produto"),
                        rs.getInt("id_pessoa"),
                        rs.getInt("quantidade"),
                        rs.getDate("data"),
                        rs.getInt("tipo"),
                        rs.getInt("natureza"));
                listaMovimentoEstoque.add(movimentoEstoque);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaMovimentoEstoque;
    }

}
