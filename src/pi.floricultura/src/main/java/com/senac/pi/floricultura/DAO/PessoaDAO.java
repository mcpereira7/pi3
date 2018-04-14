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

public class PessoaDAO {

    private static Connection cn = null;
    
        public static void InserirPessoa (Pessoa pessoa, Connection cn){
        PreparedStatement stmtPessoa = null;
        
        String sqlPessoa = "INSERT INTO Pessoa (cod_objeto, Nome, Apelido, TipoPessoa, dt_Cadastro, Disable) VALUES(?,?,?,?,?,?)";
        
        try {
            
            stmtPessoa = cn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, pessoa.getCodObjeto());
            stmtPessoa.setString(2, pessoa.getNome());
            stmtPessoa.setString(3, pessoa.getApelido());
            stmtPessoa.setInt(4, pessoa.getTipo());
            stmtPessoa.setDate(5, new Date(pessoa.getData().getTime()));
            stmtPessoa.setBoolean(6, pessoa.isDisable());
            stmtPessoa.execute();
            
            ResultSet rs = stmtPessoa.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
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
    
    public static void inserirPJ(PessoaJuridica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "UPDATE PessoaJudirica SET id_pessoa=?, CNPJ=?, IE=?, ehCliente=?, "
                + "ehEmpresa=?, Responsavel=?, Email=?, Telefone=?, Telefone2=?"
                + " WHERE id_pessoa=?";

        cn = ConnectionFactory.getConnection();

        try {
            InserirPessoa(pessoa, cn);
            
            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, pessoa.getId());
            stmtPessoaFisica.setString(2, pessoa.getCnpj());
            stmtPessoaFisica.setString(3, pessoa.getInscEs());
            stmtPessoaFisica.setBoolean(4, pessoa.isEhCliente());
            stmtPessoaFisica.setBoolean(5, pessoa.isEhEmpresa());
            stmtPessoaFisica.setString(6, pessoa.getResponsavel());
            stmtPessoaFisica.setString(7, pessoa.getEmail());
            stmtPessoaFisica.setString(8, pessoa.getTelefone());
            stmtPessoaFisica.setString(9, pessoa.getTelefone2());
            stmtPessoaFisica.setInt(10, pessoa.getId());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }
    
    public static void atualizarPessoa(Pessoa pessoa, Connection cn) throws SQLException, Exception{
        PreparedStatement stmtPessoa = null;

        String sqlPessoa = "UPDATE Pessoa SET cod_objeto = ?, Nome = ?, Apelido = ?"
                + ", TipoPessoa = ?, dt_Cadastro = ? WHERE is_pessoa = ?";

        cn = ConnectionFactory.getConnection();
        
        try {
            stmtPessoa = cn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, pessoa.getCodObjeto());
            stmtPessoa.setString(2, pessoa.getNome());
            stmtPessoa.setString(3, pessoa.getApelido());
            stmtPessoa.setInt(4, pessoa.getTipo());
            stmtPessoa.setDate(5, new Date(pessoa.getData().getTime()));
            stmtPessoa.setInt(6, pessoa.getId());
            stmtPessoa.execute();
            
            ResultSet rs = stmtPessoa.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }
            
            
        } catch (Exception e) {
        } finally{
            ConnectionFactory.closeConnection(null, stmtPessoa);
        }
    }

    public static void atualizarPF(PessoaFisica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "UPDATE PessoaFisica SET id_pessoa = ?, CPF = ?, dt_Nasc = ?, Sexo = ?"
                + "WHERE id_pessoa = ?";

        cn = ConnectionFactory.getConnection();

        try {
            atualizarPessoa(pessoa, cn);
            
            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, pessoa.getId());
            stmtPessoaFisica.setString(2, pessoa.getCpf());
            stmtPessoaFisica.setDate(3, new Date(pessoa.getDtNasc().getTime()));
            stmtPessoaFisica.setInt(4, pessoa.getSexo());
            stmtPessoaFisica.setInt(5, pessoa.getId());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }
    
    public static void atualizarPJ(PessoaJuridica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "INSERT INTO PessoaJudirica (id_pessoa, CNPJ, IE, ehCliente, "
                + "ehEmpresa, Disable, Responsavel, Email, Telefone, Telefone2)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            atualizarPessoa(pessoa, cn);
            
            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, pessoa.getId());
            stmtPessoaFisica.setString(2, pessoa.getCnpj());
            stmtPessoaFisica.setString(3, pessoa.getInscEs());
            stmtPessoaFisica.setBoolean(4, pessoa.isEhCliente());
            stmtPessoaFisica.setBoolean(5, pessoa.isEhEmpresa());
            stmtPessoaFisica.setBoolean(6, pessoa.isDisable());
            stmtPessoaFisica.setString(7, pessoa.getResponsavel());
            stmtPessoaFisica.setString(8, pessoa.getEmail());
            stmtPessoaFisica.setString(9, pessoa.getTelefone());
            stmtPessoaFisica.setString(10, pessoa.getTelefone2());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }
    
    public static void excluir(Pessoa pessoa) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "UPDATE Pessoa SET disable=? WHERE (id_pessoa =?) ";
        
        cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, pessoa.getId());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

}
