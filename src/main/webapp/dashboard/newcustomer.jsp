<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/8/22
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Customer</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.min.css">
</head>
<body class="NewCustomer formPage">
  <h1>Bienvenue</h1>

<!--
    TODO Ajouter un tutorial/une explication rapide du service + la modification du mot de passe temporaire
-->

    <form method="post" action="changePassword">
        <input type="password" name="currentPassword">
        <input type="password" name="newPassword">
        <input type="password" name="newPasswordConfirmation">

        <input type="submit" value="Modifier votre mot de passe">
    </form>
</body>
</html>
