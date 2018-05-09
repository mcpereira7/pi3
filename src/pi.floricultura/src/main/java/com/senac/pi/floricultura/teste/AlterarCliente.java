/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = "/alterarCliente")
public class AlterarCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-d" );
        String date = formato.format(data);
        Date dtCad = null;
        Date dtNasc = null;
        try {
            dtCad = formato.parse(date);
            dtNasc = formato.parse(req.getParameter("dtNasc"));
        } catch (Exception e) {
        }
        String sexo = req.getParameter("sexo");
        String cod = req.getParameter("cod");
        String cend = req.getParameter("cend");
        PessoaFisica pf = new PessoaFisica(req.getParameter("cpf")
                , Integer.parseInt(sexo)
                , dtNasc
                , req.getParameter("email")
                , req.getParameter("tel")
                , req.getParameter("cel")
                , req.getParameter("cobj")
                , req.getParameter("nome")
                , 1
                , dtCad
                , false);
        // endereço PessoaFisica
        String log = req.getParameter("log");
        String numero = req.getParameter("numero");
        String complemento = req.getParameter("comp");
        String bairro = req.getParameter("bairro");
        String cidade = req.getParameter("cid");
        String cep = req.getParameter("cep");
        String uf = req.getParameter("uf");
        Endereco end = new Endereco(pf.getId(), cep, log, numero, complemento, bairro, cidade, cidade);
//        end.setIdEndereco(Integer.parseInt(cend));
        
        try {
            pf.setId(Integer.parseInt(cod));
            end.setIdEndereco(Integer.parseInt(cend));
            ServicoCliente.atualizaClientePF(pf);
            ServicoCliente.buscaEnderecoPF(pf.getId());
            PrintWriter writer = resp.getWriter();
            writer.println("<html><body>Registro Atualizado com Sucesso</body></html>");
        } catch (Exception e) {
        }
      
    }
    
    
}
