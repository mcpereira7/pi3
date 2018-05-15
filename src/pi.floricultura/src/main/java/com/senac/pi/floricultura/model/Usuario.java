/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author aayan
 */
public class Usuario extends Pessoa {

    private int idUsuario;
    private String user;
    private String password;
    private int idGrupo;
    private int idFilial;
    private boolean signedUp = false;

    
    //Constructors
    public Usuario() {

    }

    public Usuario(int idUsuario, String user, String openPass, int idGrupo, int idFilial) {
        this.idUsuario = idUsuario;
        this.user = user;
        setPassword(openPass);
        this.idGrupo = idGrupo;
        this.idFilial = idFilial; 
    }

    public Usuario(ResultSet rs) throws SQLException {
        this.idUsuario = rs.getInt("id_Usuario");
        this.user = rs.getString("Login");
        this.password = rs.getString("Senha");
        this.idGrupo = rs.getInt("id_Grupo");
        this.idFilial = rs.getInt("id_Filial");
    }

    //Getters & Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String openPass) {
        this.password = BCrypt.hashpw(openPass, BCrypt.gensalt());
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public boolean getSignedUp() {
        return signedUp;
    }

    public void setLoged() {
        this.signedUp = true;
    }
    
    //Functions

    //Verificar senha
    public boolean checkPassword(String openPass) {
        if (password != null) {
            return BCrypt.checkpw(password, openPass);
        }
        return false;
    }

}
