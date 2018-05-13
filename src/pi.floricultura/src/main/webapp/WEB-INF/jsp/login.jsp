<%-- 
Document   : login
Created on : 11/05/2018, 14:44:41
Author     : aayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
                    </header>

                    <!-- Content -->
                    <section class="main-login">
                        <div class="login-block">
                            <form action="${pageContext.request.contextPath}/login">
                                <div class="login-box-head">
                                    <p class="login-box-head-face">Umbrella Corp.</p>
                                    <p class="login-box-head-google">Floricultura</p>
                                </div>
                                <div class="login-box-content">
                                    <input type="text" name="user" placeholder="Username...">
                                    <input type="password" name="password" placeholder="Password...">
                                </div>
                                <div class="login-box-btn">
                                    <input type="submit" value="Logar">
                                </div>
                            </form>
                        </div>
                    </section>

                </div>
            </div>

        </div>

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
