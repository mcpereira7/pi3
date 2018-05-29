<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Navigation bar-->
<div class="navbar">

    <c:choose>
        <c:when test="${sessionScope.usuario == null}">
            <div class="navlogo">
                <a href="/poonotes/">
                    <img src="img\note.svg">
                </a>
            </div>

            <div class="nav-buttons">
                <a class="btn-login" href="/poonotes/login">Fazer Login</a>
                <a class="btn-singup" href="/poonotes/signup">Cadastre-se</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="navlogo">
                <a href="/poonotes/home">
                    <img src="img\note.svg">
                </a>
            </div>

            <div class="navmiddle">
                ${board.titulo}
            </div>

            <div class="nav-buttons">
                <a class="btn-add" href="/poonotes/novo">+</a>
                <a class="btn-login">${sessionScope.usuario.login}</a>
                <a class="btn-singup" href="/poonotes/logout">Logout</a>
            </div>
        </c:otherwise>
    </c:choose>

</div>