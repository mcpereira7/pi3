<!DOCTYPE HTML>
<!--
    Editorial by HTML5 UP
    html5up.net | @ajlkn
    Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

    <head>
        <title>PaginaPrincial</title>
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
                    <section class="login-main">
                        <div class="login-block">
                            <form action="${pageContext.request.contextPath}/login" method="POST">
                                <div class="login-box-head">
                                    <p class="login-box-head-face">Aztec Company</p>
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