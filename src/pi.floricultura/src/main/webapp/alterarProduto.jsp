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
        <div class="table">
            <form>
                Nome: <input readonly name="nome" value="${produto.getNome()}">
                Preço: <input type="number" step="0.01" min=5 name="preco" value="${produto.getPreco()}">
                Quantidade: <input type="number" name="quantidade" step="1" min=0 size="5" value="${produto.getQuantidadeEstoque()}"><br><br>
                Tipo: <input type="radio" name="tipo" value="Flores"> Flores <input type="radio" name="tipoe" value="Ervas"> Ervas <input type="radio" name="tipoe" value="Outros"> Outros<br><br>
                Descrição: <input type="text" name="descricao" value="${produto.getDescricao()}"><br><br>
                <!--%
                    Produto produto = new Produto();
                    produto.setNome(request.getParameter("nome"));
                    produto.setTipo(request.getParameter("tipo"));
                    produto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                    produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                    produto.setDescricao(request.getParameter("descricao"));
                %-->

                <input type="submit" value="cadastrar">
            </form>
        </div>
    </body>
</html>
