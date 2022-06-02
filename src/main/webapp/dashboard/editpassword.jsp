<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/19/22
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Changement de mot de passe</title>
</head>
<body>
<h1>Changement de mot de passe</h1>
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

</body>
</html>
