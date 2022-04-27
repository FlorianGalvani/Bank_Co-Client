<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 4/21/22
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.min.css">

</head>
<body class="Dashboard">
<h1>Dashboard</h1>

<%--
Recuperation et affichage des infos du compte client
--%>
<p>${customer.getFirstname()} ${customer.getLastname()}</p>

<%--
Recuperation et affichage des comptes banquaire du client
--%>

<div class="accounts">
    <c:forEach var="account" items="${customer.getAccounts()}">
        <div class="account">
                ${account.getAccountNumber()}
                ${account.getBalance()}
                ${account.getAuthorizedDebt()}

                <%--
                Recuperation et affichage des crédits
                --%>
            <h1>Crédits</h1>
            <div class="credits">
                <c:choose>
                    <c:when test="${account.getCredits().size() > 0}">
                        <c:forEach var="credit" items="${account.getCredits()}">
                            <div class="credit">
                                <p style="color: green">${credit.getAmount()}</p>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>Il n'y a pas de credits</p>
                    </c:otherwise>
                </c:choose>
            </div>
                <%--
                Recuperation et affichage des debits
                --%>
            <h1>Debits</h1>
            <div class="debts">

                <c:choose>
                    <c:when test="${account.getDebts().size() > 0}">
                        <c:forEach var="debt" items="${account.getDebts()}">
                            <div class="debt">
                                <p style="color: red">${debt.getAmount()}</p>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>Il n'y a pas de debits</p>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </c:forEach>
</div>


<a href="../logout" class="button">Deconnexion</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="assets/js/utils.js"></script>
<script src="assets/js/dashboard.js">

</script>
</script>
</html>