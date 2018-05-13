<%-- 
    Document   : ListarClientes
    Created on : 17/04/2018, 15:56:08
    Author     : Marcelo Pereira
--%>

<%@page import="java.util.List"%>
<%@page import="com.senac.pi.floricultura.controllers.ServicoCliente"%>
<%@page import="com.senac.pi.floricultura.model.PessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <a href="" class="logo"><strong>Consulta</strong> Cliente</a>
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
                        <header class="main">
                            <!--<h1>Consulta Clientes</h1>-->
                        </header>
                        <!-- Search -->
                        <section id="search" class="alt">
                            <form method="POST" action="ConsultarCliente">
                                <input type="text" name="cpf" id="cpf" placeholder="CPF apenas números" />
                            </form>
                        </section>

                        <hr class="major" />


                        <!--%
                            List<PessoaFisica> listPessoa = ServicoCliente.listarClientes();
                        %-->
                        <table>
                            <theader>
                                <tr>
                                    <td>Nome</td>
                                    <td>E-mail</td>
                                    <td>Telefone</td>
                                    <td>Ação</td>
                                </tr>
                            </theader>

                            <!--%
                                for (PessoaFisica pf : listPessoa) {
                            %-->
                            <c:forEach var="cli" items="${listaCliPF}">
                                <tr>
                                    <td><c:out value="${cli.nome}"></c:out></td>
                                    <td><c:out value="${cli.email}"></c:out></td>
                                    <td><c:out value="${cli.telefone}"></c:out></td>
                                        <td id="btsAltExc">
                                            <form action="dadosCliente" method="POST" class="listCli">
                                                <input type="image" src="img/edit_icon.png" 
                                                       name="edit" value="${cli.id}"></form>
                                        <form action="excluirPessoa" method="POST" class="listCli">
                                            <input type="image" src="img/delete_icon.jpg"
                                                   name="excluir" value="${cli.id}"></form>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!--%
                                }
                            %-->

                        </table>


                        <hr class="major" />


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

    </body>
</html>
