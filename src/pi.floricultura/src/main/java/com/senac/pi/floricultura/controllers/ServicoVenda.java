/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.VendaDAO;
import com.senac.pi.floricultura.exceptions.VendaException;
import com.senac.pi.floricultura.model.Venda;
import java.awt.Component;
import java.awt.HeadlessException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ServicoVenda {
    
     public static List<Cliente> ConsultaClienteByNomeOuCodigo(String campoDaConsulta,
            List<ItensVenda> listaItensVenda, List<Cliente> listaDeClientes, Component tela)
            throws VendaException {

        try {
            if (!campoDaConsulta.isEmpty()) {
                if (!listaItensVenda.isEmpty() || !listaDeClientes.isEmpty()) {
                    JOptionPane.showMessageDialog(tela, "Venda em andamento.");
                    return null;
                } else {
                    if (isParsable(campoDaConsulta)) {

                        listaDeClientes = ServicoCliente.procuraCliente(Integer.parseInt(campoDaConsulta), campoDaConsulta);

                        if (listaDeClientes.size() > 1) {
                            JOptionPane.showMessageDialog(tela, "Foi encontrado multiplos clientes com o mesmo nome.");
                            return listaDeClientes;
                        } else {
                            return listaDeClientes;
                        }

                    } else {
                        listaDeClientes = ServicoCliente.procuraCliente(-1, campoDaConsulta);
                        return listaDeClientes;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(tela, "Digite um nome ou valor valido.");
                return null;
            }
        } catch (ClienteException | DataSourceException | HeadlessException | NumberFormatException e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }


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
