package com.senac.pi.floricultura.model;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class Cliente {
    
    private PessoaFisica cliPf;
    private PessoaJuridica cliPj;
    private Endereco endereco;

    public Cliente(PessoaFisica cliPf, Endereco endereco) {
        this.cliPf = cliPf;
        this.endereco = endereco;
    }

    public Cliente(PessoaJuridica cliPj, Endereco endereco) {
        this.cliPj = cliPj;
        this.endereco = endereco;
    }

    public PessoaFisica getCliPf() {
        return cliPf;
    }

    public void setCliPf(PessoaFisica cliPf) {
        this.cliPf = cliPf;
    }

    public PessoaJuridica getCliPj() {
        return cliPj;
    }

    public void setCliPj(PessoaJuridica cliPj) {
        this.cliPj = cliPj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
