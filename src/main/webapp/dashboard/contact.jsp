<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/17/22
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacter votre Banquier</title>
</head>
<body>
    <a href="./">Retour</a>


    <p>${dashboardView.get(0).bankerFirstname}</p>
    <p>${dashboardView.get(0).bankerLastname}</p>
    <p>${dashboardView.get(0).getBankerPhone()}</p>
    <a href="mailto: ${dashboardView.get(0).getBankerEmail()}">${dashboardView.get(0).getBankerEmail()}</a>

    <h1>Faire une demande</h1>
    <form method="post" action="./contact">
        <input type="text" name="object">
        <textarea name="message"></textarea>
        <input type="submit" value="Envoyer">
    </form>

</body>
</html>
