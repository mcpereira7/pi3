/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

/**
 *
 * @author Rerum
 */
public class Contato {
    
    private String codObjeto;
    private int tipo;
    private String valor;

    public Contato(String codObjeto, int tipo, String valor) {
        this.codObjeto = codObjeto;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getCodObjeto() {
        return codObjeto;
    }

    public void setCodObjeto(String codObjeto) {
        this.codObjeto = codObjeto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
