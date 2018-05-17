/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aayan
 */
public class ProdutoTestes {

    public static List<Produto> geraProdutosHARDCODE(int quantidade) {

        //Dados do produto
        String nome = "produto";

        int tipo = 1;

        float preco = (float) 2.5;

        Date dataCadastro = new Date();

        String descricao = "descricao";

        //Gerador
        List<Produto> lista = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            
            if(tipo > 5) {
                tipo = 1;
            }

            Produto teste = new Produto(
                    (preco + (float) i),
                    nome + i,
                    descricao + i,
                    tipo++,
                    dataCadastro);

            lista.add(teste);
        }

        return lista;

    }

}
