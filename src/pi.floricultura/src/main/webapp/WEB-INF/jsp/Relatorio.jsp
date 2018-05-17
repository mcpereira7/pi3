<%-- 
Document   : relatorio
Created on : 09/05/2018, 19:38:03
Author     : Vinicius Presoto
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Relatório</title>
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
                <strong class="page-name">Relatório</strong>
                
                <!-- Content -->
                <section>
                    <form id="relatorio-form" action="${pageContext.request.contextPath}/Relatorio" method="post">
                        
                        <fmt:setLocale value="pt-BR"></fmt:setLocale>
                        
                        <div class="relatorio-info">
                            <div class="infos">
                                <label for="dtIni">Desde de: </label>
                                <input type="date" name="dataInicial" id="dataInicial">
                            </div>
                            <div class="infos">
                                <label for="dtFim">Até: </label>
                                <input type="date" name="dataFinal" id="dataFinal" readonly=true>
                            </div>

                            <input type="submit" name="gerar" id="gerar" value="Gerar Relatório">
                        </div>
                        
                    </form>
                    
                    <table>
                        <theader>
                            <tr>
                                <th>Código Venda</th>
                                <th>CPF Cliente</th>
                                <th>Data da Venda</th>
                                <th>Valor Total</th>
                            </tr>
                        </theader>
                        
                        <c:forEach items = "${listaVenda}" var = "venda">
                        <tr>
                            <td><c:out value="${venda.codigo}"/></td>
                            <td><c:out value="${venda.cpfPessoa}"/></td>
                            <td><fmt:formatDate value="${venda.dtDate}" type="date" dateStyle="short" /></td>
                            <td><fmt:formatNumber value="${venda.valorTotal}" type="currency" /></td>
                        </tr>
                    </c:forEach>
                    
                </table>
                
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
<script>
    inputDateNow('dataFinal');
</script>


</body>
</html>
