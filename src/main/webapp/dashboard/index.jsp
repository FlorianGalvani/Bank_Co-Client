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
</head>
<body>
<%--<div class="toaster">--%>

<%--</div>--%>
<a href="sendmoney.jsp">Envoyer de l'argent</a>
<%--
Recuperation et affichage des infos du compte client
--%>
<a href="profile.jsp">${dashboardView.get(0).customerFirstname} ${dashboardView.get(0).customerLastname}</a>
<a href="contact">Contacter votre banquier</a>

<%--
Recuperation et affichage des comptes banquaire du client
--%>
<div class="accounts">
    <c:forEach var="view" items="${dashboardView}">
        <div style="border: #000 1px solid">
            <a href="account?id=${view.accountId}">
                <p>N° de compte : ${view.accountNumber}</p>
                <p>Solde : ${view.balance} €</p>
                <p>Decouvert authorisé : ${view.authorizedDebt} €</p>
            </a>
        </div>
    </c:forEach>
</div>


<a href="../logout" class="button">Deconnexion</a>



</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    const toastText = ${success != null ? success : "null" };
    $(document).ready(function () {
        if (toastText != null) {
            const toast = document.createElement("div");
            toast.classList.add("toast");
            toast.textContent = toastText;
            $(".toaster").append(toast);
            setTimeout(() => {
                $(".toast").first().fadeOut("slow", () => {
                    $(".toaster").empty();
                })
            }, 5000)
        }
    });
</script>
</html>
