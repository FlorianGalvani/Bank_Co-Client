<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/2/22
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profil</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>
<a href="./">Retour</a>
<p type="text">${dashboardView.get(0).customerFirstname}</p>
<p type="text">${dashboardView.get(0).customerLastname}</p>
</body>
</html>
