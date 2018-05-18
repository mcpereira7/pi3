<%-- 
Document   : FormVenda
Created on : 17/04/2018, 20:59:34
Author     : andre.ayamamoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conclusao de Venda</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/main.css" />
    </head>

    <body>

        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Main -->
            <div id="main">
                <div class="inner">

                    <!-- Header -->
                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Conclusão de Venda</strong>

                    <!-- Content -->
                    <section>
                        <form id="venda-form" action="${pageContext.request.contextPath}/venda-conclusion" method="post">

                            <fmt:setLocale value="pt-BR"></fmt:setLocale>

                                <p>Codigo:
                                <c:out value="${novaVenda.codigo}" />
                            </p>
                            <p>Data:
                                <fmt:formatDate value="${dataVenda}" type="date" dateStyle="short" />
                            </p>
                            <p>Cliente:
                                <c:out value="${clienteCPF}" />
                            </p>
                            <p>Vendedor:
                                <c:out value="${novaVenda.idVendedor}" />
                            </p>
                            <p>Total:
                                <fmt:formatNumber value="${novaVenda.valorTotal}" type="currency" />
                            </p>
                            <hr class="major" />

                            <c:forEach items="${novaVenda.listaItensVenda}" var="item">

                                <p>
                                    Produto: <c:out value="${item.nomeProduto}" /> / 
                                    Quantidade: <c:out value="${item.quantidade}" /><br>
                                    Unidade: <fmt:formatNumber value="${item.valor}" type="currency" /> / 
                                    Ao todo: <fmt:formatNumber value="${item.valor * item.quantidade}" type="currency"/>
                                </p>
                                <br>

                            </c:forEach>

                            <input type="submit" value="Concluir">

                        </form>

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