/*
 * Alexandre Vinicius Ferreida da Silva & Leandro Alves
 * @author alexandre.vfsilva
 * Turma A
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.DAO.FilialDAO;
import com.senac.pi.floricultura.model.PessoaFisica;
import com.senac.pi.floricultura.DAO.PessoaDAO;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.Filial;
import com.senac.pi.floricultura.model.PessoaJuridica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexandre.vfsilva
 */
//Serviço de Clientes
public class ServicoFilial {

    public static void cadastrar(Filial filial) throws SQLException, Exception {
        try {
            FilialDAO.inserirFilial(filial);

        } catch (SQLException e) {
            //mostra no console qualquer erro que ocorra no 'MOCK'
            System.err.println("Erro na fonte de dados");
        }
    }

    public static void atualizar(Filial filial) {

        try {
            FilialDAO.atualizarFilial(filial);

        } catch (Exception e) {
        }

    }

    public static List<Filial> listar() {
        try {
            return FilialDAO.listaFilial();
        } catch (Exception e) {
        }
        return null;
    }

}
