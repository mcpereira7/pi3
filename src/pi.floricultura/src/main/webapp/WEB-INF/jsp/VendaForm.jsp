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