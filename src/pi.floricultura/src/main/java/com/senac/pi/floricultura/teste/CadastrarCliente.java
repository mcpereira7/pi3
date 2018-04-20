package com.senac.pi.floricultura.teste;

import com.senac.pi.floricultura.DAO.EnderecoDAO;
import com.senac.pi.floricultura.controllers.ServicoCliente;
import com.senac.pi.floricultura.model.Endereco;
import com.senac.pi.floricultura.model.GerarCodigo;
import com.senac.pi.floricultura.model.PessoaFisica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cadastrarCliente")
public class CadastrarCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String codObjeto = new GerarCodigo().setCodigoCli();
        String nome = req.getParameter("nome");
        String apelido = req.getParameter("apelido");
        String cpf = req.getParameter("cpf");
        String rg = req.getParameter("rg");
        int tipo = 1;
//        Data do sistema - ainda não achei um jeito melhor de pegar e formatar a mesma
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-dd" );
        Date data = new Date(System.currentTimeMillis());
        String date = formato.format(data);
        
        Date dtNasc = null;
        
        try {
            dtNasc = formato.parse(req.getParameter("dtNasc"));
            data = formato.parse(date);
                    } catch (ParseException ex) {
//            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro na data!");
        }
        int sexo = req.getIntHeader("sxType");
        String email = req.getParameter("email");
        String telefone = req.getParameter("tel");
        String telefone2 = req.getParameter("cel");
        
        // endereço PessoaFisica
        String log = req.getParameter("log");
        String numero = req.getParameter("numero");
        String complemento = req.getParameter("comp");
        String bairro = req.getParameter("bairro");
        String cidade = req.getParameter("cid");
        String cep = req.getParameter("cep");
        String uf = req.getParameter("uf");
        
        // Objetos PessoaFisica e Endereço criados com os dados recebidos no form
        
        PessoaFisica pf = new PessoaFisica(cpf, sexo, dtNasc, email, telefone, telefone2, codObjeto, nome, tipo, data, false);
        pf.setApelido(apelido);
        Endereco endereco = new Endereco(pf.getId(), cep, log, numero, complemento, bairro, cidade, uf);
        
        try {
            ServicoCliente.cadastrarClientePF(pf);
            EnderecoDAO.inserirEndereco(endereco, pf.getId());
            PrintWriter writer = resp.getWriter();
            writer.println("<html><body>Empresa adicionanda com Sucesso</body></html>");
            
        } catch (Exception e) {
            System.out.println("Achou mesmo que seria assim tão fácil?");
            System.out.println("Aproveita que tá sentado e chora...hahaha");
        }
    }
    
    
}
