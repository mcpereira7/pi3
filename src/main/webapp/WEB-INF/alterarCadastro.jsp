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

        <div class="main">

            <!--Content-->
            <div class="main-content">
                <form id="signup-form" action="${pageContext.request.contextPath}/signup" method="post">

                    <div class="signup-box">

                        <c:if test="${erroCadastro == true}">
                            <h2 style="color: red">Erro ao cadastrar</h2>
                        </c:if>

                        <label for="iNome">Nome<span style="color: red">*</span></label>
                        <input type="text" name="nome" id="iNome" required="true">
                        <label for="iLogin">Login<span style="color: red">*</span></label>
                        <input type="text" name="login" id="iLogin" required="true">
                        <label for="iEmail">Email<span style="color: red">*</span></label>
                        <input type="email" name="email" id="iEmail" required="true">

                        <label for="iPass">Senha</label>
                        <input type="password" name="pass" id="iPass">

                        <label for="iPass2">Confirme</label>
                        <input type="password" name="pass" id="iPass2">

                        <input type="submit" value="Sign Up">

                    </div>

                </form>
            </div>

        </div>


    </body>
</html>
