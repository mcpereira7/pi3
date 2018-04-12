
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
        
        String sqlPessoa = "INSERT INTO Pessoa (Nome, Apelido, TipoPessoa, id_Endereco, dt_Cadastro)"
                + "VALUES(?,?,?,?,?)";
        String sqlPessoaFisica = "INSERT INTO PessoaFisica (id_pessoa, CPF, dt_Nasc, Sexo)";
        
        try {
            
            stmt = cn.prepareStatement(sqlPessoa);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getApelido());
                stmt.setInt(3, cliente.getTipo());

            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
    
}
