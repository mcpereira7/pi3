/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class FilialDAO {

    private static Connection cn = null;

    public static void inserirFilial(Filial filial) throws SQLException, Exception {
        PreparedStatement stmtFilial = null;

        String sql = "INSERT INTO PessoaJuridica (id_pessoa, CNPJ, IE, ehCliente, "
                + "ehEmpresa,  Responsavel, Email, Telefone, Telefone2)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";

        cn = ConnectionFactory.getConnection();

        try {
            PessoaDAO.InserirPessoa(filial, cn);

            
            stmtFilial = cn.prepareStatement(sql);
            stmtFilial.setInt(1, filial.getId());
            stmtFilial.setString(2, filial.getCnpj());
            stmtFilial.setString(3, filial.getInscEs());
            stmtFilial.setBoolean(4, false);
            stmtFilial.setBoolean(5, true);
            stmtFilial.setString(6, filial.getResponsavel());
            stmtFilial.setString(7, filial.getEmail());
            stmtFilial.setString(8, filial.getTelefone());
            stmtFilial.setString(9, filial.getTelefone2());
            stmtFilial.execute();
            
        } catch (SQLException e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtFilial);
        }
    }
    
    public static void inserirFilialName(Filial filial) 
            throws SQLException, Exception{
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Filial (id_pessoa, codigoFilial)"
                + "VALUES (?,?);";
        
        cn = ConnectionFactory.getConnection();
        
        try {
            
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, filial.getId());
            stmt.setString(2, filial.getCodigoFilial());
            stmt.execute();
            
        } finally  {
        }
        
    }

    public static void atualizarFilial(Filial filial) 
            throws SQLException, Exception {
        PreparedStatement stmtFilial = null;

        String sql = "UPDATE PessoaJudirica SET id_pessoa=?, CNPJ=?, IE=?, ehCliente=?, "
                + "ehEmpresa=?, Responsavel=?, Email=?, Telefone=?, Telefone2=?"
                + " WHERE id_pessoa=?;";

        cn = ConnectionFactory.getConnection();

        try {
            PessoaDAO.atualizarPessoa(filial, cn);

            stmtFilial = cn.prepareStatement(sql);

            stmtFilial.setInt(1, filial.getId());
            stmtFilial.setString(2, filial.getCnpj());
            stmtFilial.setString(3, filial.getInscEs());
            stmtFilial.setBoolean(4, filial.isEhCliente());
            stmtFilial.setBoolean(5, filial.isEhEmpresa());
            stmtFilial.setBoolean(6, filial.isDisable());
            stmtFilial.setString(7, filial.getResponsavel());
            stmtFilial.setString(8, filial.getEmail());
            stmtFilial.setString(9, filial.getTelefone());
            stmtFilial.setString(10, filial.getTelefone2());
            stmtFilial.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtFilial);
        }
    }

    public static List<Filial> listaFilial() throws SQLException, Exception {
        List<Filial> listaFilial = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT p.id_Pessoa,  pjf.codigoFilial, p.Nome, p.Apelido, p.TipoPessoa, p.dt_Cadastro\n"
                + "	   ,pj.CNPJ, pj.IE, pj.email, pj.telefone, pj.telefone2\n"
                + "       ,e.CEP, e.log, e.numero, e.complemento, e.bairro, e.cidade, e.uf\n"
                + "FROM pessoa p \n"
                + "LEFT JOIN filial pjf ON p.id_Pessoa=pjf.id_pessoa\n"
                + "INNER JOIN pessoajuridica pj ON p.id_Pessoa=pj.id_Pessoa AND pj.ehEmpresa=true\n"
                + "JOIN endereco e on e.id_Pessoa=p.id_Pessoa;";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filial filial = new Filial();

                filial.setId(rs.getInt("id_Pessoa"));
                filial.setCodigoFilial(rs.getString("codigoFilial"));
                filial.setNome(rs.getString("Nome"));
                filial.setApelido(rs.getString("Apelido"));
                filial.setTipo(rs.getInt("TipoPessoa"));
                filial.setCnpj(rs.getString("CNPJ"));
                filial.setInscEs(rs.getString("IE"));
                filial.setData(rs.getDate("dt_cadastro"));
                filial.setEmail(rs.getString("email"));
                filial.setTelefone(rs.getString("telefone"));
                filial.setTelefone2(rs.getString("telefone2"));

                listaFilial.add(filial);
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaFilial;
    }
}
