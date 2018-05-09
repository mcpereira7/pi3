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
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
        <script src="js/main.js"></script>
    </head>

    <body>

        <form action="${pageContext.request.contextPath}/venda-conclusion" method="get">

            <h1>Venda</h1>
            <fmt:setLocale value="pt-BR"></fmt:setLocale>
            <p>Codigo: <c:out value="${novaVenda.codigo}" /></p>
            <p>Data: <fmt:formatDate value="${dataVenda}"  type="date" dateStyle="short"/></p>
            <p>Cliente: <c:out value="${novaVenda.idPessoa}" /></p>
            <p>Vendedor: <c:out value="${novaVenda.idVendedor}" /></p>
            <p>Total: <fmt:formatNumber value="${novaVenda.valorTotal}" type="currency"/></p>

            <c:forEach items="${novaVenda.listaItensVenda}" var="item">

                <p>Produto: <c:out value="${item.idProduto}"/> / 
                    Quantidade: <c:out value="${item.quantidade}"/> / 
                    Unidade: <fmt:formatNumber value="${item.valor}" type="currency"/> / 
                    Ao todo: <fmt:formatNumber value="${item.valor * item.quantidade}" type="currency"/></p><br>

            </c:forEach>

            <input type="submit" value="Concluir">
        </form>
    </body>

</html>
