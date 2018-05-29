<%-- 
Document   : cardNovo
Created on : 28/05/2018, 09:48:26
Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Novo Card</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
        <script src="js/jquery.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>

        <!--Navigation bar-->
        <%@include file="/navbar.jsp" %>

        <!-- Main -->
        <div class="main">

            <!-- Content -->
            <div class="content">

                <div class="tab">
                    <button class="tablinks" onclick="openCardType(event, 'simples')" id="defaultOpen">Texto</button>
                    <button class="tablinks" onclick="openCardType(event, 'video')">Video</button>
                    <button class="tablinks" onclick="openCardType(event, 'imagem')">Imagem</button>
                    <button class="tablinks" onclick="openCardType(event, 'board')">Board</button>
                </div>

                <div id="simples" class="tabcontent">
                    <h3>London</h3>
                    <p>London is the capital city of England.</p>
                </div>

                <div id="video" class="tabcontent">
                    <h3>Paris</h3>
                    <p>Paris is the capital of France.</p> 
                </div>

                <div id="imagem" class="tabcontent">
                    <h3>Tokyo</h3>
                    <p>Tokyo is the capital of Japan.</p>
                </div>

                <div id="board" class="tabcontent">
                    <h3>Tokyo</h3>
                    <p>Tokyo is the capital of Japan.</p>
                </div>

            </div>

        </div>

        <script>
            // Get the element with id="defaultOpen" and click on it
            document.getElementById("defaultOpen").click();
        </script>
    </body>
</html>
