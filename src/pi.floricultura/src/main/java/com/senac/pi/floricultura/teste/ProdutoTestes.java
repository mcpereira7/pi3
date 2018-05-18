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

            if (tipo > 5) {
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

    public static Produto gerarProdutoUnico(String nome) {

        Produto doBanco = new Produto();

        doBanco.setNome(nome);
        doBanco.setPreco((float) 12.39);
        doBanco.setDescricao("Um produto de descricao gande para"
                + " o teste maneiro desse produto acontecer normalmente."
                + "\nEsse texto teria que estar na linha de baixo");
        doBanco.setTipo(3);
        doBanco.setDataCadastro(new Date());
        doBanco.setQuantidadeEstoque(90);

        return doBanco;

    }

}
