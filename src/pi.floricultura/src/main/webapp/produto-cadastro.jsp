<%-- 
    Document   : produto-cadastro
    Created on : 09/05/2018, 18:39:13
    Author     : Aline
--%>
<%@page import="pi3."%>
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
                <input type="submit" value="cadastrar">
            </form>
        </div>    </body>
</html>
