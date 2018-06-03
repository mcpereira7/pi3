<%-- 
    Document   : header
    Created on : 13/05/2018, 00:17:01
    Author     : aayan
--%>

<meta charset="utf-8" />
<!-- Header -->
<header id="header">
    <a href="" class="logo">
        <strong>Olá</strong> ${sessionScope.user}</a>
    <ul class="icons">
        <li>
            <a href="#">
                <span class="label">${sessionScope.user}</span>
            </a>
        </li>
        <li>
            <a href="#">
                <span class="label">User Foto</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout">
                <span class="label">Sair</span>
            </a>
        </li>
    </ul>

</header>