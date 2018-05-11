<%-- 
    Document   : produto-cadastro
    Created on : 09/05/2018, 18:39:13
    Author     : Aline
--%>
<%@page import="com.senac.pi.floricultura.controllers.ServicoProduto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.senac.pi.floricultura.model.GerarCodigo"%>
<%@page import="com.senac.pi.floricultura.model.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
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
                        <a href="index.html" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
                        <ul class="icons">
                            <li><a href="#"><span class="label">User Name</span></a></li>
                            <li><a href="#"><span class="label">User Foto</span></a></li>
                            <li><a href="#"><span class="label">Sair</span></a></li>
                        </ul>
                    </header>

                    <!-- Content -->
                    <section>
                        <header class="main">
                            <h1>Corpo MSG</h1>
                        </header>

                        <hr class="major" />
                        <div class="form">
                            <form action="produto" method="post">
                                Nome: <input type="text" name="nome"><br>
                                Preço: <input type="number" placeholder="5.00" step="0.01" min=5 name="preco">
                                Quantidade: <input type="number" name="quantidade" placeholder="00" step="1" min=0 size="5"><br><br>
                                Tipo: <input type="radio" name="tipo" value="Flores"> Flores <input type="radio" name="tipoe" value="Ervas"> Ervas <input type="radio" name="tipoe" value="Outros"> Outros<br><br>
                                Descrição: <input type="text" name="descricao" placeholder="(inclua descrição do produto"><br><br>
                                
                                <!--%

                                %-->

                                <input type="submit" value="cadastrar">
                            </form>
                        </div>
                        <hr class="major" />


                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">

                    <!-- Search -->
                    <section id="topSidBar" class="alt">
                        <img class="imgTopSB" src="img/logo_flor_vetorizada_03.png"/>
                    </section>

                    <!-- Menu -->
                    <nav id="menu">
                        <header class="major">
                            <h2>Menu</h2>
                        </header>
                        <ul>
                            <li><a href="index.html">Homepage</a></li>
                            <li>
                                <span class="opener">Vendas</span>
                                <ul>
                                    <li><a href="#">Lorem Dolor</a></li>
                                    <li><a href="#">Ipsum Adipiscing</a></li>
                                    <li><a href="#">Tempus Magna</a></li>
                                    <li><a href="#">Feugiat Veroeros</a></li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Produto</span>
                                <ul>
                                    <li><a href="#">Lorem Dolor</a></li>
                                    <li><a href="#">Ipsum Adipiscing</a></li>
                                    <li><a href="#">Tempus Magna</a></li>
                                    <li><a href="#">Feugiat Veroeros</a></li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Cliente</span>
                                <ul>
                                    <li><a href="/pi.floricultura/ListarClientes">Consultar</a></li>
                                    <li><a href="#">Ipsum Adipiscing</a></li>
                                    <li><a href="#">Tempus Magna</a></li>
                                    <li><a href="#">Feugiat Veroeros</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>

                    <footer id="footer">
                        <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
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