<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
        <script src="js/jquery.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>

        <!--Navigation bar-->
        <%@include file="navbar.jsp" %>

        <div class="main-login">
            <div class="login-box">

                <div class="login-box-head">
                    <p class="login-box-head-face">Notes</p>
                </div>

                <c:if test="${validado == false}">
                    <span><h2 style="color: red">Erro ao logar</h2></span>
                </c:if>

                    <form id="login-form" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="login-box-content">
                        <input type="text" name="login" placeholder="Username..." required="true">
                        <input type="password" name="password" placeholder="Password...">
                    </div>
                    <div class="login-box-btn">
                        <input type="submit" value="Login"/>
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>