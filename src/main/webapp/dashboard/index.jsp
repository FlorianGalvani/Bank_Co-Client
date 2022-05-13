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
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.min.css">

</head>
<body class="Dashboard basicPage">
<div class="toaster">

</div>
<a class="button" href="sendmoney.jsp">Envoyer de l'argent</a>
<%--
Recuperation et affichage des infos du compte client
--%>
<%--<a href="profile.jsp">${customer.getC_firstname()} ${customer.setC_firstname()}</a>--%>
<%--
Recuperation et affichage des comptes banquaire du client
--%>

<div class="accounts">
    <c:forEach var="view" items="${dashboardView}">
        <div class="account">
            ${view}
            ${view.balance}
        </div>
    </c:forEach>
<%--    <c:forEach var="account" items="${customer.getAccounts()}">--%>
<%--        <div class="account">--%>
<%--                ${account.getAccountNumber()}--%>
<%--                ${account.getBalance()}--%>
<%--                ${account.getAuthorizedDebt()}--%>
<%--                <br>--%>
<%--            <h1>Dernière transaction</h1>--%>
<%--                &lt;%&ndash;--%>
<%--                Recuperation et affichage des crédits--%>
<%--                &ndash;%&gt;--%>
<%--            <h2>Crédits</h2>--%>
<%--            <div class="credits">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${account.getCredits().size() > 0}">--%>
<%--                        <c:forEach var="credit" items="${account.getCredits()}">--%>
<%--                            <div class="credit">--%>
<%--                                <p style="color: green">${credit.getAmount()}</p>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <p>Il n'y a pas de credits</p>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </div>--%>
<%--                &lt;%&ndash;--%>
<%--                Recuperation et affichage des debits--%>
<%--                &ndash;%&gt;--%>
<%--            <h1>Debits</h1>--%>
<%--            <div class="debts">--%>

<%--                <c:choose>--%>
<%--                    <c:when test="${account.getDebts().size() > 0}">--%>
<%--                        <c:forEach var="debt" items="${account.getDebts()}">--%>
<%--                            <div class="debt">--%>
<%--                                <p style="color: red">${debt.getAmount()}</p>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <p>Il n'y a pas de debits</p>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </div>--%>
<%--                    <a class="button" href="accountdetail.jsp?id=${account.getId()}">Gerer</a>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

</div>


<a href="../logout" class="button">Deconnexion</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    const toastText = ${success != null ? success : "null" };
    $(document).ready(function() {
        if (toastText != null) {
            const toast = document.createElement("div");
            toast.classList.add("toast");
            toast.textContent = toastText;
            $(".toaster").append(toast);
            setTimeout(() => {
                $(".toast").first().fadeOut("slow", () => {
                    $(".toaster").empty();
                })
            },5000)
        } else {

        }
    });
</script>
</html>
