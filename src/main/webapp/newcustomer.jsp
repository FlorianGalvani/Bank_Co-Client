<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 4/19/22
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <h1>Demande d'ouverture de compte</h1>
    <form method="post" action="newcustomer" enctype="multipart/form-data" class="newCustomerForm">

        <h2>Informations</h2>

        <label for="title">Civilité : </label>
        <select name="title" id="title">
            <option value="">Choix</option>
            <option value="mr">Monsieur</option>
            <option value="ms">Madame</option>
        </select>
        <div class="error">${errors.get("title")}</div>


        <label for="firstname">Prenom : </label>
        <input type="text" name="firstname" id="firstname" value="${formData.get("firstname") ? formData.get("firstname") : ""}">
        <div class="error">${errors.get("firstname")}</div>

        <label for="lastname">Nom : </label>
        <input type="text" name="lastname" id="lastname">
        <div class="error">${errors.get("lastname")}</div>

        <label for="phone">Telephone : </label>
        <input type="tel" name="phone" id="phone">
        <div class="error">${errors.get("phone")}</div>

        <label for="birthdate">Date de naissance : </label>
        <input type="date" name="birthdate" id="birthdate">
        <div class="error">${errors.get("birthdate")}</div>

        <label for="address">Adresse de résidence : </label>
        <input type="text" name="address" id="address">
        <div class="error">${errors.get("address")}</div>

        <label for="city">Ville : </label>
        <input type="text" name="city" id="city">
        <div class="error">${errors.get("city")}</div>

        <label for="postal">Code postal : </label>
        <input type="text" name="postal" id="postal">
        <div class="error">${errors.get("postal")}</div>

        <label for="country">Pays : </label>
        <select name="country" id="country">
            <option value="">Choix</option>
            <option value="fr">France</option>
            <option value="us">United State</option>
        </select>
        <div class="error">${errors.get("country")}</div>

        <h2>Documents</h2>
        <%-- TODO limité la taille max d'un fichier et son limité les types de formats --%>
        <label for="idCard">Carte d'intentité : </label>
        <input type="file" accept="pdf, docx, doc, jpg, png, txt, rtf, jpeg, jpe, jif, jfif, gif, tif, tiff" name="idCard" id="idCard">
        <div class="error">${errors.get("idCard")}</div>

        <input type="submit" value="Envoyer">

    </form>
</body>
<style>
    h1,h2 {
        text-align: center;
    }
    .newCustomerForm {
        width: 30%;
        padding: 10px 10px;
        margin: auto;
        background: blueviolet;
        display: flex;
        flex-direction: column;
    }
    .error {
        background: #f00;
        color: #fff;
    }
</style>
</html>
