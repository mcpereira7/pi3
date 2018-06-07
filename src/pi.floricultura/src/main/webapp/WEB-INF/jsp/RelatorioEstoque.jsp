<%-- 
    Document   : relatorio
    Created on : 03/06/2018, 15:10:03
    Author     : Vinicius Presoto
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <strong class="page-name">Relatório de Estoque</strong>

                    <!-- Content -->
                    <section>
                        <fmt:setLocale value="pt-BR"></fmt:setLocale>
                            <h2>Relatório de Estoque</h2>

                            <form id="relatorio-estoque" action="${pageContext.request.contextPath}/relatorioestoque" method="POST">

                            <label for="listaFilial">Filiais</label>
                            <select id ="listaFilial" name="listaFilial">
                                <option value="-1">Todos</option>
                                <c:forEach items = "${listaFiliais}" var = "filial">
                                    <option value="${filial.id}">${filial.nome}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="Gerar Relatório" name ="gerarRelatorio">
                        </form>

                        <c:if test="${filialSelecionada != null || filialSelecionada == -1}">
                            <c:forEach items = "${listaFiliais}" var = "filial">
                                <c:if test="${filial.id == filialSelecionada || filialSelecionada == -1}">
                                    <h2>${filial.nome}</h2>
                                    <table>
                                        <theader>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Quantidade no Estoque</th>
                                                <th>Preço</th>
                                            </tr>
                                        </theader>

                                        <c:forEach items = "${listaEstoqueProduto}" var = "produto">
                                            <c:if test="${filial.id == produto.id_pessoa}">
                                                <tr>
                                                    <td><c:out value="${produto.nome}"/></td>
                                                    <td><c:out value="${produto.quantidade}"/></td>
                                                    <td><fmt:formatNumber value="${produto.preco}" type="currency" /></td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>     

                                </c:if>
                            </c:forEach>
                        </c:if>

                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>


    </body>
</html>