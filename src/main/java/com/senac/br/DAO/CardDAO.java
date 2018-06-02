/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.DAO;

import com.senac.br.connection.ConnectionFactory;
import com.senac.br.exception.CardException;
import com.senac.br.model.Card;
import com.senac.br.model.CardBuilder;
import com.senac.br.model.CardList;
import com.senac.br.support.DataSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aayan
 */
public class CardDAO {

    private static Connection cn = null;

    public static void create(Card novo)
            throws SQLException {

        PreparedStatement stmt = null;

        cn = ConnectionFactory.getConnection();

        try {

            //Faz o sql de acordo com o tipo
            String sql;
            if (novo.getTipo() == 3) {
                //Em andamento
                //
                sql = "INSERT INTO card (idboard, titulo, tipo, cor, descricao, "//mudar descricao para imagem
                        + "dataCriacao) VALUES (?, ?, ?, ?, ?, ?)";

                stmt = cn.prepareStatement(sql);

                stmt.setInt(1, novo.getIdBoard());
                stmt.setString(2, novo.getTitulo());
                stmt.setInt(3, novo.getTipo());
                stmt.setString(4, novo.getCor());
                stmt.setString(5, (String) novo.getCardContent());

                //Data
                java.sql.Date sqlDate = DataSupport.UtilDateToSqlDate(novo.getDataCriacao());
                stmt.setDate(6, sqlDate);

            } else {
                sql = "INSERT INTO card (idboard, titulo, tipo, cor, descricao, "
                        + "dataCriacao) VALUES (?, ?, ?, ?, ?, ?)";

                stmt = cn.prepareStatement(sql);

                stmt.setInt(1, novo.getIdBoard());
                stmt.setString(2, novo.getTitulo());
                stmt.setInt(3, novo.getTipo());
                stmt.setString(4, novo.getCor());
                stmt.setString(5, (String) novo.getCardContent());

                //Data
                java.sql.Date sqlDate = DataSupport.UtilDateToSqlDate(novo.getDataCriacao());
                stmt.setDate(6, sqlDate);
            }

            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static Card read(int idcard)
            throws SQLException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM card WHERE idcard = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idcard);

            rs = stmt.executeQuery();

            rs.next();

            //idboard
            int idboard = rs.getInt("idboard");

            //titulo do card
            String titulo = rs.getString("titulo");

            //tipo do card
            int tipo = rs.getInt("tipo");

            //cor do card
            String cor = rs.getString("cor");

            //conteudo do card
            Object conteudo;
            if (tipo == 3) {
                conteudo = rs.getObject("imagem");
            } else {
                conteudo = rs.getObject("descricao");
            }

            //data de craicao do card
            java.util.Date utilDate = DataSupport.SqlDateToUtilDate(rs.getDate("dataCriacao"));

            //arquivado
            boolean arquivado = rs.getBoolean("arquivado");

            //retorna o card
            return CardBuilder.build(conteudo, idcard, idboard, titulo, tipo, utilDate, arquivado);

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static void alterCard(Card card) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE Card SET titulo = ?, cor = ?"
                + "WHERE idCard = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, card.getTitulo());
            stmt.setString(2, card.getCor());
            //WHERE
            stmt.setInt(3, card.getIdCard());
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Atulizar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void arquiveCard(int card) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "UPDATE Card SET arquivado = ? "
                + "WHERE idCard = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, card);
            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao Arquivar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<Card> listCardByBoard(int idBoard)
            throws SQLException, CardException {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        CardList<Card> listaCard = new CardList<>();

        String sql = "SELECT * FROM card WHERE idboard = ? AND arquivado = false";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idBoard);
            rs = stmt.executeQuery();

            while (rs.next()) {

                //id do card
                int idcard = rs.getInt("idcard");

                //titulo do card
                String titulo = rs.getString("titulo");

                //tipo do card
                int tipo = rs.getInt("tipo");

                //cor do card
                String cor = rs.getString("cor");

                //conteudo do card
                Object conteudo;
                if (tipo == 3) {
                    conteudo = rs.getObject("imagem");
                } else {
                    conteudo = rs.getObject("descricao");
                }

                //data de craicao do card
                java.util.Date utilDate = DataSupport.SqlDateToUtilDate(rs.getDate("dataCriacao"));

                //adiciona o card a lista de acordo com seu tipo
                listaCard.addCard(conteudo, idcard, titulo, tipo, utilDate);

            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao Listar Card.(CardDAO)", e.getCause());
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaCard;
    }

}
