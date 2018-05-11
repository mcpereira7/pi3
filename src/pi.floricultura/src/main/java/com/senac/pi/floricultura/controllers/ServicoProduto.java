/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.ProdutoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

    public static double getPrecoProdutoById(int idProduto) {

        double preco;

        try {

            preco = ProdutoDAO.getPriceById(idProduto);

            return preco;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static List<Integer> getProdutoIdByCodigo(String[] codigos) {

        int[] codigosNum = new int[codigos.length];
        try {

            for (int i = 0; i < codigos.length; i++) {
                codigosNum[i] = Integer.parseInt(codigos[i]);
            }

            List<Integer> resultado = ProdutoDAO.getIdByCodigo(codigosNum);

            return resultado;

        } catch (Exception ex) {
            Logger.getLogger(ServicoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
