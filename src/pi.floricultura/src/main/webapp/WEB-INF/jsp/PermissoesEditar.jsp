<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                        <h4 class="logo"><strong>Editar Permissões</strong></h4>
                        <ul class="icons">
                            <li><a href="#"><span class="label">User Name</span></a></li>
                            <li><a href="#"><span class="label">User Foto</span></a></li>
                            <li><a href="#"><span class="label">Sair</span></a></li>
                            <!--										<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                                                                                                            <li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>-->
                        </ul>
                    </header>

                    <!-- Content -->
                    <section>
                        <h4>${ApplicationErro}</h4>
                        <form action="${pageContext.request.contextPath}/PermissoesEditar" method="POST">
                            <input type="text" name="nomeGrupo" value="${sessionScope.grupoEditar.nome}" required/>
                            <table>
                                <thead>
                                    <tr>
                                        <td><strong>Nome</strong></td>
                                        <td><strong>Caminho</strong></td>
                                        <td><strong>Excluir</strong></td>
                                    </tr>
                                </thead>
                                <c:forEach items = "${sessionScope.grupoEditar.listaTelas}" var = "listaTelas">
                                    <tr>
                                        <td>${listaTelas.nome}</td>
                                        <td>${listaTelas.caminho}</td>
                                        <td> <input class = "checktable" type="checkbox" name="excluir" value="${listaTelas.id}"/> </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <div id="telaDiv">

                            </div>
                            <br>
                            <input type="button" value="Adicionar Tela" onclick="addSelect('telaDiv')">
                            <hr>
                            <div style= "text-align: right">
                                <input type="submit" value="Salvar Alterações" name="salvarGrupo" />
                            </div>
                        </form>
                    </section>

                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">

                    <!-- Search -->
                    <section id="topSidBar" class="alt">
                        <img class="imgTopSB" src="img/logo_flor_vetorizada.png"/>
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
                                    <li><a href="${pageContext.request.contextPath}/ListarClientes">Consultar</a></li>
                                    <li><a href="#">Ipsum Adipiscing</a></li>
                                    <li><a href="#">Tempus Magna</a></li>
                                    <li><a href="#">Feugiat Veroeros</a></li>
                                </ul>
                            </li>
                            <li>
                                <span class="opener">Permissões</span>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/ListarPermissoes">Gerenciar</a></li>
                                    <li><a href="#">Ipsum Adipiscing</a></li>
                                    <li><a href="#">Tempus Magna</a></li>
                                    <li><a href="#">Feugiat Veroeros</a></li>
                                </ul>
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
        <script>
            var lista = [];
            <c:forEach items = "${listaTelas}" var = "tela">
                var objeto = {
                    id: ${tela.id},
                    nome: "${tela.nome}",
                    caminho: "${tela.caminho}"
                };
                lista.push(objeto);
            </c:forEach>

            function addSelect(divName) {

                var newDiv = document.createElement('div');

                var br = document.createElement("br");
                newDiv.appendChild(br);

                var texto = document.createElement("label");
                texto.innerHTML = "Tela";
                newDiv.appendChild(texto);

                var selectList = document.createElement("select");
                selectList.name = "tela";
                selectList.id = "tela";
                newDiv.appendChild(selectList);

                for (var i = 0; i < lista.length; i++) {
                    var option = document.createElement("option");
                    option.value = lista[i].id;
                    option.text = lista[i].nome;
                    selectList.appendChild(option);
                }

                //newDiv.innerHTML += "</br>";


                document.getElementById(divName).appendChild(newDiv);

            }
        </script>
    </body>
</html>
