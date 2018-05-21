<%-- 
    Document   : CadastroUsuario
    Created on : 21/05/2018, 13:12:03
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

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
                    

<meta charset="utf-8" />
<!-- Header -->
<header id="header">
    <a href="" class="logo">
        <strong>Olá</strong> </a>
    <ul class="icons">
        <li>
            <a href="#">
                <span class="label"></span>
            </a>
        </li>
        <li>
            <a href="#">
                <span class="label">User Foto</span>
            </a>
        </li>
        <li>
            <a href="/floricultura/logout">
                <span class="label">Sair</span>
            </a>
        </li>
    </ul>

</header>
                    <strong class="page-name">Funcao da Pagina</strong>

                    <!-- Content -->
                    <section>
                        <header class="main">
                            <!--<h1>Consulta Clientes</h1>-->
                        </header>
                        <!-- Search -->
                        <section>
                            
                        </section>

                        <hr class="major" />


                        <!--%
                            List<PessoaFisica> listPessoa = ServicoCliente.listarClientes();
                        %-->
                       
                        <hr class="major" />


                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            

<meta charset="utf-8" />
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
                    <a href="/floricultura/home">Homepage</a>
                </li>
                <li>
                    <span class="opener">Vendas</span>
                    <ul>
                        <li>
                            <a href="/floricultura/venda">Nova Venda </a>
                        </li>
                        <li>
                            <a href="/floricultura/Relatorio">Relatorio</a>
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
                            <form action="/floricultura/listarprodutos" method="GET">
                                <input type="text" name="consulta" id="consulta" placeholder="Nome do produto..." maxlength="40">
                                <input type="hidden" alt="submit">
                            </form>
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
                <p class="copyright">&copy;
                    Untitled. All rights reserved.
                    Demo Images: <a href="https://unsplash.com">Unsplash</a>.
                    Design: <a href="https://html5up.net">HTML5 UP</a>.
                </p>
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

