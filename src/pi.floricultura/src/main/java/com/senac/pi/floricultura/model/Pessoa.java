/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<Contato> contatos;


    public Pessoa(String codObjeto, String nome, int tipo, Date data) {
        this.contatos = new ArrayList<Contato>();
        this.codObjeto = codObjeto;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
    }

    public Pessoa(String codOjeto, String nome, String apelido, int tipo, Date data) {
        this.contatos = new ArrayList<Contato>();
        this.codObjeto = codOjeto;
        this.nome = nome;
        this.apelido = apelido;
        this.tipo = tipo;
        this.data = data;
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
    
    
    
}
