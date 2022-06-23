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
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>
    <!--<div class="left">
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
    </div>-->


    <div class="page login-page">
        <div class="login-block login-left">
            <div class="l-constrained">
                <div class="btn-header">
                    <a href="index.jsp">
                        <i class="fa-solid fa-arrow-left"></i>
                    </a>
                </div>

                <h1 data-aos="fade-left">Accéder à mon espace</h1>
                <form action="" id="login-form">
                    <div class="field">
                        <input type="email" placeholder="Adresse e-mail" name="email" data-aos="fade-left" data-aos-delay="150">
                        <div class="line"></div>
                    </div>

                    <div class="field">
                        <input type="password" class="password-field" name="password" placeholder="Mot de passe" data-aos="fade-left" data-aos-delay="300">
                        <div class="line"></div>
                    </div>
                    <a data-aos="fade-left" data-aos-delay="450" class="forgot-password" href="resetpassword.jsp">Mot de passe oublié ?</a>
                    <button data-aos="fade-left" data-aos-delay="600" class="button btn-primary login-submit">Se connecter</button>
                </form>
            </div>
        </div>
        <div class="login-block login-right">
            <div class="l-constrained">
                <img class="credit-card" src="assets/img/signin-card.png" alt="carte de crédit">
                <img class="credit-card-shadow" src="assets/img/signin-card-shadow.png" alt="ombre">
            </div>
        </div>
    </div>
</body>
</html>
