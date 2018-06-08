<%-- 
Document   : AlterarEstoque
Created on : 21/05/2018, 19:29:29
Author     : aayan
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Altera Estoque</title>
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
                    <fmt:setLocale value="pt-BR"></fmt:setLocale>

                        <!-- Header -->
                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Alteracao de Estoque</strong>

                    <!-- Content -->
                    <section>

                        <form id="estoque-form" action="${pageContext.request.contextPath}/alterarestoque" method="GET">

                            <div class="produto-consulta-info">
                                <input type="text" name="consulta" id="consulta" placeholder="Nome do produto..." maxlength="40"/>
                                <input type="submit" value="Procurar">
                            </div>

                        </form>

                        <c:if test="${semproduto == true && produto == null}">

                            <p>Produto não encontrado</p>

                        </c:if>



                        <c:if test="${produto != null}">

                            <div class="altera-estoque-info" id="produtoInfos">
                                <p>Nome: <c:out value="${produto.nome}" ></c:out></p>
                                <p>Preco: <fmt:formatNumber value="${produto.preco}" type="currency"></fmt:formatNumber></p>
                                <p>Descricao: <c:out value="${produto.descricao}" ></c:out></p>
                                <p>Tipo: <c:out value="${produto.tipo}" ></c:out></p>
                                <p>Disable: <c:out value="${produto.disable}" ></c:out></p>

                            </div>

                            <form class="altera-estoque" id="form-alterarestoque" action="${pageContext.request.contextPath}/alterarestoque" method="post">
                                <input type="hidden" value="${quantidadeAtual}" id="quantidadeAtual"/>
                                <input name="quantidadeAlterar" id="quantidadeAlterar" placeholder="Quantidade Atual: ${quantidadeAtual}" type="text"/>
                                <input type="hidden" id="quantidadeFinal" name="quantidadeFinal"/>
                                <button type="button" onclick="alteraQuantidade(true)">+</button>
                                <button type="button" onclick="alteraQuantidade(false)">-</button>
                            </form>
                        </c:if>

                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>
        <script src="js/estoque.js"></script>

    </body>
</html>