/*
 * useful
 */

function refreshRoleOption(dataJsonRole) {
    var roleIdSelect = $("#roleIdSelect");
    roleIdSelect.empty();
    var roleArray = dataJsonRole;
    var htmlContent = "";
    for ( var i = 0; i < roleArray.length; i++) {
    	var roleObject = roleArray[i];
        var roleName=roleObject.roleName;
        if(roleName=="SuperAdmin"){
            roleName="超级管理员";
        }else if(roleName=="Admin"){
            roleName="管理员";
        }else if(roleName=="Manager"){
            roleName="店长";
        }
        htmlContent = htmlContent + "<option value='" + roleObject.roleId
            + "' class='optionRoleId'>" + roleName + "</option>"
    }
    roleIdSelect.append(htmlContent);

    $(".optionRoleId").click(function(event) {
        event.stopPropagation();
        return false;
    });
}

function getRoleAjax() {
    $.ajax( {
        url : "getRole",
        type : "POST",
        success : refreshRoleOption
    });
}

$(document).ready(function() {
    getRoleAjax();

    $("#roleIdSelect").click(function(){
        getRoleAjax();
    });
});