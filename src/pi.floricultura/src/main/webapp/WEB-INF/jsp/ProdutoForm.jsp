<%-- 
    Document   : produto-cadastro
    Created on : 09/05/2018, 18:39:13
    Author     : Aline
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
                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Cadastro de Produto</strong>

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

                                <input type="submit" value="cadastrar">
                            </form>
                        </div>
                        <hr class="major" />


                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <%@include file="/sidebar.jsp" %>

        </div>

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>