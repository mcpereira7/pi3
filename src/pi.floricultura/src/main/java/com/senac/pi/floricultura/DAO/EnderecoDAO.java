/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Endereco;
//import com.senac.pi.floricultura.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rerum
 */
public class EnderecoDAO {

    private static Connection cn = null;

    public static void inserirEndereco(Endereco endereco, int id_pessoa) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Endereco(id_pessoa, CEP, Log, Numero, Complemento, Bairro, Cidade, UF) VALUES (?,?,?,?,?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id_pessoa);
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getLog());
            stmt.setString(4, endereco.getNumero());
            stmt.setString(5, endereco.getComplemento());
            stmt.setString(6, endereco.getBairro());
            stmt.setString(7, endereco.getCidade());
            stmt.setString(8, endereco.getEstado());
            stmt.execute();
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static Endereco buscarEndereco(int id) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Endereco end = null;
        String sql = "Select * from endereco where id_pessoa = ?";
        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                end = new Endereco();

                end.setIdEndereco(rs.getInt("id_Endereco"));
                end.setId_Pessoa(id);
                end.setCep(rs.getString("CEP"));
                end.setLog(rs.getString("Log"));
                end.setNumero(rs.getString("Numero"));
                end.setComplemento(rs.getString("Complemento"));
                end.setBairro(rs.getString("Bairro"));
                end.setCidade(rs.getString("Cidade"));
                end.setEstado(rs.getString("UF"));
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return end;
    }

    public static void atualizarEndereco(Endereco end) throws SQLException, Exception {
        PreparedStatement stmt = null;
        String sql = "UPDATE senacpi3.endereco "
                + "SET\n"
                + "id_Endereco = ?, "
                + "id_Pessoa = ?, "
                + "CEP = ?, "
                + "Log = ?, "
                + "Numero = ?, "
                + "Complemento = ?, "
                + "Bairro = ?, "
                + "Cidade = ?, "
                + "UF = ? "
                + "WHERE id_Pessoa = ?";
        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, end.getIdEndereco());
            stmt.setInt(2, end.getId_Pessoa());
            stmt.setString(3, end.getCep());
            stmt.setString(4, end.getLog());
            stmt.setString(5, end.getNumero());
            stmt.setString(6, end.getComplemento());
            stmt.setString(7, end.getBairro());
            stmt.setString(8, end.getCidade());
            stmt.setString(9, end.getEstado());
            stmt.setInt(10, end.getId_Pessoa());
            stmt.execute();
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
}
