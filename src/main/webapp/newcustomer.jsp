<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 4/19/22
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%--TODO Faire le style de cette page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="assets/css/style.min.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">


</head>
<body class="NewCustomer formPage">
    <div class="left">
        <form method="post" action="newcustomer" enctype="multipart/form-data" class="newCustomerForm">
            <a class="goHome" href="./"><i class="ri-arrow-left-line"></i></a>
            <select name="title" id="title">
                <option value="">Choix</option>
                <option value="mr">Monsieur</option>
                <option value="ms">Madame</option>
            </select>
            <div class="error">${errors.get("title")}</div>

            <input class="input" type="text" placeholder="Prenom" name="firstname" id="firstname" value="${formData.get("firstname") ? formData.get("firstname") : ""}">
            <div class="error">${errors.get("firstname")}</div>

            <input class="input" type="text" placeholder="Nom" name="lastname" id="lastname">
            <div class="error">${errors.get("lastname")}</div>

            <input class="input" type="tel" placeholder="Telephone" name="phone" id="phone">
            <div class="error">${errors.get("phone")}</div>

            <input class="input" type="email" placeholder="Email" name="email" id="email">
            <div class="error">${errors.get("email")}</div>

            <input class="input" type="date" placeholder="Date de naissance" name="birthdate" id="birthdate">
            <div class="error">${errors.get("birthdate")}</div>

            <input class="input" type="text" placeholder="Addresse de résidence" name="address" id="address">
            <div class="error">${errors.get("address")}</div>

            <input class="input" type="text" placeholder="Ville" name="city" id="city">
            <div class="error">${errors.get("city")}</div>

            <input class="input" type="text" placeholder="Code postal" name="postal" id="postal">
            <div class="error">${errors.get("postal")}</div>

            <select name="country" id="country">
                <option value="">Choix</option>
                <option value="fr">France</option>
                <option value="us">United State</option>
            </select>
            <div class="error">${errors.get("country")}</div>

            <%-- TODO limité la taille max d'un fichier et son limité les types de formats --%>
            <input class="input" type="file" placeholder="Carte d'identité" accept="pdf, docx, doc, jpg, png, txt, rtf, jpeg, jpe, jif, jfif, gif, tif, tiff" name="idCard" id="idCard">
            <div class="error">${errors.get("idCard")}</div>
            <input type="submit" value="Envoyer">

        </form>
    </div>
    <div class="right">
        <img src="assets/img/signup.png" >
    </div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</html>
