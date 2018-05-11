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
                        <form id="venda-form" action="${pageContext.request.contextPath}/venda-conclusion" method="GET">

                            <header class="main">
                                <h1>Venda</h1>
                            </header>
                            <fmt:setLocale value="pt-BR"></fmt:setLocale>
                                <hr class="major" />

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
                                    Produto: <c:out value="${item.codigoProduto}" /> / 
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
            <div id="sidebar">
                <div class="inner">

                    <!-- Search -->
                    <section id="topSidBar" class="alt">
                        <img class="imgTopSB" src="img/bck_girassol_01.jpg" />
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
                        <li>
                            <span class="opener">Vendas</span>
                            <ul>
                                <li>
                                    <a href="/floricultura/venda">Nova Venda </a>
                                </li>
                                <li>
                                   <a href="/floricultura/Relatorio">Relatório</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span class="opener">Permissoes</span>
                            <ul>
                                <li>
                                    <a href="/floricultura/PermissoesCadastrar">Cadastrar</a>
                                </li>
                                <li>
                                   <a href="/floricultura/PermissoesListar">Consultar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span class="opener">Produto</span>
                            <ul>
                                <li>
                                    <a href="/floricultura/produto">Cadastrar Produto</a>
                                </li>
                                <li>
                                    <a href="/floricultura">Procurar Produtos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span class="opener">Cliente</span>
                            <ul>
                                <li>
                                    <a href="/floricultura/ListarClientes">Consultar</a></li>
                                    <li><a href="/floricultura/cadCli">Cadastro</a></li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Filiais</span>
                                <ul>
                                    <li><a href="/floricultura/CadastroFilial">Cadastrar</a></li>
                                    <li><a href="/floricultura/ListaFiliais">Unidades</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>

                    <!-- Section -->
                    <section>
                        <header class="major">
                            <!--<h2>Ante interdum</h2>-->
                        </header>
                        <div class="mini-posts">
<!--                            <article>
                                <a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
                                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
                            </article>
                            <article>
                                <a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
                                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
                            </article>
                            <article>
                                <a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
                                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
                            </article>-->
                        </div>
                        <ul class="actions">
                            <!--<li><a href="#" class="button">More</a></li>-->
                        </ul>
                    </section>

                    <!-- Section -->
                    <!--								<section>
                            <header class="major">
                                <h2>Get in touch</h2>
                            </header>
                            <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
                            <ul class="contact">
                                <li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
                                <li class="fa-phone">(000) 000-0000</li>
                                <li class="fa-home">1234 Somewhere Road #8254<br />
                                    Nashville, TN 00000-0000</li>
                                </ul>
                            </section>-->

                    <!-- Footer -->
                    <footer id="footer">
<!--                        <p class="copyright">&copy; Untitled. All rights reserved. Demo Images:
                            <a href="https://unsplash.com">Unsplash</a>. Design:
                            <a href="https://html5up.net">HTML5 UP</a>.</p>-->
                    </footer>


                </div>

            </div>

        </div>

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>