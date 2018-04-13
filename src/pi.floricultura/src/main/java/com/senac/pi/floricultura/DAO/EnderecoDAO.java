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
import java.sql.SQLException;

/**
 *
 * @author Rerum
 */
public class EnderecoDAO {

    private static Connection cn = null;

    public static void inserirEndereco(Endereco endereco) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Endereco(cod_objeto, CEP, Log, Numero, Complemento, Bairro, Cidade, UF) VALUES (?,?,?,?,?,?,?,?)";
        
        cn = ConnectionFactory.getConnection();
        
        try{
            stmt = cn.prepareStatement(sql);
                stmt.setString(1, endereco.getCodObjeto());
                stmt.setString(2, endereco.getCep());
                stmt.setString(3, endereco.getLog());
                stmt.setString(4, endereco.getNumero());
                stmt.setString(5, endereco.getComplemento());
                stmt.setString(6, endereco.getBairro());
                stmt.setString(7, endereco.getCidade());
                stmt.setString(8, endereco.getEstado());
            stmt.execute();
        }finally{
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
//    public static void inserirEndPessoa(Endereco endereco, Pessoa pessoa) throws SQLException, Exception{
//        PreparedStatement stmt = null;
//        
//        String sql = "INSERT INTO EnderecoPessoa(cod_ObjetoEndereco, cod_ObjetoPessoa, Numero, Complemento) VALUES (?,?,?,?)";
//        
//        try{
//            stmt = cn.prepareStatement(sql);
//                stmt.setString(1, endereco.getCodObjeto());
//                stmt.setString(2, pessoa.getCodObjeto());
//                stmt.setString(3, endereco.getNumero());
//                stmt.setString(4, endereco.getComplemento());
//            stmt.execute();
//        }finally{
//            ConnectionFactory.closeConnection(cn, stmt);
//        }
//        
//    }
}
