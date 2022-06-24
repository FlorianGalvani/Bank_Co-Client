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
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>

    <div class="page dash-home-page">
        <div class="l-constrained">
            <nav>
                <ul>
                    <li><a href="sendmoney.jsp">Envoyer de l'argent</a></li>
                    <li><a href="profile.jsp">${dashboardView.get(0).customerFirstname} ${dashboardView.get(0).customerLastname}</a></li>
                    <li><a href="contact">Contacter votre banquier</a></li>
                </ul>
            </nav>
            <%--
            Recuperation et affichage des infos du compte client
            --%>



            <%--
            Recuperation et affichage des comptes banquaire du client
            --%>
            <div class="accounts">
                <c:forEach var="view" items="${dashboardView}">
                    <div class="account-card">
                        <a href="account?id=${view.accountId}">

                            <p>N° de compte : ${view.accountNumber}</p>
                            <p>Solde : ${view.balance} €</p>
                            <p>Découvert autorisé : ${view.authorizedDebt} €</p>
                        </a>
                    </div>
                </c:forEach>
            </div>


            <a href="../logout" class="button btn-primary">Deconnexion</a>
        </div>
    </div>

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
