<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: legilmalas
  Date: 5/14/22
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Votre compte</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../assets/css/style.min.css">
    <script src="https://kit.fontawesome.com/170ba6c352.js" crossorigin="anonymous"></script>

</head>
<body>

 <div class="page dash-account-page">
     <div class="l-constrained">
         <div class="btn-header">
             <a href="./">
                 <i class="fa-solid fa-arrow-left"></i>
             </a>
         </div>

         <div class="user">
             <p>N° de compte : ${account.accountNumber}</p>
             <p>Solde : ${account.balance}</p>
         </div>

         <div class="account-block credit">
             <h1>Credit</h1>

             <table>
                 <thead>
                     <tr>
                         <th>Date</th>
                         <th>Montant</th>
                         <th>Raison</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach items="${credits}" var="credit">
                         <tr>
                             <td>${credit.date}</td>
                             <td>${credit.amount}</td>
                             <td>${credit.reason}</td>
                         </tr>
                     </c:forEach>
                 </tbody>
             </table>

         </div>

         <div class="account-block debt">
             <h1>Debt</h1>

             <table>
                 <thead>
                 <tr>
                     <th>Date</th>
                     <th>Montant</th>
                     <th>Raison</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${debts}" var="debt">
                     <tr>
                         <td>${debt.date}</td>
                         <td>${debt.amount}</td>
                         <td>${debt.reason}</td>
                     </tr>
                 </c:forEach>
                 </tbody>
             </table>
         </div>

         <div class="account-block all">
             <h1>All</h1>

             <table>
                 <thead>
                 <tr>
                     <th>Date</th>
                     <th>Montant</th>
                     <th>Montant</th>
                     <th>Raison</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${transactions}" var="transactions">
                     <tr>
                         <td>${transactions.date}</td>
                         <c:choose>
                             <c:when test="${transactions.fromAccount.id == account.id}">
                                 <td>-${transactions.amount}</td>
                             </c:when>
                             <c:otherwise>
                                 <td>${transactions.amount}</td>
                             </c:otherwise>
                         </c:choose>
                         <td>${transactions.amount}</td>
                         <td>${transactions.reason}</td>
                     </tr>
                 </c:forEach>
                 </tbody>
             </table>
         </div>
     </div>
 </div>

</body>
</html>