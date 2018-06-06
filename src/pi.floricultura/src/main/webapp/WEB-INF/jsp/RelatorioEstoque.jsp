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

                        <h2>Relatório de Estoque</h2>

                        <form id="relatorio-estoque" action="${pageContext.request.contextPath}/RelatorioEstoque" method="POST">

                            <label for="listaFilial">Filiais</label>
                            <select id ="listaFilial" name="listaFilial">
                                <c:forEach items = "${listaFiliais}" var = "filial">
                                    <option value="${filial.id}">${filial.nome}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="Gerar Relatório" name ="gerarRelatorio">
                        </form>

                        <c:forEach items = "${listaFiliais}" var = "filial">
                            <h2>${filial.nome}</h2>
                            <table>
                                <theader>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Quantidade no Estoque</th>
                                        <th>Preço</th>
                                    </tr>
                                </theader>

                                <c:forEach items = "${listaEstoqueProduto}" var = "produto">
                                    <c:if test="${filial.id_pessoa == venda.id_pessoa}">
                                        <tr>
                                            <td><c:out value="${produto.id}"/></td>
                                            <td><c:out value="${produto.nome}"/></td>
                                            <td><c:out value="${produto.quantidadeEstoque}"/></td>
                                            <td><fmt:formatNumber value="${produto.preco}" type="currency" /></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                            </table>
                        </c:forEach>
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
                                <span class="opener">Produto</span>
                                <ul>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/produto">Novo Produto</a>
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