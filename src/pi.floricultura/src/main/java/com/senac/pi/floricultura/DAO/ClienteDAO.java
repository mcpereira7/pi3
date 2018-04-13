
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO {
    
    private static Connection cn = null;

    public static void inserirPF(PessoaFisica cliente) throws SQLException, Exception {
        PreparedStatement stmt = null;
        
        String sqlPessoa = "INSERT INTO Pessoa (cod_objeto, Nome, Apelido, TipoPessoa, dt_Cadastro) VALUES(?,?,?,?,?)";
        
        String sqlPessoaFisica = "INSERT INTO PessoaFisica (cod_objeto, CPF, dt_Nasc, Sexo) VALUES (?,?,?,?)";
        
        cn = ConnectionFactory.getConnection();
        
        try {
            
                stmt = cn.prepareStatement(sqlPessoa);
                    stmt.setString(1, cliente.getCodObjeto());
                    stmt.setString(2, cliente.getNome());
                    stmt.setString(3, cliente.getApelido());
                    stmt.setInt(4, cliente.getTipo());
                    stmt.setDate(5, new Date(cliente.getData().getTime()));
               stmt.execute();
                
//        } finally {
//            ConnectionFactory.closeConnection(cn, stmt);
//        }
        // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
        
//        try{
                    cn = ConnectionFactory.getConnection();
                    stmt = cn.prepareStatement(sqlPessoaFisica);
                        stmt.setString(1, cliente.getCodObjeto());
                        stmt.setString(2, cliente.getCpf());
                        stmt.setDate(3, new Date (cliente.getDtNasc().getTime()));
                        stmt.setInt(4, cliente.getSexo());
                    stmt.execute();
        }finally{
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
    
}
