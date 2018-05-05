/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.Cliente;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.model.PessoaJuridica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rerum
 */
public class TesteMarcelo {
    public static void main(String[] args) throws ParseException {
        
        String codObjeto = new GerarCodigo().setCodigoCli();
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-d" );
//        Date data = formato.parse(new Date(System.currentTimeMillis()));
        Date data = new Date(System.currentTimeMillis());
        String date = formato.format(data);
        Date dtCad = formato.parse(date);
        Date dtNasc = formato.parse("2000-04-15");
        PessoaFisica cliente = new PessoaFisica("88888888888", 1, dtNasc, "qqqqqq@kkk.rs", "1111111111", "11222222222", codObjeto, "Nenhum Alguém de Seilá", 10, dtCad, false);
        PessoaJuridica clientePJ = new PessoaJuridica("11555666999273", "111111111111", true, false, "Responsável", "resp@aaaa.com", "1122223333", "1122224444", codObjeto, "Empresa BBBBB", "BBBBB Empresa", 2, data, false);
        Endereco endereco = new Endereco(cliente.getId(),"99999999", "Av de Teste EEEEEEEEEE", "5", "ap 10", "CCCCCCC", "Cidade MMMMMMM", "PP");
        Endereco enderecopj = new Endereco(clientePJ.getId(),"04718000", "Rua Capitão Otávio Machado", "492", "", "Chac Sto Antonio", "Cidade São Paulo", "SP");
        Cliente cliPf = new Cliente(cliente, endereco);
        try {
            ServicoCliente.cadastrarClientePF(cliPf.getCliPf());
            EnderecoDAO.inserirEndereco(cliPf.getEndereco(), cliente.getId());
            
        } catch (Exception e) {
            System.out.println("Achou mesmo que seria assim tão fácil?");
            System.out.println("Aproveita que tá sentado e chora...hahaha");
        }
        
//        try {
//            ServicoCliente.cadastrarClientePJ(clientePJ);
//            EnderecoDAO.inserirEndereco(enderecopj, clientePJ.getId());
//        } catch (Exception e) {
//            System.out.println("erro pj");
//        }

        List<PessoaFisica> lista = ServicoCliente.listarClientes();
        
         for (PessoaFisica pf : lista) {
             System.out.println(pf.getNome());
             
         }
//        for (int i = 0; i< lista.size(); i++) {
//            System.out.println(lista.get(i).getNome() + " | " + lista.get(i).getEmail() + " | " + lista.get(i).getTelefone());
//        }
       
    }
    
}
