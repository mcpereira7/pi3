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

                    <!-- Header -->
                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Alteracao de Estoque</strong>

                    <!-- Content -->
                    <section>
                        <fmt:setLocale value="pt-BR"></fmt:setLocale>
                        <form id="estoque-form" action="${pageContext.request.contextPath}/alterarestoque" method="GET">

                            <div class="produto-consulta-info">
                                <input type="text" name="consulta" id="consulta" placeholder="Nome do produto..." maxlength="40"/>
                                <input type="submit" value="Procurar">
                            </div>

                        </form>

                        Nome: <c:out value="${produto.nome}" ></c:out>
                        Preco: <c:out value="${produto.preco}" ></c:out>
                        Descricao: <c:out value="${produto.descricao}" ></c:out>
                        Tipo: <c:out value="${produto.tipo}" ></c:out>
                        Disable: <c:out value="${produto.disable}" ></c:out>
                        
                        
<!--                        <form id="produto-resultados" action="${pageContext.request.contextPath}/produtoalteracao" method="get">
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
                        </form>-->

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