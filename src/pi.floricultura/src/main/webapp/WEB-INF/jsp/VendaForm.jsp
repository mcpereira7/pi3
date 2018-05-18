<%-- 
Document   : VendaForm2
Created on : 09/05/2018, 18:43:47
Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>VendaForm2</title>
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
                    <strong class="page-name">Nova Venda</strong>

                    <!-- Content -->
                    <section>
                        <form id="venda-form" action="${pageContext.request.contextPath}/venda-conclusion" method="get">

                            <h3>Cliente</h3>
                            <input type="text" placeholder="CPF do cliente..." name="cliente" id="cliente" maxlength="14"/>
                            <br>
                            <hr class="general" />

                            <div id="vendaDiv">
                                <h4>Nome Produto 1:</h4>
                                <input type="text" name="produto" id="produto1" />
                                <br> <h4>Quantidade:</h4>
                                <input type="number" min="0" name="quantidadeProduto" id="quantProduto1"/>
                                <br>
                                <br>
                            </div>
                            <input type="button" value="Novo produto" onclick="addInputOnDiv('vendaDiv')">
                            <input type="submit" value="Salvar" />
                        </form>

                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>
        <script src="js/venda.js"></script>

    </body>

</html>