/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.ItensVenda;
import com.senac.pi.floricultura.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class VendaDAO {

    private static Connection cn = null;

    public static void inserir(Venda venda)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO vendas (Codigo, id_Cliente, ValorTotal, Data, id_Vendedor)"
                + "VALUES (?, ?, ?, ?, ?)";

        cn = ConnectionFactory.getConnection();
        //Preciso da consulta de Pessoa

        try {

            //int idCliente = ClienteDAO.obterByCod(venda.getCliente().getCodCliente()).getId();
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, venda.getCodigo());
            stmt.setInt(2, venda.getIdPessoa());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setDate(4, new java.sql.Date(venda.getDataVenda().getTimeInMillis())); //Provavelmente vai dar erro
            stmt.setInt(5, venda.getIdVendedor());

            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static int countVendas()
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT COUNT(id_Venda) AS quantidade FROM vendas";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            int quantidade = rs.getInt("quantidade");

            return quantidade;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static List<Venda> listar()
            throws SQLException, Exception {

        List<Venda> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM vendas";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                //venda.setCodVenda(rs.getInt("id"));
                venda.setDataVenda((Calendar) rs.getObject("Data"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));

                resultado.add(venda);
            }

            return resultado;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static int getLastVendaID()
            throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        int id = -1;

        String sql = "SELECT Id Ultimo FROM vendas WHERE Data = (SELECT MAX(Data) FROM vendas)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("Ultimo");
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return id;
    }

    public static List<Venda> getVendaByDates(Date de, Date para)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Venda> resultado = new ArrayList<>();

        String sql = "SELECT * FROM vendas WHERE Data BETWEEN '?' AND '?'";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setDate(1, (java.sql.Date) de);
            stmt.setDate(2, (java.sql.Date) para);

            rs = stmt.executeQuery();

            while (rs.next()) {
                //Construtor adaptado
                Venda venda = new Venda(rs);
                resultado.add(venda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return resultado;
    }

    public static List<Venda> getVendaRelatorio(Date de, Date ate, String campoOrdenacao, boolean ASC)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Venda> resultado = new ArrayList<>();

        String sql = "SELECT * FROM vendas WHERE Data BETWEEN ? AND ? ORDER BY ? ?";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            Timestamp t = new Timestamp(de.getTime());
            Timestamp t2 = new Timestamp(ate.getTime());

            stmt.setTimestamp(1, t);
            stmt.setTimestamp(2, t2);
            stmt.setString(3, campoOrdenacao);
            stmt.setString(4, ASC ? "ASC" : "DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("Id"));
                //venda.setDataVenda(rs.getDate("Data"));
                //venda.setPessoa(DAO.ClienteDAO.obter(rs.getInt("idPessoa")));
                //venda.setListaItensVenda(DAO.VendaDAO.getItensVenda(rs.getInt("id")));
                venda.setValorTotal(rs.getFloat("ValorTotal"));

                resultado.add(venda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return resultado;
    }

    public static void insertItensVenda(List<ItensVenda> listaItens, int idVenda)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO ItensVenda (id_Venda, id_Produto, Quantidade, Valor)"
                + "VALUES (?, ?, ?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            for (ItensVenda itensVenda : listaItens) {

                stmt = cn.prepareStatement(sql);
                stmt.setInt(1, idVenda);
                stmt.setInt(2, itensVenda.getIdProduto());
                stmt.setInt(3, itensVenda.getQuantidade());
                stmt.setDouble(4, itensVenda.getValor());

                stmt.execute();
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static List<ItensVenda> getItensVenda(int idVenda)
            throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<ItensVenda> ItensVenda = new ArrayList<>();

        String sql = "SELECT * FROM ItensVenda WHERE idVenda = ?";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idVenda);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ItensVenda itemVenda = new ItensVenda();

                ItensVenda.add(itemVenda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return ItensVenda;
    }

    public static Calendar toCalendar(Date data) {
        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(data);
        return dataCal;
    }
}
