<%-- 
Document   : VendaForm2
Created on : 09/05/2018, 18:43:47
Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>VendaForm2</title>
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
                        <strong>Nova Venda</strong></a>
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
                            
                            <!-- <header class="main">
                                <h2>Nova Venda</h2>
                            </header>
                            
                            <hr class="general" /> -->
                            
                            <h3>Cliente</h3>
                            <input type="text" placeholder="CPF do cliente..." name="cliente" id="cliente">
                            <br>
                            <hr class="general" />
                            
                            <div id="vendaDiv">
                                <h4>Código Produto 1:</h4>
                                <input type="text" name="produto" id="produto1" />
                                <br> <h4>Quantidade:</h4>
                                <input type="number" min="0" name="quantidadeProduto" id="quantProduto1" style="width: 70% !important"/>
                                <br>
                                <br>
                            </div>
                            <input type="button" value="Novo produto" onclick="addInputOnDiv('vendaDiv')">
                            <input type="submit" value="Salvar" />
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
                <script>
                    var count = 1;
                    var limit = 10;
                    function addInputOnDiv(divName) {
                        
                        if (count === limit) {
                            alert("Limite teste : " + count);
                        } else {
                            
                            var newDiv = document.createElement('div');
                            
                            var styleProductName = "";
                            var styleProductQuantit = " style= 'width:70% !important'";
                            var styleProductRemoveButton = " style= 'height: 2.5em; line-height: 2.5em;'";
                            var inputProdutoCodigo = "<hr class='general'/><br><h4>Código Produto " + (count + 1) + ":</h4><input type='text' name='produto' id='produto" + (count + 1) + "' />";
                            var inputProdutoQuantidade = " <h4>Quantidade: </h4><input type='number' min='0' name='quantidadeProduto' id='quantProduto" + (count + 1) + "' "+ styleProductQuantit +"/>";
                            var buttonToRemoveThisDiv = "&nbsp&nbsp<input onclick='removeInputProduct(this)' type='button' value='-' "+ styleProductRemoveButton +" /><br>";
                            
                            newDiv.innerHTML = inputProdutoCodigo + inputProdutoQuantidade + buttonToRemoveThisDiv;
                            
                            document.getElementById(divName).appendChild(newDiv);
                            
                            count++;
                        }
                    }
                    
                    function removeInputProduct(input) {
                        
                        input.parentNode.parentNode.removeChild(input.parentNode);
                        
                        count--;
                    }
                    
                </script>
                
            </body>
            
            </html>