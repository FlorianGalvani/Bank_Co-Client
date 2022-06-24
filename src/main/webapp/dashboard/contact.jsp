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
    <meta charset="UTF-8">
    <title>Contacter votre Banquier</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>

    <div class="page dash-contact-page">
        <div class="l-constrained">
            <div class="btn-header">
                <a href="./">
                    <i class="fa-solid fa-arrow-left"></i>
                </a>
            </div>

            <div class="user-info">
                <h2>Vos informations</h2>

                <div class="info">
                    <p>Prénom : ${dashboardView.get(0).bankerFirstname}</p>
                    <p>Nom : ${dashboardView.get(0).bankerLastname}</p>
                    <p>Tél. banquier : ${dashboardView.get(0).getBankerPhone()}</p>
                    <p>E-mail banquier : <a href="mailto: ${dashboardView.get(0).getBankerEmail()}">${dashboardView.get(0).getBankerEmail()}</a></p>
                </div>
            </div>


            <h1>Faire une demande</h1>
            <form method="post" action="./contact">
                <div class="field">
                    <input type="text" name="object" placeholder="Objet du message">
                    <div class="line"></div>
                </div>
                <div class="field">
                    <textarea name="message" placeholder="Message"></textarea>
                    <div class="line"></div>
                </div>
                <input type="submit" value="Envoyer" class="button btn-primary">
            </form>
        </div>
    </div>

</body>
</html>
