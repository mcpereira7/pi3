package com.senac.pi.floricultura.model;

import java.util.Date;

public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private String inscEs;
    private boolean ehCliente;
    private boolean ehEmpresa;
    private String responsavel;
    private String email;
    private String telefone;
    private String telefone2;
    
     public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String inscEs, boolean ehCliente, boolean ehEmpresa, String responsavel, String email, String telefone, String telefone2, String codOjeto, String nome, String apelido, int tipo, Date data, boolean disable) {
        super(codOjeto, nome, apelido, tipo, data, disable);
        this.cnpj = cnpj;
        this.inscEs = inscEs;
        this.ehCliente = ehCliente;
        this.ehEmpresa = ehEmpresa;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.telefone2 = telefone2;
    }

   

   
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEs() {
        return inscEs;
    }

    public void setInscEs(String inscEs) {
        this.inscEs = inscEs;
    }

    public boolean isEhCliente() {
        return ehCliente;
    }

    public void setEhCliente(boolean ehCliente) {
        this.ehCliente = ehCliente;
    }

    public boolean isEhEmpresa() {
        return ehEmpresa;
    }

    public void setEhEmpresa(boolean ehEmpresa) {
        this.ehEmpresa = ehEmpresa;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
