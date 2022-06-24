<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}"/>
<fmt:setBundle basename="home"/>

<html lang="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}">
<head>
    <meta charset="UTF-8">
    <title>BankCo</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>

    <%@include file="components/layouts/header.jsp"%>

    <div class="page home-page">
        <div class="home-block home-left">
            <div class="l-constrained">
                <h1><fmt:message key="left.h1"/></h1>
                <p><fmt:message key="left.p"/></p>
                <a href="newcustomer" class="button btn-primary">
                    <fmt:message key="left.button"/>
                    <i class="fa-solid fa-arrow-right"></i>
                </a>
            </div>
        </div>

        <div class="home-block home-right">
            <div class="l-constrained">
                <img src="assets/img/home-cards.png" alt="Cartes">
            </div>
        </div>
    </div>

</body>
</html>