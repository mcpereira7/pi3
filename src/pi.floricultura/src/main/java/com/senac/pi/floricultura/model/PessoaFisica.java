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
public class PessoaFisica extends Pessoa{
    
    private String cpf;
    private String rg;
    private int sexo;
    private Date dtNasc;

    public PessoaFisica(String cpf, int sexo, Date dtNasc, String codObjeto, String nome, int tipo, Date data) {
        super(codObjeto, nome, tipo, data);
        this.cpf = cpf;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
    }

      

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }
        
        
}
