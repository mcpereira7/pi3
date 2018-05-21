<%-- 
Document   : ProdutoConsulta
Created on : 16/05/2018, 12:17:50
Author     : aayan
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Produto</title>
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
                    <strong class="page-name">Consulta de Produtos</strong>

                    <!-- Content -->
                    <section>
                        <form id="produto-consulta" action="${pageContext.request.contextPath}/listarprodutos" method="GET">

                            <fmt:setLocale value="pt-BR"></fmt:setLocale>

                                <div class="produto-consulta-info">
                                <c:choose>
                                    <c:when test="${(procura!='') || (procura!=null)}">
                                        <input type="text" name="consulta" id="consulta" placeholder="Nome do produto..." value="${procura}" maxlength="40">
                                    </c:when>    
                                    <c:otherwise>
                                        <input type="text" name="consulta" id="consulta" placeholder="Nome do produto..." maxlength="40">
                                    </c:otherwise>
                                </c:choose>

                                <input type="submit" value="Procurar">
                            </div>

                        </form>

                        <form id="produto-resultados" action="${pageContext.request.contextPath}/produtoalteracao" method="get">
                            <table id="produtoTable">
                                <theader>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Tipo</th>
                                        <th>Preço</th>
                                        <th>Data de Cadastro</th>
                                        <th>Descrição</th>
                                    </tr>
                                </theader>
                                <tbody>
                                    <c:forEach items = "${listaProdutos}" var = "produto">
                                        <tr id="rowSelection">
                                            <td id="produtoNome"><c:out value="${produto.nome}"/></td>
                                            <td><c:out value="${produto.tipoNome}"/></td>
                                            <td><fmt:formatNumber value="${produto.preco}" type="currency" /></td>
                                            <td><fmt:formatDate value="${produto.dataCadastro}" type="date" dateStyle="short" /></td>
                                            <td><c:out value="${produto.descricao}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <input type="hidden" id="produtoSelecionado" name="produtoSelecionado"/>

                            </table>
                        </form>

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
        <script src="js/produto.js"></script>

    </body>
</html>