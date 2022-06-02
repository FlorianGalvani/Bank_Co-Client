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
</head>
<body>
<h1>Bienvenue</h1>

<form method="post" action="changePassword">
    <h1>Modification du mot de passe temporaire</h1>
    <input type="password" name="currentPassword">
    <c:if test="${errors.get('currentPassword').length() > 0 }">
        <div class="error">${errors.get("currentPassword")}</div>
    </c:if>

    <input type="password" name="newPassword">
    <c:if test="${errors.get('newPassword').length() > 0 }">
        <div class="error">${errors.get("newPassword")}</div>
    </c:if>

    <input type="password" name="newPasswordConfirmation">
    <c:if test="${errors.get('newPasswordConfirmation').length() > 0 }">
        <div class="error">${errors.get("newPasswordConfirmation")}</div>
    </c:if>

    <input type="submit" value="Modifier votre mot de passe">
</form>
</body>
</html>
