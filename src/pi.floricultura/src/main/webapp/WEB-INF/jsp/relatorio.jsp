<%-- 
    Document   : relatorio
    Created on : 09/05/2018, 19:38:03
    Author     : Vinicius Presoto
--%>

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


    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Main -->
        <div id="main">
            <div class="inner">

                <!-- Header -->
                <header id="header">
                    <a href="index.html" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
                    <ul class="icons">
                        <li><a href="#"><span class="label">User Name</span></a></li>
                        <li><a href="#"><span class="label">User Foto</span></a></li>
                        <li><a href="#"><span class="label">Sair</span></a></li>
                    </ul>
                </header>

                <body>

                    <section>
                        <form action="/RelatorioServlet" method="POST">
                            <label for="dtIni">Data Inicio</label>
                            <input type="date" name="dtIni" id="dtIni">
                            <label for="dtFim">Data Fim</label>
                            <input type="date" name="dtFim" id="dtFim">
                            <input type="submit" name="gerar" id="gerar" value="Gerar Relatório">
                        </form>
                        <c:forEach items = "${listaVenda}" var = "VendaDAO">
                            <h2><c:out value="$(VendaDao.nome}"></c:out></h2>

                                <table>
                                    <theader>
                                        <h1>Relatório de Vendas</h1>
                                        <tr>
                                            <th>ID Venda</th>
                                            <th>ID Cliente</th>
                                            <th>Itens da Venda</th>
                                            <th>Data da Venda</th>
                                            <th>Valor Total</th>
                                        </tr>
                                    </theader>

                                <c:forEach items = "${listaVenda}" var = "Venda">
                                    <tr>
                                        <td><c:out value="$(Venda.id}"></c:out></td>
                                        <td><c:out value="$(Venda.idCliente}"></c:out></td>
                                        <td><c:out value="$(Venda.listaItensVenda}"></c:out></td>
                                        <td><c:out value="$(Venda.dtDate}"></c:out></td>
                                        <td><c:out value="$(Venda.ValorTotal}"></c:out></td>
                                        </tr>
                                </c:forEach>
                            </table>
                        </c:forEach>

                        <footer id="footer">
                            <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
                        </footer>

            </div>
        </div>

    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/util.js"></script>
    <script src="js/main.js"></script>


</body>
</html>
