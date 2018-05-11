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
                    <header id="header">
                        <a href="" class="logo">
                            <strong>Conclusão</strong></a>
                        <ul class="icons">
                            <li>
                                <a href="#">
                                    <span class="label">User Name</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label">User Foto</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label">Sair</span>
                                </a>
                            </li>
                        </ul>
                    </header>

                    <!-- Content -->
                    <section>
                        <form id="venda-form" action="${pageContext.request.contextPath}/Relatorio" method="post">

                            <header class="main">
                                <h1>Relatório</h1>
                            </header>

                            <fmt:setLocale value="pt-BR"></fmt:setLocale>
                                <label for="dtIni">Data Inicio</label>
                                <input type="date" name="dataInicial" id="dataInicial">
                                <label for="dtFim">Data Fim</label>
                                <input type="date" name="dataFinal" id="dataFinal">
                                <input type="submit" name="gerar" id="gerar" value="Gerar Relatório">
                            </form>

                            <h2>Relatório de Vendas</h2>

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
            <div id="sidebar">
                <div class="inner">

                    <!-- Search -->
                    <section id="topSidBar" class="alt">
                        <img class="imgTopSB" src="img/logo_flor_vetorizada_03.png" />
                    </section>

                    <!-- Menu -->
                    <nav id="menu">
                        <header class="major">
                            <h2>Menu</h2>
                        </header>
                        <ul>
                            <li>
                                <a href="index.html">Homepage</a>
                            </li>
                            <!--										<li><a href="generic.html"></a></li>
                                <li><a href="elements.html">Elements</a></li>-->
                            <li>
                                <span class="opener">Vendas</span>
                                <ul>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/venda">Nova Venda</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/Relatorio">Relatório</a>
                                    </li>
                                    <li>
                                        <a href="#">Tempus Magna</a>
                                    </li>
                                    <li>
                                        <a href="#">Feugiat Veroeros</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Produto</span>
                                <ul>
                                    <li>
                                        <a href="#">Lorem Dolor</a>
                                    </li>
                                    <li>
                                        <a href="#">Ipsum Adipiscing</a>
                                    </li>
                                    <li>
                                        <a href="#">Tempus Magna</a>
                                    </li>
                                    <li>
                                        <a href="#">Feugiat Veroeros</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Cliente</span>
                                <ul>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ListarClientes">Consultar</a>
                                    </li>
                                    <li>
                                        <a href="#">Ipsum Adipiscing</a>
                                    </li>
                                    <li>
                                        <a href="#">Tempus Magna</a>
                                    </li>
                                    <li>
                                        <a href="#">Feugiat Veroeros</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </nav>

                    <!-- Footer -->
                    <footer id="footer">
                        <p class="copyright">&copy; Untitled. All rights reserved. Demo Images:
                            <a href="https://unsplash.com">Unsplash</a>. Design:
                            <a href="https://html5up.net">HTML5 UP</a>.</p>
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
