<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Notes - Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
        <script src="js/jquery.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>

        <!--Navigation bar-->
        <%@include file="navbar.jsp" %>

        <div class="main-login">
            <div class="login-box">

                <div class="login-box-head">
                    <p class="login-box-head-face">Notes</p>
                </div>

                <form id="login-form" method="post">
                    <div class="login-box-content">
                        <input type="text" name="login" placeholder="Username...">
                        <input type="password" name="password" placeholder="Password...">
                    </div>
                    <div class="login-box-btn">
                        <a id="logar">Login</a>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>