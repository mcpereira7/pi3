<%-- 
    Document   : VendaForm
    Created on : May 5, 2018, 1:16:12 PM
    Author     : andred
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda formulario</title>
    </head>
    <script type="text/javascript" language="Javascript">
        var count = 1;
        var limit = 10;
        function addInputOnDiv(divName) {

            if (count === limit) {
                alert("Limite teste : " + count);
            } else {

                var newDiv = document.createElement('div');

                newDiv.innerHTML = "Product " + (count + 1) + ": <input type='text' name='produto' id='produto" + (count + 1) + " '>\n\
    <input type='button' value='-' onclick='removeInput(this, 'vendaDiv')'><br>";

                document.getElementById(divName).appendChild(newDiv);

                count++;
            }
        }

        function removeInputProduct(input, divName) {

            document.getElementById(divName).removeChild(input.parentNode);

            count--;
        }

    </script>
    <body>
        <h1>Nova venda</h1>

        <form id="venda-form" action="${pageContext.request.contextPath}/create-venda" method="post">

            Client: <input type="text" name="cliente" id="cliente"><br>

            <div id="vendaDiv">
                Product 1: <input type="text" name="produto" id="produto"><br>
            </div>
            <input type="button" value="Novo produto" onclick="addInputOnDiv('vendaDiv')">
            <input type="submit" value="Salvar"/>


        </form>
    </body>
</html>
