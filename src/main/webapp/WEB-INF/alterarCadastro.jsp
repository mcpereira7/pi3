<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Atualizar Cadastro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/alterarCadastro.css" />
        <script src="js/jquery.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>

        <!--Navigation bar-->
        <%@include file="../navbar.jsp" %>

        <!--Content-->
        <div class="login-div">
            <form class="login" action="${pageContext.request.contextPath}/cadastroAtualizar" method="GET">
                <h1>Atualizar Cadastro</h1>
                <input class="cadastro-input" type="input" name="nome" placeholder="Nome" value ="${usuario.nome}">
                <input class="cadastro-input" type="input" name="email" placeholder="E-mail" value ="${usuario.email}"> 
                <input class="cadastro-input" type="input" name="senha" placeholder="Senha Atual">
                <input class="cadastro-input" type="input" name="senha" placeholder="Nova Senha">
                <input class ="botao-login" type="submit" value="Atualizar">
            </form>
        </div>


    </body>
</html>
