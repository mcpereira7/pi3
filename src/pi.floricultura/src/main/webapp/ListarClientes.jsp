<%-- 
    Document   : ListarClientes
    Created on : 17/04/2018, 15:56:08
    Author     : Marcelo Pereira
--%>

<%@page import="java.util.List"%>
<%@page import="com.senac.pi.floricultura.controllers.ServicoCliente"%>
<%@page import="com.senac.pi.floricultura.model.PessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">

    </head>
    <body>
        <%
            List<PessoaFisica> istPessoa = ServicoCliente.listarClientes();
        %>
        <h1>Lista de clientes Cadastrados</h1>
        <table>
            <theader>
                <tr>
                    <td>Nome</td>
                    <td>E-mail</td>
                    <td>Telefone</td>
                </tr>
            </theader>
            <tbody>
                    <%
                        for (PessoaFisica pf : istPessoa) {
                    %>
                <tr>
                    <td><%=pf.getNome()%></td>
                    <td><%=pf.getEmail()%></td>
                    <td><%=pf.getTelefone()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
