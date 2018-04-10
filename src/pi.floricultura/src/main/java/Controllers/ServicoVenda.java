/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.VendaDAO;
import Exceptions.VendaException;
import Model.Venda;
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
            DAO.VendaDAO.inserir(entrada);
            int id = DAO.VendaDAO.getLastVendaID();
            DAO.VendaDAO.insertItensVenda(entrada.getListaItensVenda(), id);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<Venda> ConsultaVendaByData(Date de, Date ate)
            throws VendaException {
        try {
            return DAO.VendaDAO.getVendaByDates(de, ate);
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
