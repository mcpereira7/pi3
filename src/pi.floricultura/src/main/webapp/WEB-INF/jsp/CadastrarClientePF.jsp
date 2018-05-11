<%-- 
Document   : CadastrarClientePF
Created on : 18/04/2018, 11:06:44
Author     : Marcelo Pereira
--%>

<%@page import="com.senac.pi.floricultura.controllers.ServicoCliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.senac.pi.floricultura.model.GerarCodigo"%>
<%@page import="com.senac.pi.floricultura.model.PessoaFisica"%>
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
                        <a href="index.html" class="logo"><strong>Cadastro Cliente</strong></a>
                        <ul class="icons">
                            <li><a href="#"><span class="label">User Name</span></a></li>
                            <li><a href="#"><span class="label">User Foto</span></a></li>
                            <li><a href="#"><span class="label">Sair</span></a></li>
                        </ul>
                    </header>

                    <!-- Content -->
                    <section>
                        <header class="main">
                        </header>

                        <form action="cadastrarCliente" method="POST">
                            <div class="dadosPessoais">
                                <label for="Nome">Nome:</label> 
                                <input type="text" name="nome" id="Nome">

                                <label for="apelido">Apelido:</label>
                                <input type="text" name="apelido" id="apelido">

                                <label for="cpf">CPF:</label>
                                <input type="text" name="cpf" id="cpf">

                                <label for="rg">RG: </label>
                                <input type="text" name="rg" id="rg">

                                <label for="dtNasc">Data Nasc:</label>
                                <input type="date" name="dtNasc" id="dtNasc">

                                <label>Sexo</label>
                                <label class="checkbox">
                                    <input type="radio" name="sexo" value="masculino"> Masculino
                                    <input type="radio" name="sexo" value="feminino"> Feminino
                                    <input type="radio" name="sexo" value="Outro"> Outro
                                </label>
                            </div>
                            <div class="contato">
                                <label for="email">E-mail:</label>
                                <input type="email" name="email" id="email">

                                <label for="tel">Telefone:</label>
                                <input type="tel" name="tel" id="tel">

                                <label for="cel">Celular:</label>
                                <input type="tel" name="cel" id="cel">
                            </div>
                            <div class="endereco">
                                <h3>Endereço</h3>

                                <label for="log">Logradouro:</label>
                                <input type="text" name="log" id="log">

                                <label for="num">Numero:</label>
                                <input type="text" name="numero" id="num">

                                <label for="comp">Complementeo:</label>
                                <input type="text" name="comp" id="comp">

                                <label for="bairro">Bairo:</label> 
                                <input type="text" name="bairro" id="bairro">

                                <label for="cid">Cidade:</label> 
                                <input type="text" id="cid" name="cid">

                                <label for="cep">CEP:</label> 
                                <input type="text" name="cep" id="cep">

                                <label for="uf">UF:</label>
                                <input type="text" id="uf" name="uf">
                            </div>

                            <input type="submit" name="btCadastrar" id="btCadastrar" value="Cadastrar">
                        </form>									<hr class="major" />

                        <hr class="major" />


                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">

                    <!-- Search -->
                    <section id="topSidBar" class="alt">
                        <img class="imgTopSB" src="img/bck_girassol_01.jpg"/>
                    </section>

                    <!-- Menu -->
                    <nav id="menu">
                        <header class="major">
                            <h2>Menu</h2>
                        </header>
                        <ul>
                            <li><a href="index.html">Homepage</a></li>
                            <!--										<li><a href="generic.html"></a></li>
                                                                                                            <li><a href="elements.html">Elements</a></li>-->
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
                                    <li><a href="/floricultura/ListarClientes">Consultar</a></li>
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
                            </li>
                        </ul>
                    </nav>

                    <!-- Footer -->
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
