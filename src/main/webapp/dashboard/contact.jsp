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


    <p>${dashboardView.get(0).getB_firstname()}</p>
    <p>${dashboardView.get(0).getB_lastname()}</p>
    <p>${banker.getPhone()}</p>
    <a href="mailto: ${banker.getEmail()}">${banker.getEmail()}</a>
</body>
</html>
