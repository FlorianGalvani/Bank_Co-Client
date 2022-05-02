<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/1/22
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Envoyer de l'argent</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.min.css">
</head>
<body>
    <form method="POST" action="sendmoney">


        <select name="debitedAccountNumber" id="debitedAccountNumber">
            <option value="">
                Compte à debité
            </option>
            <c:forEach var="account" items="${customer.getAccounts()}">
                <option value="${account.getId()}">
                        ${account.getAccountNumber()}
                </option>
            </c:forEach>
        </select>


        <select name="creditedAccountNumber" id="creditedAccountNumber">
            <option value="">
                Compte à credité
            </option>
            <c:forEach var="account" items="${customer.getAccounts()}">
                <option value="${account.getId()}">
                        ${account.getAccountNumber()}
                </option>
            </c:forEach>
        </select>
        <input type="submit" class="button">
    </form>
</body>
</html>
