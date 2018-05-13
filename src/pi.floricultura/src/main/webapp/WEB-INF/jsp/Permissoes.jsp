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
                        <h4 class="logo"><strong>Lista de Permissões</strong></h4>
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

                        <c:forEach items = "${listaPermissoes}" var = "grupoPermissao">
                            <h2>${grupoPermissao.nome}</h2>

                            <table>
                                <thead>
                                    <tr>
                                        <td><strong>Nome</strong></td>
                                        <td><strong>Caminho</strong></td>
                                    </tr>
                                </thead>

                                <c:forEach items = "${grupoPermissao.listaTelas}" var = "listaTelas">
                                    <tr>
                                        <td>${listaTelas.nome}</td>
                                        <td>${listaTelas.caminho}</td>
                                    </tr>
                                </c:forEach>
                            </table>

                            <div style = "text-align: right">
                                <form style="float: right; margin-left: 15px" action="${pageContext.request.contextPath}/PermissoesExcluir" method="POST">
                                    <input type="submit" value="Excluir Grupo" name="excluirGrupo" />
                                </form>
                                <form action="${pageContext.request.contextPath}/PermissoesEditar" method="POST">
                                    <input type="submit" value="Editar Grupo" name="editarGrupo" />
                                </form>

                            </div>
                            <hr>
                        </c:forEach>
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
        <script src="js/permissoes.js"></script>
    </body>
</html>
