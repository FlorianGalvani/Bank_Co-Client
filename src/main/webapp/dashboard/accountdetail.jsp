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
    <title>Detail du compte</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
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
