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
        PessoaFisica cliente = new PessoaFisica("77777777777", 1, dtNasc, "bbbbb@bbb.bb", "1111111111", "11222222222", codObjeto, "GGGGG BBBB kkkkkkkk", 10, data, false);
        
        Endereco endereco = new Endereco(cliente.getId(),"99999999", "Av de Teste EEEEEEEEEE", "5", "ap 10", "CCCCCCC", "Cidade MMMMMMM", "PP");
        
        try {
            ServicoCliente.cadastrarClientePF(cliente);
            EnderecoDAO.inserirEndereco(endereco, cliente.getId());
        } catch (Exception e) {
            System.out.println("Achou mesmo que seria assim tão fácil?");
            System.out.println("Aproveita que tá sentado e chora...hahaha");
        }
    }
    
}
