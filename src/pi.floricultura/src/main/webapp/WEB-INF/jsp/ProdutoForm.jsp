<%-- 
Document   : produto-cadastro
Created on : 09/05/2018, 18:39:13
Author     : Aline
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <%@include file="/header.jsp" %>
                <strong class="page-name">Cadastro de Produto</strong>
                
                <!-- Content -->
                <section>
                    
                    <div class="produto-form">
                        <form action="${pageContext.request.contextPath}/produto" method="post">
                            Nome:
                            <input type="text" name="nome" id="nome" placeholder="Nome do produto..." maxlength="100">
                            <hr class="general"/>
                            
                            <div class="produto-info">
                                Preço:<input type="number" placeholder="5.00" step="0.01" min=5 name="preco" maxlength="10"/>
                                <br><br>
                                Quantidade:<input type="number" name="quantidade" placeholder="00" step="1" min=0/ maxlength="10">
                            </div>
                            <div class="produto-tipo">
                                Tipo:&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="tipo" id="indefinido" value="0"><label for="indefinido">Indefinido</label>
                                <input type="radio" name="tipo" id="flor" value="1"><label for="flor">Flor</label>
                                <input type="radio" name="tipo" id="planta" value="2"><label for="planta">Planta</label>
                                <input type="radio" name="tipo" id="rosa" value="3"><label for="rosa">Rosa</label>
                                <input type="radio" name="tipo" id="ilicita" value="4"><label for="ilicita">Ilícita</label>
                            </div>
                            <div>
                                Descrição: <br>
                                <textarea name="descricao" placeholder="Descrição do produto..." cols="30" rows="3" col></textarea>
                            </div>
                            <input type="submit" value="Cadastrar">
                        </form>
                    </div>
                    
                </section>
                
            </div>
        </div>
        
        <!-- Sidebar -->
        <%@include file="/sidebar.jsp" %>
        
    </div>
    
    <!-- Scripts -->
    <script src="js/jquery.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/util.js"></script>
    <script src="js/main.js"></script>
    
</body>
</html>