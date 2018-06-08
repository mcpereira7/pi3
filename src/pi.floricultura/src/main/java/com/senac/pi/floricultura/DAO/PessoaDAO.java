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
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private static Connection cn = null;

    public static void InserirPessoa(Pessoa pessoa, Connection cn) {
        PreparedStatement stmtPessoa = null;

        String sqlPessoa = "INSERT INTO Pessoa (id_Pessoa,cod_Objeto, Nome, Apelido, TipoPessoa, dt_Cadastro, Disable) VALUES(?,?,?,?,?,?,?);";

        try {

            stmtPessoa = cn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setInt(1, pessoa.getId());
            stmtPessoa.setString(2, pessoa.getCodObjeto());
            stmtPessoa.setString(3, pessoa.getNome());
            stmtPessoa.setString(4, pessoa.getApelido());
            stmtPessoa.setInt(5, pessoa.getTipo());
            stmtPessoa.setDate(6, new Date(pessoa.getData().getTime()));
            stmtPessoa.setBoolean(7, pessoa.isDisable());
            stmtPessoa.execute();

            ResultSet rs = stmtPessoa.getGeneratedKeys();
            int i = 0;
            if (rs.next()) {
                i = rs.getInt(1);
                System.out.println(i);
                pessoa.setId(i);
                System.out.println(pessoa.getId());
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoa);
        }
    }

    public static void inserirPF(PessoaFisica pf) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "INSERT INTO PessoaFisica (id_pessoa, CPF, dt_Nasc"
                + ", Sexo, email, telefone, telefone2) VALUES (?,?,?,?,?,?,?)";
        
            cn = ConnectionFactory.getConnection();
       
        try {
            InserirPessoa(pf, cn);

            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaFisica = cn.prepareStatement(sqlPessoaFisica);
            stmtPessoaFisica.setInt(1, pf.getId());
            stmtPessoaFisica.setString(2, pf.getCpf());
            stmtPessoaFisica.setDate(3, new Date(pf.getDtNasc().getTime()));
            stmtPessoaFisica.setInt(4, pf.getSexo());
            stmtPessoaFisica.setString(5, pf.getEmail());
            stmtPessoaFisica.setString(6, pf.getTelefone());
            stmtPessoaFisica.setString(7, pf.getTelefone2());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }

    public static void inserirPJ(PessoaJuridica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaJuridica = null;

        String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (id_pessoa, CNPJ, IE, ehCliente, "
                + "ehEmpresa,  Responsavel, Email, Telefone, Telefone2)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";

        cn = ConnectionFactory.getConnection();

        try {
            InserirPessoa(pessoa, cn);

            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaJuridica = cn.prepareStatement(sqlPessoaJuridica);
            stmtPessoaJuridica.setInt(1, pessoa.getId());
            stmtPessoaJuridica.setString(2, pessoa.getCnpj());
            stmtPessoaJuridica.setString(3, pessoa.getInscEs());
            stmtPessoaJuridica.setBoolean(4, pessoa.isEhCliente());
            stmtPessoaJuridica.setBoolean(5, pessoa.isEhEmpresa());
            stmtPessoaJuridica.setString(6, pessoa.getResponsavel());
            stmtPessoaJuridica.setString(7, pessoa.getEmail());
            stmtPessoaJuridica.setString(8, pessoa.getTelefone());
            stmtPessoaJuridica.setString(9, pessoa.getTelefone2());
            stmtPessoaJuridica.execute();
        } catch (SQLException e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaJuridica);
        }
    }

    public static void atualizarPessoa(Pessoa pessoa, Connection cn) throws SQLException, Exception {
        PreparedStatement stmtPessoa = null;

        String sqlPessoa = "UPDATE Pessoa SET cod_objeto = ?, Nome = ?, Apelido = ?"
                + ", TipoPessoa = ?, dt_Cadastro = ?, id_pessoa = ? WHERE id_pessoa = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmtPessoa = cn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, pessoa.getCodObjeto());
            stmtPessoa.setString(2, pessoa.getNome());
            stmtPessoa.setString(3, pessoa.getApelido());
            stmtPessoa.setInt(4, pessoa.getTipo());
            stmtPessoa.setDate(5, new Date(pessoa.getData().getTime()));
            stmtPessoa.setInt(6, pessoa.getId());
            stmtPessoa.setInt(7, pessoa.getId());
            stmtPessoa.execute();

            ResultSet rs = stmtPessoa.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoa);
        }
    }

    public static void atualizarPF(PessoaFisica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaFisica = null;

        String sqlPessoaFisica = "UPDATE PessoaFisica SET id_pessoa = ?, CPF = ?, dt_Nasc = ?, Sexo = ?"
                + ", email = ?, telefone = ?, telefone2 = ? "
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
            stmtPessoaFisica.setString(5, pessoa.getEmail());
            stmtPessoaFisica.setString(6, pessoa.getTelefone());
            stmtPessoaFisica.setString(7, pessoa.getTelefone2());
            stmtPessoaFisica.setInt(8, pessoa.getId());
            stmtPessoaFisica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaFisica);
        }
    }

    public static void atualizarPJ(PessoaJuridica pessoa) throws SQLException, Exception {
        PreparedStatement stmtPessoaJuridica = null;

        String sqlPessoaJuridica = "UPDATE PessoaJudirica SET id_pessoa=?, CNPJ=?, IE=?, ehCliente=?, "
                + "ehEmpresa=?, Responsavel=?, Email=?, Telefone=?, Telefone2=?"
                + " WHERE id_pessoa=?;";

        cn = ConnectionFactory.getConnection();

        try {
            atualizarPessoa(pessoa, cn);

            // Insere os outros atributos de ClientePessoaFisica na tabela PessoaFisica
            stmtPessoaJuridica = cn.prepareStatement(sqlPessoaJuridica);
            stmtPessoaJuridica.setInt(1, pessoa.getId());
            stmtPessoaJuridica.setString(2, pessoa.getCnpj());
            stmtPessoaJuridica.setString(3, pessoa.getInscEs());
            stmtPessoaJuridica.setBoolean(4, pessoa.isEhCliente());
            stmtPessoaJuridica.setBoolean(5, pessoa.isEhEmpresa());
            stmtPessoaJuridica.setBoolean(6, pessoa.isDisable());
            stmtPessoaJuridica.setString(7, pessoa.getResponsavel());
            stmtPessoaJuridica.setString(8, pessoa.getEmail());
            stmtPessoaJuridica.setString(9, pessoa.getTelefone());
            stmtPessoaJuridica.setString(10, pessoa.getTelefone2());
            stmtPessoaJuridica.execute();
        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(null, stmtPessoaJuridica);
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

    public static void excluirById(int id) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "UPDATE Pessoa SET disable=? WHERE (id_pessoa =?) ";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static PessoaFisica buscarPF(int cod) throws SQLException, Exception {
        PessoaFisica pf = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT p.id_Pessoa, p.cod_objeto, p.Nome, p.Apelido, p.TipoPessoa, p.dt_Cadastro\n"
                + "	   ,pf.CPF, pf.dt_Nasc, pf.sexo, pf.email, pf.telefone, pf.telefone2\n"
                + "       ,e.CEP, e.log, e.numero, e.complemento, e.bairro, e.cidade, e.uf\n"
                + "FROM pessoa p \n"
                + "JOIN pessoafisica pf ON p.id_Pessoa=pf.id_Pessoa\n"
                + "JOIN endereco e on e.id_Pessoa=p.id_Pessoa "
                + "WHERE p.id_pessoa=? AND p.disable=false";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();

            while (rs.next()) {
                pf = new PessoaFisica();

                pf.setId(rs.getInt("id_Pessoa"));
                pf.setCodObjeto(rs.getString("cod_objeto"));
                pf.setNome(rs.getString("Nome"));
                pf.setApelido(rs.getString("Apelido"));
                pf.setTipo(rs.getInt("TipoPessoa"));
                pf.setData(rs.getDate("dt_cadastro"));
                pf.setCpf(rs.getString("CPF"));
                pf.setDtNasc(rs.getDate("dt_Nasc"));
                pf.setSexo(rs.getInt("sexo"));
                pf.setEmail(rs.getString("email"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setTelefone2(rs.getString("telefone2"));

            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return pf;
    }

//    efetuar busca por CPF
    public static List<PessoaFisica> buscarPFbyCPF(String cpf) throws SQLException, Exception {
        List<PessoaFisica> pfl = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = null;

        sql = "SELECT p.id_Pessoa, p.cod_objeto, p.Nome, p.Apelido, p.TipoPessoa, p.dt_Cadastro\n"
                + "	   ,pf.CPF, pf.dt_Nasc, pf.sexo, pf.email, pf.telefone, pf.telefone2\n"
                + "       ,e.CEP, e.log, e.numero, e.complemento, e.bairro, e.cidade, e.uf\n"
                + "FROM pessoa p \n"
                + "JOIN pessoafisica pf ON p.id_Pessoa=pf.id_Pessoa\n"
                + "JOIN endereco e on e.id_Pessoa=p.id_Pessoa "
                + "WHERE pf.CPF=?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();

                pf.setId(rs.getInt("id_Pessoa"));
                pf.setCodObjeto(rs.getString("cod_objeto"));
                pf.setNome(rs.getString("Nome"));
                pf.setApelido(rs.getString("Apelido"));
                pf.setTipo(rs.getInt("TipoPessoa"));
                pf.setData(rs.getDate("dt_cadastro"));
                pf.setCpf(rs.getString("CPF"));
                pf.setDtNasc(rs.getDate("dt_Nasc"));
                pf.setSexo(rs.getInt("sexo"));
                pf.setEmail(rs.getString("email"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setTelefone2(rs.getString("telefone2"));
                pfl.add(pf);
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return pfl;
    }

    public static List<PessoaFisica> listarClientesPF() throws SQLException, Exception {
        List<PessoaFisica> listaClientesPF = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT p.id_Pessoa, p.cod_objeto, p.Nome, p.Apelido, p.TipoPessoa, p.dt_Cadastro\n"
                + "	   ,pf.CPF, pf.dt_Nasc, pf.sexo, pf.email, pf.telefone, pf.telefone2\n"
                + "       ,e.CEP, e.log, e.numero, e.complemento, e.bairro, e.cidade, e.uf\n"
                + "FROM pessoa p \n"
                + "JOIN pessoafisica pf ON p.id_Pessoa=pf.id_Pessoa\n"
                + "JOIN endereco e on e.id_Pessoa=p.id_Pessoa"
                + " WHERE p.Disable = false";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();

                pf.setId(rs.getInt("id_Pessoa"));
                pf.setCodObjeto(rs.getString("cod_objeto"));
                pf.setNome(rs.getString("Nome"));
                pf.setApelido(rs.getString("Apelido"));
                pf.setTipo(rs.getInt("TipoPessoa"));
                pf.setData(rs.getDate("dt_cadastro"));
                pf.setCpf(rs.getString("CPF"));
                pf.setDtNasc(rs.getDate("dt_Nasc"));
                pf.setSexo(rs.getInt("sexo"));
                pf.setEmail(rs.getString("email"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setTelefone2(rs.getString("telefone2"));

                listaClientesPF.add(pf);
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaClientesPF;
    }

}
