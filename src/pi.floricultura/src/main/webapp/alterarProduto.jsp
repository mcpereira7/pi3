<%-- 
    Document   : alterarProduto
    Created on : 10/05/2018, 16:03:52
    Author     : Red
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.senac.pi.floricultura.model.Produto"%>
<%@page import="com.senac.pi.floricultura.controllers.ServicoProduto"%>
<%@page import="java.util.Date"%>
<link rel="stylesheet" type="text/css" href="css/estilo1.css" media="all">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
        <div>
            <form action="/search" method="get"> <!-- formulário de procura-->
                <input type="text" name="procura" value="{SearchQuery"/>
                
                <!--%
                    Produto produto = new Produto();
                    produto.setNome(request.getParameter("nome"));
                    produto.setTipo(request.getParameter("tipo"));
                    produto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                    produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                    produto.setDescricao(request.getParameter("descricao"));
                %-->

                <input type="submit" value="procurar">
            </form>
        </div>
    </body>
</html>
