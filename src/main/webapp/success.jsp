<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}"/>
<fmt:setBundle basename="success"/>

<html lang="${cookie.get('lang') != null ? cookie.lang.value : 'fr'}">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>

</body>
</html>
