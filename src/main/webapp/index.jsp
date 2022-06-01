<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}"/>
<fmt:setBundle basename="home" />

<html lang="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}">
<head>
    <meta charset="UTF-8">
    <title>BankCo</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body class="Home basicPage">

<div class="wrapper">
    <header class="header">
        <nav class="navbar">
            <a class="logo" href="index.jsp"><img src="assets/img/logo.png"></a>
            <ul>
                <li>
                    <a href="about.html"><fmt:message key="navbar.link.about" /></a>
                </li>
                <li>
                    <a href="contact.jsp"><fmt:message key="navbar.link.contact" /></a>
                </li>
                <li>
                    <a class="button" href="login.jsp"><fmt:message key="navbar.link.signin" /> </a>
                </li>
            </ul>
        </nav>
    </header>

    <div class="left">
        <h1><fmt:message key="left.h1" /></h1>
        <p><fmt:message key="left.p" /></p>
        <a class="button" href="newcustomer"><fmt:message key="left.button" /> <i class="fa-solid fa-arrow-right"></i></a>
    </div>

    <div class="right">
        <img src="assets/img/Cards.png">
    </div>

    <div class="background-shape">

    </div>

</div>



</body>
</html>