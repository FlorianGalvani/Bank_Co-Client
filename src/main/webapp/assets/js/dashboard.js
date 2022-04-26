// const token = readCookie("token");
// let isLoading = true;
// let isTokenValid = false
// if (token != null) {
//     $.get({
//         url: 'token',
//         success: (response) => {
//             console.log(response)
//             if (response != true) {
//                 alert("Token invalide");
//                 window.location.href = "/Bank_Co_war_exploded/login"
//             } else {
//                 isTokenValid = true
//             }
//         }
//     })
// } else {
//     window.location.href = "/Bank_Co_war_exploded/login"
// }

// if (isTokenValid) {
//     const userId = readCookie("id");
//     $.get({
//         url: 'customer',
//         data: userId,
//         success: (response) => {
//             console.log(response)
//         }
//     })
// }
// $("#logout").click(() => {
//     console.log("click")
//     document.cookie = "token= ; expires = Thu, 01 Jan 1970 00:00:00 GMT"
//     document.cookie = "id= ; expires = Thu, 01 Jan 1970 00:00:00 GMT"
//     window.location.href = "/Bank_Co_war_exploded/"
// })
