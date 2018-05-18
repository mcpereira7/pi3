<%-- 
    Document   : ProdutoAlteracao
    Created on : 17/05/2018, 13:59:44
    Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE JSP>

<html>

    <head>
        <title>HomePage</title>
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
                    <strong class="page-name">Alterar produto</strong>

                    <!-- Content -->
                    <section>

                        <div class="produto-form">
                            <form action="${pageContext.request.contextPath}/produto" method="post">
                                Nome:
                                <input type="text" name="nome" id="nome" value="${produtoCadastrado.nome}" placeholder="Nome do produto..." maxlength="100">
                                <hr class="general"/>

                                <div class="produto-info">
                                    Preço:<input type="number" value="${produtoCadastrado.preco}" placeholder="5.00" step="0.01" min=5 name="preco" maxlength="10"/>
                                    <br><br>
                                    Quantidade:<input type="number" value="${produtoCadastrado.quantidadeEstoque}" name="quantidade" placeholder="00" step="1" min=0/ maxlength="10">
                                </div>
                                <input type="hidden" id="produtoTipo" value="${produtoCadastrado.tipoNome}"/>

                                <div class="produto-tipo">
                                    Tipo:&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="tipo" id="indefinido"><label for="indefinido">Indefinido</label>
                                    <input type="radio" name="tipo" id="flor"><label for="flor">Flor</label>
                                    <input type="radio" name="tipo" id="planta"><label for="planta">Planta</label>
                                    <input type="radio" name="tipo" id="rosa"><label for="rosa">Rosa</label>
                                    <input type="radio" name="tipo" id="ilicita"><label for="ilicita">Ilícita</label>
                                </div>
                                <div>
                                    <input type="hidden" id="produtoDescricao" value="${produtoCadastrado.descricao}"/>
                                    Descrição: <br>
                                    <textarea name="descricao" id="descricao" placeholder="Descrição do produto..." cols="30" rows="3" col></textarea>
                                </div>
                                <input type="button" value="Alterar">
                            </form>
                        </div>
                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <!-- Scripts -->
        <!-- <script>includeHTML();</script> -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>
        <script src="js/produto.js"></script>

    </body>

</html>