<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}"/>
<fmt:setBundle basename="login"/>

<html lang="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="assets/css/style.min.css">
</head>
<body class="Login splitted-page">
<div class="left">
    <form method="post" action="login" id="loginForm">

        <a class="goHome" href="index.jsp">
            <i class="fa-solid fa-arrow-left"></i>
        </a>

        <h1 class="decorated-big-title"><fmt:message key="label.title"/></h1>

        <div class="noAccount">
            <p><fmt:message key="label.noAccount"/></p>
            <a href="newcustomer"><fmt:message key="label.makeARequest"/></a>
        </div>

        <c:if test="${errors.get('account').length() > 0 }">
            <div class="error">${errors.get("account")}</div>
        </c:if>

        <input class="input" type="text" name="customerNumber" id="customerNumber"
               placeholder="<fmt:message key="label.clientNumber"/>"><br>

        <c:if test="${errors.get('customerNumber').length() > 0 }">
            <div class="error">${errors.get("customerNumber")}</div>
        </c:if>

        <input class="input" type="password" name="password" id="password"
               placeholder="<fmt:message key="label.password"/>" pla>

        <c:if test="${errors.get('password').length() > 0 }">
            <div class="error">${errors.get("password")}</div>
        </c:if>

        <div class="passReset">
            <a href="resetpassword"><fmt:message key="label.passwordForgoten"/></a>
        </div>
        <button class="submit button" type="submit" id="submit" value="">
            <fmt:message key="label.connect"/> <i class="fa-solid fa-arrow-right"></i>
        </button>
    </form>
</div>

<div class="right">
    <div class="card">
        <img class="cardIMG" id="cardIMG" src="assets/img/bg-right__Card.png">
    </div>
</div>
<%@include file="components/banners/cookies/index.html" %>
</body>
</html>
