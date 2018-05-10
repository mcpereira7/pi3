<%-- 
    Document   : CadastrarClientePF
    Created on : 18/04/2018, 11:06:44
    Author     : Marcelo Pereira
--%>

<%@page import="com.senac.pi.floricultura.controllers.ServicoCliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.senac.pi.floricultura.model.GerarCodigo"%>
<%@page import="com.senac.pi.floricultura.model.PessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente PF</title>
        <link rel="stylesheet" type="text/css" href="css/estilo1.css" media="all">
    </head>
    <body>
        
        
        <h1>Cadastro Cliente PF</h1>
        <form action="cadastrarCliente" method="POST">
            <div class="dadosPessoais">
                <label for="Nome">Nome:</label> 
                <input type="text" name="nome" id="Nome">

                <label for="apelido">Apelido:</label>
                <input type="text" name="apelido" id="apelido">

                <label for="cpf">CPF:</label>
                <input type="text" name="cpf" id="cpf">

                <label for="rg">RG: </label>
                <input type="text" name="rg" id="rg">

                <label for="dtNasc">Data Nasc:</label>
                <input type="date" name="dtNasc" id="dtNasc">
                
                <label>Sexo</label>
		<label class="checkbox">
                <input type="radio" name="sexo" value=1> Masculino
		<input type="radio" name="sexo" value=2> Feminino
                <input type="radio" name="sexo" value=3> Outro
		</label>
            </div>
            <div class="contato">
                <label for="email">E-mail:</label>
                <input type="email" name="email" id="email">
                
                <label for="tel">Telefone:</label>
                <input type="tel" name="tel" id="tel">
                
                <label for="cel">Celular:</label>
                <input type="tel" name="cel" id="cel">
            </div>
            <div class="endereco">
                <h3>Endereço</h3>

                <label for="log">Logradouro:</label>
                <input type="text" name="log" id="log">
                
                <label for="num">Numero:</label>
                <input type="text" name="numero" id="num">
                
                <label for="comp">Complementeo:</label>
                <input type="text" name="comp" id="comp">
                
                <label for="bairro">Bairo:</label> 
                <input type="text" name="bairro" id="bairro">
                
                <label for="cid">Cidade:</label> 
                <input type="text" id="cid" name="cid">
                
                <label for="cep">CEP:</label> 
                <input type="text" name="cep" id="cep">
                
                <label for="uf">UF:</label>
                <input type="text" id="uf" name="uf">
            </div>
            
            
            
            <%
                PessoaFisica pf = new PessoaFisica();
                pf.setNome( request.getParameter("Nome"));
                pf.setApelido(request.getParameter("apelido"));
                pf.setCodObjeto(new GerarCodigo().setCodigoCli());
                pf.setTipo(1);
                
                SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-d" );
                Date data = new Date(System.currentTimeMillis());
                String date = formato.format(data);
                
                pf.setData(formato.parse(date));
                pf.setCpf(request.getParameter("cpf"));
                pf.setRg(request.getParameter("rg"));
                pf.setSexo(1);
                data = formato.parse(date);
                pf.setDtNasc(data);
                pf.setEmail(request.getParameter("email"));
                pf.setTelefone(request.getParameter("tel"));
                pf.setTelefone2(request.getParameter("cel"));
                
        %>
        
        <input type="submit" name="btCadastrar" id="btCadastrar" value="Cadastrar">
            
        </form>
    </body>
</html>
