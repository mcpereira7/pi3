<%-- 
    Document   : index
    Created on : May 5, 2018, 12:42:46 PM
    Author     : andred
    --%>
<!--
    Editorial by HTML5 UP
    html5up.net | @ajlkn
    Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>

<head>
    <title>PaginaPrincial</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="css/main.css" />
    <script>
        function includeHTML() {
            var z, i, elmnt, file, xhttp;
            /*loop through a collection of all HTML elements:*/
            z = document.getElementsByTagName("*");
            for (i = 0; i < z.length; i++) {
                elmnt = z[i];
                /*search for elements with a certain atrribute:*/
                file = elmnt.getAttribute("include-html");
                if (file) {
                    /*make an HTTP request using the attribute value as the file name:*/
                    xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4) {
                            if (this.status == 200) {
                                elmnt.innerHTML = this.responseText;
                            }
                            if (this.status == 404) {
                                elmnt.innerHTML = "Page not found.";
                            }
                            /*remove the attribute, and call this function once more:*/
                            elmnt.removeAttribute("include-html");
                            includeHTML();
                        }
                    }
                    xhttp.open("GET", file, true);
                    xhttp.send();
                    /*exit the function:*/
                    return;
                }
            }
        }
        ;
    </script>
</head>

<body>

    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Main -->
        <div id="main">
            <div class="inner">

                <!-- Header -->
                <header id="header">
                    <a href="index.html" class="logo">
                        <strong>Editorial</strong> by HTML5 UP</a>
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
                        <header class="main">
                            <h1>Umbrella Corp.</h1>
                        </header>

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
                    </div>
                    <ul class="actions">
                        <!--<li><a href="#" class="button">More</a></li>-->
                    </ul>
                </section>

                <!-- Footer -->
                <footer id="footer">
                    <p class="copyright">&copy; Untitled. All rights reserved. Demo Images:
                        <a href="https://unsplash.com">Unsplash</a>. Design:
                        <a href="https://html5up.net">HTML5 UP</a>.
                    </p>
                </footer>


            </div>

        </div>

        <!--<div data-ng-include="sidebar.html"></div>-->
        <!-- <div id="sidebar" include-html="sidebar.html"></div> -->
        <!-- <iframe src="sidebar.html" frameborder="0"></iframe> -->
        <!-- <div class="sidebar-content" id="sidebar"></div> -->

    </div>

    <!-- Scripts -->
    <!-- <script>includeHTML();</script> -->
    <script src="js/jquery.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/util.js"></script>
    <script src="js/main.js"></script>

</body>

</html>