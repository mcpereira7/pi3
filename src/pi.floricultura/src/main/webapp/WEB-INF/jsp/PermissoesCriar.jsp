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
                        <h4 class="logo"><strong>Cadastro de Permissões</strong></h4>
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
                        <form name="permissoesCriar" action="${pageContext.request.contextPath}/PermissoesCadastrar" method="POST">
                            <label>Nome do Grupo</label>
                            <input type="text" name="nomeGrupo" value=""/>
                            <div id="telaDiv">

                            </div>
                            <br>
                            <input type="button" value="Adicionar Tela" onclick="addSelect('telaDiv')">
                            <hr>
                            <div style="text-align: right">
                                <input type="submit" value="Cadastrar" name="cadastrar" />
                            </div>
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

