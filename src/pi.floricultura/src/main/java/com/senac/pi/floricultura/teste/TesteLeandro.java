package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.controllers.ServicoEstoqueProduto;
import com.senac.pi.floricultura.controllers.ServicoMovimentoEstoque;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteLeandro {
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-dd" );
        Date dataInicial = formato.parse("2018-04-13");
        Date dataFinal = formato.parse("2018-04-13");
        
        ServicoMovimentoEstoque.ListarMovimentoEstoque(null,null , 
                dataInicial, dataFinal, 3, null);
        //ServicoEstoqueProduto.listarEstoque(null, null);
    }
}
