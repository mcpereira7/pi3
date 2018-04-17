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
    private String email;
    private String telefone;
    private String telefone2;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, int sexo, Date dtNasc, String email, String telefone, String telefone2, String codObjeto, String nome, int tipo, Date data, boolean disable) {
        super(codObjeto, nome, tipo, data, disable);
        this.cpf = cpf;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
        this.email = email;
        this.telefone = telefone;
        this.telefone2 = telefone2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
        
        
}
