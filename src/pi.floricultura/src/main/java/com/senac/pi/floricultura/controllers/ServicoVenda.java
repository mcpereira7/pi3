/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ServicoVenda {

    public static void ConcluirVenda(Venda entrada) throws VendaException {
        try {
            
            // falta serviço produto  ServicoProduto.AtualizaEstoque(entrada.getListaItensVenda());
            VendaDAO.inserir(entrada);
            
            //Inserir itensVenda com o id da venda
            int id = com.senac.pi.floricultura.DAO.VendaDAO.getLastVendaID();
            VendaDAO.insertItensVenda(entrada.getListaItensVenda(), id);
            
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<Venda> ConsultaVendaByData(Date de, Date ate)
            throws VendaException {
        try {
            return VendaDAO.getVendaByDates(de, ate);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static int geraCodVenda()
            throws VendaException {
        try {

            int codigo = VendaDAO.countVendas();
            codigo++;

            while (codigo == VendaDAO.countVendas()) {
                codigo++;
            }

            return codigo;

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }
    
}
