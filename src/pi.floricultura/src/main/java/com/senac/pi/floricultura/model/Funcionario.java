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
 * @author Marcelo Pereira <macope727@gmail.com>
 * @author aayan
 */
public class Funcionario extends PessoaFisica {

    private int idUsuario;
    private int codigo;
    private String user;
    private String password;
    private String funcao;
    private double salario;
    private int idGrupo;
    private int idFilial;
    private String nomeFilial;
    private boolean signedUp = false;

    
    //Constructors
    public Funcionario() {

    }

    public Funcionario(int idUsuario, String user, String password, String funcao, double salario, int idGrupo, int idFilial, String nomeFilial) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.funcao = funcao;
        this.salario = salario;
        this.idGrupo = idGrupo;
        this.idFilial = idFilial;
        this.nomeFilial = nomeFilial;
    }

    public Funcionario(ResultSet rs) throws SQLException {
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

    public void setPassword(String openPass) { // Estava private eu alterei para public
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
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public boolean isSignedUp() {
        return signedUp;
    }

    public void setSignedUp(boolean signedUp) {
        this.signedUp = signedUp;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
