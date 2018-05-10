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
                        <form id="venda-form" action="${pageContext.request.contextPath}/venda-conclusion" method="post">
                            
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
                                Produto: <c:out value="${item.idProduto}" /> / 
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
            
            <!-- Scripts -->
            <script src="js/jquery.min.js"></script>
            <script src="js/skel.min.js"></script>
            <script src="js/util.js"></script>
            <script src="js/main.js"></script>
            
        </body>
        
        </html>