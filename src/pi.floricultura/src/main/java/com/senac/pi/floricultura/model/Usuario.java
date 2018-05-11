/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class Usuario extends Pessoa {

    private int idUsuario;
    private String user;
    private String password;
    private int idGrupo;

    public Usuario() {

    }

    public Usuario(int idUsuario, String user, String password, int idGrupo) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.idGrupo = idGrupo;
    }
    
    public Usuario(ResultSet rs) throws SQLException {
        this.idUsuario = rs.getInt("id_Usuario");
        this.user = rs.getString("Login");
        this.password = rs.getString("Senha");
        this.idGrupo = rs.getInt("id_Grupo");
    }

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

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

}
