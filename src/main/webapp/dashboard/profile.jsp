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
    <title>Profile</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
</head>
<body >
    <a href="./">Retour</a>
    <p type="text" >${dashboardView.get(0).customerFirstname}</p>
    <p type="text" >${dashboardView.get(0).customerLastname}</p>
</body>
</html>
