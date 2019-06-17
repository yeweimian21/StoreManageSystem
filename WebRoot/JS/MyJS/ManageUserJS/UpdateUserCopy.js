/*
 * useful
 */

function loadSimpleUserInformationText(dataJsonSimpleUser) {
    $("#userNameLabel").val(dataJsonSimpleUser.userName);
    $("#userAgeLabel").val(dataJsonSimpleUser.age);
    $("#userPhoneLabel").val(dataJsonSimpleUser.phone);
    $("#userEmailLabel").val(dataJsonSimpleUser.email);

    var userSexRadio = $("input[name='userSexParam']");
    for (var i = 0; i < userSexRadio.length; i++) {
        userSexRadio[i].checked = false;
        if ($(userSexRadio[i]).attr("value") == dataJsonSimpleUser.sex) {
            userSexRadio[i].checked = true;
        }
    }
}

function loadSimpleUserInformationAjax(userId) {
    $.ajax({
        url    : "getSimpleUser",
        data   : {
            userIdParamAjax: userId
        },
        type   : "POST",
        success: loadSimpleUserInformationText
    });
}

function loadUserOption(dataJsonUser) {
    var userIdSelect = $("#userIdSelect");
    userIdSelect.empty();
    var userArray = dataJsonUser;
    var htmlContent = "";
    for (var i = 0; i < userArray.length; i++) {
        var userObject = userArray[i];
        htmlContent = htmlContent + "<option value='" + userObject.userId
            + "' class='optionUserId'>" + userObject.userName + "</option>";
    }
    userIdSelect.append(htmlContent);

    var userId = $("#userIdSelect").val();
    loadSimpleUserInformationAjax(userId);

    $(".optionUserId").click(function (event) {
        var userId = $(this).val();
        loadSimpleUserInformationAjax(userId);
        event.stopPropagation();
        return false;
    });
}

function loadUserAjax() {
    $.ajax({
        url    : "getUser",
        type   : "POST",
        success: loadUserOption
    });
}

function checkUpdateUser() {
    if ($("#userNameLabel").val() != ''
        && $("#userAgeLabel").val() != ''
        && $("#userPhoneLabel").val() != ''
        && $("#userEmailLabel").val() != '') {
        return true;
    } else {
    	alert("有用户信息未填写");
        return  false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function () {
        return checkUpdateUser();
    });

    loadUserAjax();

    $("#userIdSelect").click(function () {
        loadUserAjax();
    });
});