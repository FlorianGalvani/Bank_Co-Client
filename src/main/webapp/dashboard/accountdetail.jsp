<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/1/22
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails du compte</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>
<c:choose>
    <c:when test="${customer.getAccountById(param.id) != null}">
        <p>${ customer.getAccountById(param.id).getAccountNumber()}</p>
    </c:when>
    <c:otherwise>
        <a href='./'>Retourner</a>
    </c:otherwise>
</c:choose>

</body>
</html>
