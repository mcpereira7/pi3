<%-- 
    Document   : index
    Created on : May 5, 2018, 12:42:46 PM
    Author     : andred
--%>
<!--
    Editorial by HTML5 UP
    html5up.net | @ajlkn
    Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE JSP>

<html>

    <head>
        <title>HomePage</title>
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

                    <%@include file="/header.jsp" %>
                    <strong class="page-name">Funcao da Pagina</strong>

                    <!-- Content -->
                    <section>
                        <header class="main">
                            <h2>Umbrella Corp.</h2>
                        </header>

                    </section>

                </div>
            </div>

            <%@include file="/sidebar.jsp" %>

        </div>

        <!-- Scripts -->
        <!-- <script>includeHTML();</script> -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>