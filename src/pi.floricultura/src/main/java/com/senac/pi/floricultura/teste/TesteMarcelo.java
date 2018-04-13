/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rerum
 */
public class TesteMarcelo {
    public static void main(String[] args) throws ParseException {
        
        String codObjeto = new GerarCodigo().setCodigoCli();
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-d" );
        Date data = formato.parse("2018-04-13");
        Date dtNasc = formato.parse("2000-04-15");
        PessoaFisica cliente = new PessoaFisica("55555555555", 2, dtNasc, codObjeto, "Teste Cincho", 0, data);
        
        Endereco endereco = new Endereco(cliente.getCodObjeto(),"88888888", "Rua de Teste Quathro", "5", "ap 10", "Parara", "Cidade PIriri", "CC");
        
        try {
           ServicoCliente.cadastrarClientePF(cliente);
            EnderecoDAO.inserirEndereco(endereco);
        } catch (Exception e) {
            System.out.println("Achou mesmo que seria assim tão fácil?");
            System.out.println("Aproveita que tá sentado e chora...hahaha");
        }
    }
    
}
