<%-- 
Document   : card
Created on : 28/05/2018, 09:09:34
Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Card</title>
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

                <form id="form-cardsimples" action="${pageContext.request.contextPath}/card" method="post">
                    <c:if test="${card.tipo == 1}">
                        <input type="hidden" name="tipo" value="1">
                        <input type="text" id="tituloid" name="titulo" value="${card.titulo}" />
                        <textarea id="conteudoid" name="conteudo" cols="30" rows="10">${card.conteudo}</textarea>
                    </c:if>
                    <c:if test="${card.tipo == 2}">
                        <input type="hidden" name="tipo" value="1">
                        <input type="text" id="tituloid" name="titulo" value="${card.titulo}" />
                        <input type="text" id="conteudoid" name="conteudo" value="${card.link}" />
                        <iframe width="420" height="315" src="${card.link}"></iframe>

                    </c:if>
                    <c:if test="${card.tipo == 3}">
                        <input type="hidden" name="tipo" value="1">
                        <input type="text" id="tituloid" name="titulo" value="${card.titulo}" />
                        <textarea id="conteudoid" name="conteudo" cols="30" rows="10">${card.conteudo}</textarea>
                    </c:if>
                    <input type="submit" value="Alterar"/>

                </form>


            </div>

        </div>
    </body>
</html>
