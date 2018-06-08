<%-- 
    Document   : home
    Created on : 23/05/2018, 09:58:24
    Author     : aayan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
        <script src="js/jquery.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>

        <!--Navigation bar-->
        <%@include file="/navbar.jsp" %>

        <!-- Main -->
        <div class="main">

            <!-- Content -->
            <div class="content">

                <!--Board-->
                <div class="board">

                    <form id="card-form" action="${pageContext.request.contextPath}/card" method="get">
                        <input type="hidden" id="cardId" name="cardId"/>
                    </form>

                    <c:forEach items="${board.listCards}" var="card">

                        <div class="card" onclick="getCardId(${card.idCard})" style="background-color: ${card.cor}">

                            <div class="card-title">
                                ${card.titulo}

                            </div>

                            <div class="card-content">
                                <c:if test="${card.tipo == 1}">
                                    ${card.conteudo}
                                </c:if>
                                <c:if test="${card.tipo == 2}">
                                    <iframe width="300" height="250" src="${card.link}"></iframe>

                                </c:if>
                                <c:if test="${card.tipo == 3}">
                                    ${card.conteudo}
                                </c:if>

                            </div>

                        </div>

                    </c:forEach>

                </div>

            </div>

        </div>
    </body>
</html>