package com.senac.pi.floricultura.DAO;
import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.Tela;
import com.senac.pi.floricultura.utilitarios.AuxiliaresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelaDAO {
    public static void InserirTela(Tela tela){
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO Telas (nome, caminho) "
                + "VALUES (?, ?)";
        
        Connection cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            
            stmt.setString(1, tela.getNome());
            stmt.setString(2, tela.getCaminho());
            
            stmt.execute();
            
        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void AtualizarTela(Tela tela){
        PreparedStatement stmt = null;

        String sql = "UPDATE Telas SET nome = ?, caminho = ?"
                + "WHERE id_tela = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, tela.getNome());
            stmt.setString(2, tela.getCaminho());
            //WHERE
            stmt.setInt(3, tela.getId());
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void ExcluirTela(int id_tela){
        PreparedStatement stmt = null;

        String sql = "UPDATE Telas SET disable= ?"
                + "WHERE id_tela = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, id_tela);
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static List<Tela> ListarTelas(Integer id_tela, String nome, String caminho){
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[3];
        String sql = "";
        List<Tela> listaTelas = new ArrayList<>();
        
        if (id_tela != null) {
            strWhere[0] = "id_tela = " + id_tela;
        }
        if (nome != null) {
            strWhere[1] = "nome = " + nome;
        }
        
        if (caminho != null) {
            strWhere[2] = "caminho = " + caminho;
        }
        
        if (id_tela != null || nome != null || caminho != null){
            sql = "SELECT * FROM Telas WHERE " + AuxiliaresDAO.ligaVetorAND(strWhere);
        }else{
            sql = "SELECT * FROM Telas";
        }

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tela tela = new Tela(
                        rs.getInt("id_tela"),
                        rs.getString("nome"),
                        rs.getString("caminho"));
                listaTelas.add(tela);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaTelas;
    }
    
    public static List<Tela> ListarTelasByGrupoPermissao(Integer id_grupo) throws Exception{
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[3];
        String sql = "";
        List<Tela> listaTelas = new ArrayList<>();
        
        if (id_grupo != null) {
            strWhere[0] = "id_grupo = " + id_grupo;
        }else{
            throw new Exception("O Grupo deve ser informado!");
        }
        
        sql = "SELECT * FROM Telas INNER JOIN GrupoPermissaoTelas ON Telas.id_tela = GrupoPermissaoTelas.id_tela "
                + "WHERE " + AuxiliaresDAO.ligaVetorAND(strWhere);

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tela tela = new Tela(
                        rs.getInt("id_tela"),
                        rs.getString("nome"),
                        rs.getString("caminho"));
                listaTelas.add(tela);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaTelas;
    }
    
}
