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
        
        <form action="alterarCliente" method="POST">
            <div class="dadosPessoais">
                <label for="Nome">Nome:</label> 
                <input type="text" name="nome" id="Nome" value="${pf.getNome()}">

                <label for="apelido">Apelido:</label>
                <input type="text" name="apelido" id="apelido" value="${pf.getApelido()}">

                <label for="cpf">CPF:</label>
                <input type="text" name="cpf" id="cpf" value="${pf.getCpf()}">

                <label for="rg">RG: </label>
                <input type="text" name="rg" id="rg" value="${pf.getRg()}">

                <label for="dtNasc">Data Nasc:</label>
                <input type="date" name="dtNasc" id="dtNasc" value="${pf.getDtNasc()}">
                
                <label>Sexo</label>
		<label class="checkbox">
                <input type="radio" name="sexo" value="1"> Masculino
		<input type="radio" name="sexo" value="2"> Feminino
                <input type="radio" name="sexo" value="3"> Outro
		</label>
            </div>
            <div class="contato">
                <label for="email">E-mail:</label>
                <input type="email" name="email" id="email" value="${pf.getEmail()}">
                
                <label for="tel">Telefone:</label>
                <input type="tel" name="tel" id="tel" value="${pf.getTelefone()}">
                
                <label for="cel">Celular:</label>
                <input type="tel" name="cel" id="cel" value="${pf.getTelefone2()}">
            </div>
            <div class="endereco">
                <h3>Endereço</h3>

                <label for="log">Logradouro:</label>
                <input type="text" name="log" id="log" value="${end.getLog()}">
                
                <label for="num">Numero:</label>
                <input type="text" name="numero" id="num" value="${end.getNumero()}">
                
                <label for="comp">Complementeo:</label>
                <input type="text" name="comp" id="comp" value="${end.getComplemento()}">
                
                <label for="bairro">Bairo:</label> 
                <input type="text" name="bairro" id="bairro" value="${end.getBairro()}">
                
                <label for="cid">Cidade:</label> 
                <input type="text" id="cid" name="cid" value="${end.getCidade()}">
                
                <label for="cep">CEP:</label> 
                <input type="text" name="cep" id="cep" value="${end.getCep()}">
                
                <label for="uf">UF:</label>
                <input type="text" id="uf" name="uf" value="${end.getEstado()}">
                
                
            </div>
            
        
        <input type="submit" name="btCadastrar" id="btCadastrar" value="Salvar">
        <input hidden="true" type="text" name="cobj" value="${pf.getCodObjeto()}">
        <input hidden="true" type="text" name="cod" value="${pf.getId()}">
        <input hidden="true" type="text" name="cend" value="${end.getIdEndereco()}">
        </form>
    </body>
</html>
