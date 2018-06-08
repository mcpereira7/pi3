/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.DAO;

import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Marcelo Pereira <macope727@gmail.com>
 * @author aayan
 */
public class FuncionarioDAO {

    private static Connection cn = null;

    public static Funcionario getUser(String user) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM funcionarios WHERE Login = ?";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, user);
            rs = stmt.executeQuery();

            rs.next();

            Funcionario logado = new Funcionario(rs);

            return logado;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static void inserirFuncionario(Funcionario us) throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO funcionarios (id_Pessoa, Codigo, Funcao, Salario, Login, senha, id_Filial, id_Grupo)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        
        try {
//            Inserir PessoaFisica antes de inserir Funcionário
            PessoaDAO.inserirPF(us);
            int aux = us.getId();
            us.setCodigo(aux + 1000);
            
            cn = ConnectionFactory.getConnection();
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, us.getId());
            stmt.setInt(2, (us.getCodigo()));
            stmt.setString(3, us.getFuncao());
            stmt.setDouble(4, us.getSalario());
            stmt.setString(5, us.getUser());
            stmt.setString(6, us.getPassword());
            stmt.setInt(7, us.getIdFilial());
            stmt.setInt(8, us.getIdGrupo());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizarFuncionario(Funcionario us) throws SQLException, Exception{
        PreparedStatement stmt = null;

        String sql = "UPDATE funcionarios set id_Pessoa = ?"
                + ", Codigo = ?"
                + ", Funcao = ?"
                + ", Salario = ?"
                + ", Login = ?"
                + ", senha = ?"
                + ", id_Filial = ?"
                + ", id_Grupo = ?"
                + "WHERE id_Pessoa = ?";
        try {
//            Atualizar PessoaFisica antes dos dados do funcionário
            PessoaDAO.atualizarPF(us);
            
            cn = ConnectionFactory.getConnection();
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, us.getId());
            stmt.setInt(2, (us.getId()+ 1000));
            stmt.setString(3, us.getFuncao());
            stmt.setDouble(4, us.getSalario());
            stmt.setString(5, us.getUser());
            stmt.setString(6, us.getPassword());
            stmt.setInt(7, us.getIdFilial());
            stmt.setInt(8, us.getIdGrupo());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void desativarFuncionario(Funcionario us) throws SQLException, Exception{
        try {
            PessoaDAO.excluir(us);
        } catch (Exception e) {
            System.out.println("Erro ao desativar Funcionario " + us.getNome());
        }

    }
}
