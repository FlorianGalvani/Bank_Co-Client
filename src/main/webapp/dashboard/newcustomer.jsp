<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>New Customer</title>
    <link rel="shortcut icon" href="../assets/img/favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>
</head>
<body class="newCustomerTutorial" id="newCustomerTutorial">

<div class="pagesSlider" id="pagesSlider">

    <div class="page splitted-page">
        <div class="left">
            <h1 class="decorated-big-title">Bienvenue</h1>
            <p>Merci de compter parmis nos nouveaux clients</p>
            <button class="button" onclick="nextPage()">Next</button>
            <button class="button" onclick="skip()">Skip</button>
        </div>
        <div class="right"></div>
    </div>

    <div class="page splitted-page--reversed">
        <div class="left">
            <h1 class="decorated-big-title">Comment utiliser le service 1/3</h1>
            <button class="button" onclick="previousPage()">Previous</button>
            <button class="button" onclick="nextPage()">Next</button>
            <button class="button" onclick="skip()">Skip</button>
        </div>
        <div class="right"></div>
    </div>

    <div class="page splitted-page">
        <div class="left">
            <h1 class="decorated-big-title">Comment utiliser le service 2/3</h1>
            <button class="button" onclick="previousPage()">Previous</button>
            <button class="button" onclick="nextPage()">Next</button>
            <button class="button" onclick="skip()">Skip</button>
        </div>

        <div class="right"></div>
    </div>
    <div class="page splitted-page--reversed">
        <div class="left">
            <h1 class="decorated-big-title">Comment utiliser le service 3/3</h1>
            <button class="button" onclick="previousPage()">Previous</button>
            <button class="button" onclick="nextPage()">Next</button>
            <button class="button" onclick="skip()">Skip</button>

        </div>
        <div class="right"></div>
    </div>

    <div class="page passwordChange splitted-page">
        <button class="button previous" onclick="previousPage()">Previous</button>
        <div class="left">
            <form method="post" action="changePassword">
                <h1 class="decorated-big-title">Modification du mot de passe temporaire</h1>
                <input style="margin-bottom: ${errors.get('newPassword').length() > 0 ? "0" : "25" }px" type="password" name="currentPassword" placeholder="Mot de passe actuel">
                <c:if test="${errors.get('currentPassword').length() > 0 }">
                    <div class="error">${errors.get("currentPassword")}</div>
                </c:if>

                <input style="margin-bottom: ${errors.get('newPassword').length() > 0 ? "0" : "25" }px" type="password" name="newPassword" placeholder="Nouveau mot de passe">
                <c:if test="${errors.get('newPassword').length() > 0 }">
                    <div class="error">${errors.get("newPassword")}</div>
                </c:if>

                <input style="margin-bottom: ${errors.get('newPasswordConfirmation').length() > 0 ? "0" : "25" }px" type="password" name="newPasswordConfirmation"
                       placeholder="Confirmation du nouveau mot de passe">
                <c:if test="${errors.get('newPasswordConfirmation').length() > 0 }">
                    <div class="error">${errors.get("newPasswordConfirmation")}</div>
                </c:if>

                <button class="button" type="submit" id="submit">
                    Modifier votre mot de passe <i class="fa-solid fa-arrow-right"></i>
                </button>
            </form>
        </div>

        <div class="right">

        </div>

    </div>
</div>
</body>
<script
        src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
        integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI="
        crossorigin="anonymous"></script>
<script>
    const newCustomerTutorial = document.getElementById("newCustomerTutorial")
    const pagesSlider = document.getElementById("pagesSlider")
    const page = document.getElementsByClassName("page")

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const isScrollToEnd = urlParams.get('end');


    $(document).ready(() => {
        if (isScrollToEnd === 'true') {
           skip()
        } else {
            newCustomerTutorial.scrollBy(0, 0)
        }
    });

    const nextPage = () => {
        console.log("scroll : ", pagesSlider.offsetWidth)
        newCustomerTutorial.scrollBy({left: page[0].offsetWidth, top: 0, behavior: "smooth"})
    }
    const previousPage = () => {
        console.log("scroll : ", pagesSlider.offsetWidth)
        newCustomerTutorial.scrollBy({left: -page[0].offsetWidth, top: 0, behavior: "smooth"})
    }
    const skip = () => {
        newCustomerTutorial.scrollBy(pagesSlider.offsetWidth, 0)
    }
</script>
</html>
