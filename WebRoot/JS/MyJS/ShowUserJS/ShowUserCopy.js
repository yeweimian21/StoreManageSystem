/*
 * useful
 */

function loadUserTable(dataJsonUser) {
    var userTableOuter = $("#userTableOuter");
    userTableOuter.empty();
    var userArray = dataJsonUser;
    var htmlContent = "";
    for (var i = 0; i < userArray.length; i++) {
        var userObject = userArray[i];
        htmlContent = htmlContent + "<tr>"
            + "<td>" + userObject.userId + "</td>"
            + "<td>" + userObject.userName + "</td>"
            + "<td>" + userObject.password + "</td>"
            + "<td>" + userObject.sex + "</td>"
            + "<td>" + userObject.age + "</td>"
            + "<td>" + userObject.phone + "</td>"
            + "<td>" + userObject.email + "</td>"
            + "</tr>";
    }
    userTableOuter.append(htmlContent);
}

function getUserAjax() {
    $.ajax({
        url    : "getUser",
        type   : "POST",
        success: loadUserTable
    });
}

$(document).ready(function () {
    getUserAjax();
});