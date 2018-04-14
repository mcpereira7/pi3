/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.util.Date;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class Pessoa {
    
    private int id;
    String codObjeto;
    private String nome;
    private String apelido;
    private int tipo;
    private Date data;
    private boolean disable;

    public Pessoa(String codObjeto, String nome, int tipo, Date data, boolean disable) {
        this.codObjeto = codObjeto;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.disable = disable;
    }

    public Pessoa(String codOjeto, String nome, String apelido, int tipo, Date data, boolean disable) {
        this.codObjeto = codOjeto;
        this.nome = nome;
        this.apelido = apelido;
        this.tipo = tipo;
        this.data = data;
        this.disable = disable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodObjeto() {
        return codObjeto;
    }

    public void setCodObjeto(String codOjeto) {
        this.codObjeto = codOjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    
}
