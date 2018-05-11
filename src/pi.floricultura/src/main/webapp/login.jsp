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
    <script>
        function includeHTML() {
            var z, i, elmnt, file, xhttp;
            /*loop through a collection of all HTML elements:*/
            z = document.getElementsByTagName("*");
            for (i = 0; i < z.length; i++) {
                elmnt = z[i];
                /*search for elements with a certain atrribute:*/
                file = elmnt.getAttribute("include-html");
                if (file) {
                    /*make an HTTP request using the attribute value as the file name:*/
                    xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4) {
                            if (this.status == 200) {
                                elmnt.innerHTML = this.responseText;
                            }
                            if (this.status == 404) {
                                elmnt.innerHTML = "Page not found.";
                            }
                            /*remove the attribute, and call this function once more:*/
                            elmnt.removeAttribute("include-html");
                            includeHTML();
                        }
                    }
                    xhttp.open("GET", file, true);
                    xhttp.send();
                    /*exit the function:*/
                    return;
                }
            }
        }
        ;
    </script>
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
                        <form action="${pageContext.request.contextPath}/Login">
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
    <!-- <script>includeHTML();</script> -->
    <script src="js/jquery.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/util.js"></script>
    <script src="js/main.js"></script>
    
</body>
</html>
