/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.servlets;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.controllers.ServicoFilial;
import com.senac.pi.floricultura.controllers.ServicoFuncionario;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.Funcionario;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.utilitarios.Auxiliares;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/CadastroFuncionario"})
public class FuncionarioCadastroServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List filiais = ServicoFilial.listar();
        
//        req.setAttribute("filiais", filiais);
        req.getSession().setAttribute("filiais", filiais);
        req.getRequestDispatcher("WEB-INF/jsp/CadastroFuncionario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codObjeto = new GerarCodigo().setCodigoCli();
        String nome = req.getParameter("nome");
        String apelido = req.getParameter("apelido");
        String cpf = req.getParameter("cpf");
        String rg = req.getParameter("rg");
        int tipo = 1;
        Date data = new Date(System.currentTimeMillis());
        
        Date dtNasc = null;
        try {
            dtNasc = Auxiliares.InputDateToUtilDate(req.getParameter("dtNasc"));
            data = Auxiliares.ftmtData();
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int sexo = Integer.parseInt(req.getParameter("sexo"));
        String email = req.getParameter("email");
        String telefone = req.getParameter("tel");
        String telefone2 = req.getParameter("cel");
        String funcao = req.getParameter("funcao");
        Double sal = Double.parseDouble(req.getParameter("sal"));
        String us = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        int filial = Integer.parseInt(req.getParameter("filial"));
        
        // endereço PessoaFisica
        String log = req.getParameter("log");
        String numero = req.getParameter("numero");
        String complemento = req.getParameter("comp");
        String bairro = req.getParameter("bairro");
        String cidade = req.getParameter("cid");
        String cep = req.getParameter("cep");
        String uf = req.getParameter("uf");
        
        
        Funcionario fu = new Funcionario();
        fu.setNome(nome);
        fu.setCodObjeto(codObjeto);
        fu.setTipo(1);
        fu.setData(data);
        fu.setDisable(false);
        fu.setCpf(cpf);
        fu.setDtNasc(dtNasc);
        fu.setSexo(sexo);
        fu.setEmail(email);
        fu.setTelefone(telefone);
        fu.setTelefone2(telefone2);
        fu.setFuncao(funcao);
        fu.setSalario(sal);
        fu.setUser(us);
        fu.setPassword(senha);
        fu.setIdFilial(filial);
        fu.setIdGrupo(2);
        
        Endereco endereco = new Endereco(fu.getId(), cep, log, numero, 
                complemento, bairro, cidade, uf);
        
        try {
            ServicoFuncionario.cadastrarFuncionario(fu);
            EnderecoDAO.inserirEndereco(endereco, fu.getId());
        } catch (Exception e) {
        }
         req.getRequestDispatcher("WEB-INF/jsp/CadastroFuncionario.jsp").forward(req, resp);
    }
    
}
