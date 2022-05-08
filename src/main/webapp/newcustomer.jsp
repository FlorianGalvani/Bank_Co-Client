<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 4/19/22
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
    TODO Finir le style du formulaire de cette page ((wtf) step form ?)
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demande</title>
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">


</head>
<body class="NewCustomer formPage">
    <div class="left">

        <form method="post" action="newcustomer" enctype="multipart/form-data" class="newCustomerForm">
            <a class="goHome" href="./"><i class="ri-arrow-left-line"></i></a>
            <h1>Faire une demande d'ouverture de compte</h1>
            <div class="noAccount"><p>Déja un compte ? </p> <a href="login.jsp">Connectez vous</a></div>
            <select name="title" id="title">
                <option value="">Choix</option>
                <option value="mr">Monsieur</option>
                <option value="ms">Madame</option>
            </select>
            <c:if test="${errors.get('title').length() > 0 }">
                <div class="error">${errors.get("title")}</div>
            </c:if>

            <input class="input" type="text" placeholder="Prenom" name="firstname" id="firstname" value="${formData.get("firstname") ? formData.get("firstname") : ""}">
            <c:if test="${errors.get('firstname').length() > 0 }">
                <div class="error">${errors.get("firstname")}</div>
            </c:if>
            <input class="input" type="text" placeholder="Nom" name="lastname" id="lastname">
            <c:if test="${errors.get('lastname').length() > 0 }">
                <div class="error">${errors.get("lastname")}</div>
            </c:if>

            <input class="input" type="tel" placeholder="Telephone" name="phone" id="phone">
            <c:if test="${errors.get('phone').length() > 0 }">
                <div class="error">${errors.get("phone")}</div>
            </c:if>

            <input class="input" type="email" placeholder="Email" name="email" id="email">
            <c:if test="${errors.get('email').length() > 0 }">
                <div class="error">${errors.get("email")}</div>
            </c:if>

            <input class="input" type="date" placeholder="Date de naissance" name="birthdate" id="birthdate">
            <c:if test="${errors.get('birthdate').length() > 0 }">
                <div class="error">${errors.get("birthdate")}</div>
            </c:if>

            <input class="input" type="text" placeholder="Addresse de résidence" name="address" id="address">
            <c:if test="${errors.get('address').length() > 0 }">
                <div class="error">${errors.get("address")}</div>
            </c:if>

            <input class="input" type="text" placeholder="Ville" name="city" id="city">
            <c:if test="${errors.get('city').length() > 0 }">
                <div class="error">${errors.get("city")}</div>
            </c:if>

            <input class="input" type="text" placeholder="Code postal" name="postal" id="postal">
            <c:if test="${errors.get('postal').length() > 0 }">
                <div class="error">${errors.get("postal")}</div>
            </c:if>

            <select name="country" id="country">
                <option value="">Choix</option>
                <option value="fr">France</option>
                <option value="us">United State</option>
            </select>
            <c:if test="${errors.get('country').length() > 0 }">
                <div class="error">${errors.get("country")}</div>
            </c:if>


            <%-- TODO limité la taille max d'un fichier et son limité les types de formats --%>
            <input class="input" type="file" placeholder="Carte d'identité"  name="idCard" id="idCard">
            <c:if test="${errors.get('idCard').length() > 0 }">
                <div class="error">${errors.get("idCard")}</div>
            </c:if>
            <input type="submit" value="Envoyer">

        </form>
    </div>
    <div class="right">
        <img src="assets/img/signup.png" >
    </div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</html>
