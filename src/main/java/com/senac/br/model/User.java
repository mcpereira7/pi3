/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.br.model;

/**
 *
 * @author leandro.asantos17
 */
public class User {

    private int idUser;
    private String nome;
    private String login;
    private String email;
    private String senha;

    //Constructors
    public User(int idUser, String nome, String login, String email, String senha) {
        this.idUser = idUser;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    public User(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    //Getters & Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
