<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 4/22/22
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="login" />

<html lang="${sessionScope.lang}">
<head>
    <title>Connexion</title>
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="assets/css/style.min.css">
</head>
<body class="Login">

<div class="left">
    <form method="post" action="login" id="loginForm">
        <a class="goHome" href="./">
            <i class="fa-solid fa-arrow-left"></i>
        </a>
        <p>LANG : ${sessionScope.lang}</p>
<%--        <h1>Accéder à <br> mon espace</h1>--%>
        <h1><fmt:message key="label.title" /></h1>

        <div class="noAccount">
            <p>Pas de compte ? </p>
            <a href="newcustomer">Faites une demande</a>
        </div>

        <c:if test="${errors.get('account').length() > 0 }">
            <div class="error">${errors.get("account")}</div>
        </c:if>

        <input class="input" type="text" name="customerNumber" id="customerNumber" placeholder="Numero client"><br>

        <c:if test="${errors.get('customerNumber').length() > 0 }">
            <div class="error">${errors.get("customerNumber")}</div>
        </c:if>

        <input class="input" type="password" name="password" id="password" placeholder="Mot de passe" pla>

        <c:if test="${errors.get('password').length() > 0 }">
            <div class="error">${errors.get("password")}</div>
        </c:if>

        <div class="passReset">
            <a href="resetpassword">Mot de passe oublié ?</a>
        </div>
        <button class="submit button" type="submit" id="submit" value="">
            Se connecter <i class="fa-solid fa-arrow-right"></i></i>
        </button>
    </form>
</div>

<div class="right">
    <div class="card">
        <img class="cardIMG" id="cardIMG" src="assets/img/bg-right__Card.png">
<%--        <img class="cardShadow" src="assets/img/Card%20shadow.png">--%>
    </div>
</div>

</body>
</html>
