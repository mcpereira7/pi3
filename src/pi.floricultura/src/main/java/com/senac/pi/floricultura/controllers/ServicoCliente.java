/*
 * Alexandre Vinicius Ferreida da Silva & Leandro Alves
 * @author alexandre.vfsilva
 * Turma A
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.DAO.PessoaDAO;
import com.senac.pi.floricultura.model.PessoaJuridica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexandre.vfsilva
 */
//Serviço de Clientes
public class ServicoCliente {

    public static void cadastrarClientePF(PessoaFisica cliente) throws SQLException, Exception {
        try {
            PessoaDAO.inserirPF(cliente);
            
        } catch (SQLException e) {
            //mostra no console qualquer erro que ocorra no 'MOCK'
            System.err.println("Erro na fonte de dados");
        }
    }

    public static void atualizaClientePF(PessoaFisica cliente) {
        
        try {
            PessoaDAO.atualizarPF(cliente);
            
        } catch (Exception e) {
        }
      
    }

    public static PessoaFisica procuraClientePF(Integer cod){
           try {
            return PessoaDAO.buscarPF(cod);
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public static List<PessoaFisica> listarClientes(){
           try {
            return PessoaDAO.listarClientesPF();
        } catch (Exception e) {
        }
        return null;
    }

    public static PessoaFisica obterClientePF(Integer id) {
       
        return null;
    }


    public static void excluiCliente(Integer id) {
        
    }
    
    public static boolean validaCodCliente(Integer codCliente) {
        return false;
    }
    
    public static void cadastrarClientePJ(PessoaJuridica cliente) throws SQLException, Exception {
        try {
            PessoaDAO.inserirPJ(cliente);
            
        } catch (SQLException e) {
            //mostra no console qualquer erro que ocorra no 'MOCK'
            System.err.println("Erro na fonte de dados");
        }
    }
    
     public static void atualizaClientePJ(PessoaJuridica cliente) {
        
        try {
            
        } catch (Exception e) {
        }
      
    }


    public static PessoaJuridica obterClientePJ(Integer id) {
       
        return null;
    }
    
}
