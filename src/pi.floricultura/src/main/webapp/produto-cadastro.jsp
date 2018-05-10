<%-- 
    Document   : produto-cadastro
    Created on : 09/05/2018, 18:39:13
    Author     : Aline
--%>
<%@page import="com.senac.pi.floricultura.controllers.ServicoProduto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.senac.pi.floricultura.model.GerarCodigo"%>
<%@page import="com.senac.pi.floricultura.model.produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CADASTRO DE PRODUTOS </title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estiloProduto.css" media="all">
    </head>
    <body>
        <div class="form">
            <form>
                Nome: <input type="text" name="nome">
                Preço: <input type="number" placeholder="5.00" step="0.01" min=5 name="preco">
                Quantidade: <input type="number" name="quantidade" placeholder="00" step="1" min=0 size="5"><br><br>
                Tipo: <input type="radio" name="tipo" value="Flores"> Flores <input type="radio" name="tipoe" value="Ervas"> Ervas <input type="radio" name="tipoe" value="Outros"> Outros<br><br>
                Descrição: <input type="text" name="descricao" placeholder="(inclua descrição do produto"><br><br>
                <%
                    produto produto = new produto();
                    produto.setNome(request.getParameter("nome"));
                    produto.setTipo(request.getParameter("tipo"));
                    produto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                    produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                    produto.setDescricao(request.getParameter("descricao"));

                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-d");
                    Date data = new Date(System.currentTimeMillis());
                    String date = formato.format(data);
                    data = formato.parse(date);
                %>

                <input type="submit" value="cadastrar">
            </form>
        </div>
    </body>
</html>
