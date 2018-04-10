/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

      public PessoaFisica(String cpf, int sexo, Date dtNasc, String nome, int tipo, int idEndereco, Date data) {
        super(nome, tipo, idEndereco, data);
        this.cpf = cpf;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
    }
        
        
}
