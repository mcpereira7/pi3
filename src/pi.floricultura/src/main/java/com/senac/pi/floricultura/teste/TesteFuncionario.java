/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.controllers.ServicoFuncionario;
import com.senac.pi.floricultura.model.Funcionario;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.utilitarios.Auxiliares;
import java.text.ParseException;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class TesteFuncionario {
    public static void main(String[] args) throws ParseException {
        GerarCodigo codigo = new GerarCodigo();
        Funcionario us = new Funcionario();
        us.setNome("Leandro Alves");
        us.setCodObjeto(codigo.setCodigoFunc());
        us.setTipo(1);
        us.setData(Auxiliares.InputDateToUtilDate("06-06-2018"));
        us.setDisable(false);
        us.setCpf("44455566699");
        us.setDtNasc(Auxiliares.InputDateToUtilDate("25-09-1996"));
        us.setSexo(11);
        us.setEmail("leandro@empresa.com");
        us.setTelefone("1154447777");
        us.setTelefone2("11965653232");
        us.setCodigo(us.getId() + 1000);
        us.setFuncao("Gerente");
        us.setSalario(2500.00);
        us.setUser("leandro.alves");
        us.setPassword("abc123");
        us.setIdFilial(1);
        us.setIdGrupo(2);
        
        try {
            ServicoFuncionario.cadastrarFuncionario(us);
        } catch (Exception e) {
        }
    }
    
}
