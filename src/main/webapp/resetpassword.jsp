<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}"/>
<fmt:setBundle basename="resetpassword"/>

<html lang="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}">
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>
    <div class="page resetpass-page">
        <h1>Réinitialiser votre mot de passe</h1>
        <form method="post" action="./resetpassword">

            <div class="field">
                <input type="text" placeholder="N° Client">
                <div class="line"></div>
            </div>

            <div class="field">
                <input type="text" placeholder="Adresse mail">
                <div class="line"></div>
            </div>

            <input type="submit" value="Envoyer">
        </form>
    </div>
</body>
</html>
