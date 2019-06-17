/*
 * useful
 */

function checkedUserRoleCheckbox(dataJsonUserRole) {
    var checkboxRoleId = $(".checkboxRoleId");
    var userRoleArray = dataJsonUserRole;
    for (var i = 0; i < checkboxRoleId.length; i++) {
        checkboxRoleId[i].checked = false;
        for (var j = 0; j < userRoleArray.length; j++) {
            if ($(checkboxRoleId[i]).attr("value") == userRoleArray[j].role.roleId) {
                checkboxRoleId[i].checked = true;
                break;
            }
        }
    }
}

function getUserRoleAjax(userId) {
    $.ajax({
        url    : "getSimpleUserRoleMix",
        data   : {
            userIdParamAjax: userId
        },
        type   : "POST",
        success: checkedUserRoleCheckbox
    });
}

function loadRoleCheckbox(dataJsonRole) {
    var roleIdDivOuter = $("#roleIdDivOuter");
    roleIdDivOuter.empty();
    var roleArray = dataJsonRole;
    var htmlContent = "";
    for (var i = 0; i < roleArray.length; i++) {
        var roleObject = roleArray[i];
        var roleName=roleObject.roleName;
        if(roleName=="SuperAdmin"){
            roleName="超级管理员";
        }else if(roleName=="Admin"){
            roleName="管理员";
        }else if(roleName=="Manager"){
            roleName="店长";
        }
        htmlContent = htmlContent + "<div class='checkbox'>"
            + "<label>"
            + "<input type='checkbox' name='roleIdParam' value='"
            + roleObject.roleId + "' class='checkboxRoleId'>"
            + roleName
            + "</label>"
            + "</div>";
    }
    roleIdDivOuter.append(htmlContent);

    var userId = $("#userIdSelect").val();
    getUserRoleAjax(userId);

    $(".optionUserId").click(function (event) {
        var userId = $(this).attr("value");
        getUserRoleAjax(userId);
        event.stopPropagation();
        return false;
    });
}

function getRoleAjax() {
    $.ajax({
        url    : "getRole",
        type   : "POST",
        success: loadRoleCheckbox
    });
}

function loadUserOption(dataJsonUser) {
    var userIdSelect = $("#userIdSelect");
    userIdSelect.empty();
    var userArray = dataJsonUser;
    var htmlContent = "";
    for (var i = 0; i < userArray.length; i++) {
        var userObject = userArray[i];
        htmlContent = htmlContent + "<option value='"
            + userObject.userId + "' class='optionUserId'>"
            + userObject.userName + "</option>";
    }
    userIdSelect.append(htmlContent);

    getRoleAjax();
}

function getUserAjax() {
    $.ajax({
        url    : "getUser",
        type   : "POST",
        success: loadUserOption
    });
}

$(document).ready(function () {
    getUserAjax();

    $("#userIdSelect").click(function () {
        getUserAjax();
    });
});