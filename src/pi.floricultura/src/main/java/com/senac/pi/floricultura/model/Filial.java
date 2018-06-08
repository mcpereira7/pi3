/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.util.Date;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class Filial extends PessoaJuridica{
    private String codigoFilial;
    private int id;

    public Filial() {
        this.codigoFilial = codigoFilial;
    }

    public Filial(String codigoFilial, String cnpj, String inscEs, boolean ehCliente, boolean ehEmpresa, String responsavel, String email, String telefone, String telefone2, String codOjeto, String nome, String apelido, int tipo, Date data, boolean disable) {
        super(cnpj, inscEs, ehCliente, ehEmpresa, responsavel, email, telefone, telefone2, codOjeto, nome, apelido, tipo, data, disable);
        this.codigoFilial = codigoFilial;
    }

    public String getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(String codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = super.getId();
    }
    
    
    
    @Override
    public String getCodObjeto() {
        return codObjeto;
    }

    @Override
    public void setCodObjeto(String codObjeto) {
        this.codObjeto = codObjeto;
    }
    
    
}
