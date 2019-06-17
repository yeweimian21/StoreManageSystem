/*
 * useful
 */

function refreshUserOption(dataJsonUser) {
    var userIdSelect = $("#userIdSelect");
    userIdSelect.empty();
    var userArray = dataJsonUser;
    var htmlContent = "";
    for (var i = 0; i < userArray.length; i++) {
        userObject = userArray[i];
        htmlContent = htmlContent + "<option value='" + userObject.userId
            + "' class='optionUserId'>" + userObject.userName + "</option>"
    }
    userIdSelect.append(htmlContent);

    $(".optionUserId").click(function (event) {
        event.stopPropagation();
        return false;
    });
}

function getUserAjax() {
    $.ajax({
        url    : "getUser",
        type   : "POST",
        success: refreshUserOption
    });
}

$(document).ready(function () {
    getUserAjax();

    $("#userIdSelect").click(function () {
        getUserAjax();
    });
});