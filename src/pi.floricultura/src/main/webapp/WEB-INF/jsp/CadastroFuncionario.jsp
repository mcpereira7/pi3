<%-- 
    Document   : CadastroUsuario
    Created on : 21/05/2018, 13:12:03
    Author     : Marcelo Pereira <macope727@gmail.com>
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
        <title>PI Floricultura</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="css/main.css" />
    </head>
    <body>

        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Main -->
            <div id="main">
                <div class="inner">

                    <!-- Header -->
                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Cadastro Funcionário</strong>

                    <!-- Content -->
                    <section>
                        <header class="main">
                        </header>

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

                                <label for="sexo">Sexo</label>
                                <select name="sexo" id="sexo">
                                    <option value="1">Masculino</option>
                                    <option value="2">Feminino</option>
                                    <option value="3">Outros</option>
                                </select>

                                <label for="funcao">Função</label>
                                <select name="funcao" id="sexo">
                                    <option value="Gerente">Gerente</option>
                                    <option value="Atendente">Atendente</option>
                                    <option value="Caixa">Caixa</option>
                                    <option value="Florista">Florista</option>
                                    <option value="Jardineiro">Jardineiro</option>
                                    <option value="Entregador">Entregador</option>
                                </select>
                                <label for="filial">Filial</label>
                                <select name="filial" id="filial">
                                    <c:forEach  var = "filial" items = "${filiais}">
                                        <option value="${filial.getId()}">${filial.getCodigoFilial()}</option>
                                    </c:forEach>
                                </select>
                                <label for="sal">Salário</label>
                                <input type="number" name="sal" id="sal">
                                <label for="usuario">Usuario</label>
                                <input type="text" name="usuario" id="usuario">
                                <label for="senha">Senha</label>
                                <input type="text" name="senha" id="senha">
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

                            <input type="submit" name="btCadastrar" id="btCadastrar" value="Cadastrar">
                        </form>									<hr class="major" />

                        <hr class="major" />


                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
