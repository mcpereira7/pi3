package com.senac.pi.floricultura.DAO;

import com.mysql.jdbc.Statement;
import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Pessoa;
import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.model.PessoaJuridica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private static Connection cn = null;
    
        public static void InserirPessoa (Pessoa cliente, Connection cn){
        PreparedStatement stmtPessoa = null;
        
        String sqlPessoa = "INSERT INTO Pessoa (cod_objeto, Nome, Apelido, TipoPessoa, dt_Cadastro) VALUES(?,?,?,?,?)";
        
        try {
            
            stmtPessoa = cn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, cliente.getCodObjeto());
            stmtPessoa.setString(2, cliente.getNome());
            stmtPessoa.setString(3, cliente.getApelido());
            stmtPessoa.setInt(4, cliente.getTipo());
            stmtPessoa.setDate(5, new Date(cliente.getData().getTime()));
            stmtPessoa.execute();
            
            ResultSet rs = stmtPessoa.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            }
            
        } catch (Exception e) {
            
        }finally{
            ConnectionFactory.closeConnection(null, stmtPessoa);
        }
    }

    public static void inserirPF(PessoaFisica cliente) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "INSERT INTO PessoaFisica (id_pessoa, CPF, dt_Nasc, Sexo) VALUES (?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            InserirPessoa(cliente, cn);
            
            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, cliente.getId());
            stmtPessoaFisica.setString(2, cliente.getCpf());
            stmtPessoaFisica.setDate(3, new Date(cliente.getDtNasc().getTime()));
            stmtPessoaFisica.setInt(4, cliente.getSexo());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }
    
    public static void inserirPJ(PessoaJuridica cliente) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "INSERT INTO PessoaJudirica (id_pessoa, CNPJ, IE, ehCliente, "
                + "ehEmpresa, Disable, Responsavel, Email, Telefone, Telefone2)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            InserirPessoa(cliente, cn);
            
            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, cliente.getId());
            stmtPessoaFisica.setString(2, cliente.getCnpj());
            stmtPessoaFisica.setString(3, cliente.getInscEs());
            stmtPessoaFisica.setBoolean(4, cliente.isEhCliente());
            stmtPessoaFisica.setBoolean(5, cliente.isEhEmpresa());
            stmtPessoaFisica.setBoolean(6, cliente.isDisable());
            stmtPessoaFisica.setString(7, cliente.getResponsavel());
            stmtPessoaFisica.setString(8, cliente.getEmail());
            stmtPessoaFisica.setString(9, cliente.getTelefone());
            stmtPessoaFisica.setString(10, cliente.getTelefone2());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }
    


}
