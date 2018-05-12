package com.senac.pi.floricultura.DAO;
import com.mysql.jdbc.Statement;
import com.senac.pi.floricultura.connection.ConnectionFactory;
import com.senac.pi.floricultura.model.GrupoPermissao;
import com.senac.pi.floricultura.model.TelaPermissoes;
import com.senac.pi.floricultura.utilitarios.AuxiliaresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class grupoPermissaoDAO {
    
    public static void InserirGrupoPermissao(GrupoPermissao grupoPermissao){
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO GrupoPermissao (nome) "
                + "VALUES (?)";
        
        Connection cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, grupoPermissao.getNome());
            
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                grupoPermissao.setId_grupo(rs.getInt(1));
            }
            
        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
        public static void AtualizarGrupoPermissao(GrupoPermissao grupoPermissao){
        PreparedStatement stmt = null;

        String sql = "UPDATE grupoPermissao SET nome = ?"
                + "WHERE id_grupo = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, grupoPermissao.getNome());
            //WHERE
            stmt.setInt(2, grupoPermissao.getId_grupo());
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
        
    public static void ExcluirGrupoPermissao(Integer id_grupo){
        PreparedStatement stmt = null;

        String sql = "UPDATE grupoPermissao SET disable= ?"
                + "WHERE id_grupo = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, id_grupo);
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    //Espera-se que para inserir um grupo de telas o grupo já esteja cadastrado.
    public static void InserirGrupoPermissaoTelas(Integer id_grupo, Integer id_tela){
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO GrupoPermissaoTelas (id_grupo, id_tela) "
                + "VALUES (?, ?)";
        
        Connection cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            
            stmt.setInt(1, id_grupo);
            stmt.setInt(2, id_tela);
            
            stmt.execute();
            
        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static boolean VerificaGrupoPermissaoTelas(Integer id_grupo, Integer id_tela, boolean disable) throws Exception{
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[2];
        String sql = "";
        
        if (id_grupo != null) {
            strWhere[0] = "id_grupo = " + id_grupo;
        }else{
            throw new Exception("O Grupo deve ser informado!");
        }
        
        if (id_tela != null) {
            strWhere[1] = "id_tela = " + id_tela;
        }else{
            throw new Exception("A tela deve ser informada!");
        }
        
        sql = "SELECT * FROM grupoPermissaoTelas WHERE " + AuxiliaresDAO.ligaVetorAND(strWhere);

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()){
                disable = rs.getBoolean("disable");
                return true;
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return false;
    }
    
    public static void ExcluirGrupoPermissaoTelas(Integer id_grupo, Integer id_tela){
        PreparedStatement stmt = null;

        String sql = "UPDATE grupoPermissaoTelas SET disable= ?"
                + "WHERE id_grupo = ? and id_tela = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            //WHERE
            stmt.setInt(2, id_grupo);
            stmt.setInt(2, id_grupo);
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void ReativarGrupoPermissaoTelas(Integer id_grupo, Integer id_tela){
        PreparedStatement stmt = null;

        String sql = "UPDATE grupoPermissaoTelas SET disable= ?"
                + "WHERE id_grupo = ? and id_tela = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setBoolean(1, false);
            //WHERE
            stmt.setInt(2, id_grupo);
            stmt.setInt(2, id_grupo);
            stmt.execute();

        } catch (Exception e) {
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static GrupoPermissao GruposPermissoesByGrupo(Integer id_grupo){
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "";
        
        sql = "SELECT * FROM GrupoPermissao WHERE id_grupo = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id_grupo);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                GrupoPermissao grupoPermissao = new GrupoPermissao(
                        rs.getInt("id_grupo"),
                        rs.getString("nome"),
                        ListarPermissoesByGrupo(rs.getInt("id_grupo"))
                );
                return grupoPermissao;
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return null;
    }
    
    public static List<TelaPermissoes> ListarPermissoesByGrupo(Integer id_grupo){
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String[] strWhere = new String[2];
        String sql = "";
        List<TelaPermissoes> listaPermissoes = new ArrayList<>();

        sql = "SELECT * FROM GrupoPermissaoTelas INNER JOIN Telas ON GrupoPermissaoTelas.id_tela = Telas.id_tela "
                + "WHERE id_grupo = ?";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id_grupo);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                TelaPermissoes Permissao = new TelaPermissoes(
                        rs.getInt("id_tela"), 
                        rs.getString("nome"), 
                        rs.getString("caminho"), 
                        false);
                listaPermissoes.add(Permissao);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaPermissoes;
    }
    
    public static List<GrupoPermissao> ListarGruposPermissoes(){
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "";
        List<GrupoPermissao> listaGrupoPermissao = new ArrayList<>();

        sql = "SELECT * FROM GrupoPermissao";

        Connection cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                GrupoPermissao grupoPermissao = new GrupoPermissao(
                        rs.getInt("id_grupo"),
                        rs.getString("nome"),
                        ListarPermissoesByGrupo(rs.getInt("id_grupo"))
                );
                listaGrupoPermissao.add(grupoPermissao);
            }

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listaGrupoPermissao;
    }
}
