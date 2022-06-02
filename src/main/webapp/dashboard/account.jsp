<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/14/22
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Votre compte</title>
</head>
<body>
<a href="./">Retour</a>
<p>${account.accountNumber}</p>
<p>${account.balance}</p>
<h1>Credit</h1>

<c:forEach items="${credits}" var="credit">
    <p>${credit.date}</p>
    <p>${credit.amount}</p>
    <p>${credit.reason}</p>
</c:forEach>

<h1>Debt</h1>

<c:forEach items="${debts}" var="debt">
    <p>${debt.date}</p>
    <p>-${debt.amount}</p>
    <p>${debt.reason}</p>
</c:forEach>

<h1>All</h1>

<c:forEach items="${transactions}" var="transactions">
    <p>${transactions.date}</p>
    <c:choose>
        <c:when test="${transactions.fromAccount.id == account.id}">
            <p>-${transactions.amount}</p>
        </c:when>
        <c:otherwise>
            <p>${transactions.amount}</p>
        </c:otherwise>
    </c:choose>
    <p>${transactions.reason}</p>
</c:forEach>

</body>
</html>