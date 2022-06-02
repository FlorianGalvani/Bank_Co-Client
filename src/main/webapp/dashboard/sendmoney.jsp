<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/1/22
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Envoyer de l'argent</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
</head>
<body>
<form method="POST" action="sendmoney">

    <c:if test="${error.length() > 0}">
        <div class="error">
                ${error}
        </div>
    </c:if>

    <select name="debitedAccountId" id="debitedAccountId">
        <option value="">
            Compte à debité
        </option>
        <c:forEach var="account" items="${dashboardView}">
            <option value="${account.accountId}">
                    ${account.accountNumber}
            </option>
        </c:forEach>
    </select>


    <select name="creditedAccountId" id="creditedAccountId">
        <option value="">
            Compte à credité
        </option>
        <c:forEach var="account" items="${dashboardView}">
            <option value="${account.accountId}">
                    ${account.accountNumber}
            </option>
        </c:forEach>
    </select>
    <input type="number" name="amount">
    <input type="text" name="reason">
    <input type="submit" class="button">
</form>
</body>
</html>
