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

                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Nova Venda</strong>

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

            <%@include file="/sidebar.jsp" %>

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
                                        var inputProdutoQuantidade = " <h4>Quantidade: </h4><input type='number' min='0' name='quantidadeProduto' id='quantProduto" + (count + 1) + "' " + styleProductQuantit + "/>";
                                        var buttonToRemoveThisDiv = "&nbsp&nbsp<input onclick='removeInputProduct(this)' type='button' value='-' " + styleProductRemoveButton + " /><br>";

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