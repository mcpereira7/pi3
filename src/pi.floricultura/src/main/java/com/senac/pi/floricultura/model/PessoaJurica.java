package com.senac.pi.floricultura.model;

import java.util.Date;

public class PessoaJurica extends Pessoa{
    
    private String cnpj;
    private String inscEs;
    private boolean ehCliente;
    private boolean ehEmpresa;
    private boolean disable;

    public PessoaJurica(String cnpj, boolean ehCliente, boolean ehEmpresa, boolean disable, String nome, String apelido, int tipo, int idEndereco, Date data) {
        super(nome, apelido, tipo, idEndereco, data);
        this.cnpj = cnpj;
        this.ehCliente = ehCliente;
        this.ehEmpresa = ehEmpresa;
        this.disable = disable;
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

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    
}
