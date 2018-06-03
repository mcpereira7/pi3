<%-- 
    Document   : ListarFilial
    Created on : 11/05/2018, 16:35:34
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <title>Pagina Generica</title>
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
                    <strong class="page-name">Funcao da Pagina</strong>

                    <!-- Content -->
                    <section>
                        <header class="main">
                            <h1>Nossas Filiais</h1>
                        </header>

                        <c:forEach var="filial" items="${listFilial}">
                            <div class="cursos">
                                <a href="#" id="mapaFilial">  <img src="img/maps/FLSP01.PNG" style="width: 230px; height: 300px;">
                                    <p><c:out value="${filial.codigoFilial}"></c:out></p>
                                    <p>Gerente: <c:out value="${filial.responsavel}"></c:out></p>
                                    <p>&#9742 <c:out value="${filial.telefone}"></c:out> <br> 
                                        &#9742 <c:out value="${filial.telefone2}"></c:out></p>
                                    </a>
                                </div>
                        </c:forEach>


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
