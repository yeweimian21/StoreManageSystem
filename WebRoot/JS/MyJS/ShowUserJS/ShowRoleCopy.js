/*
 * useful
 */

function loadRoleTable(dataJsonRole) {
    var roleTableOuter = $("#roleTableOuter");
    roleTableOuter.empty();
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
        htmlContent = htmlContent + "<tr>"
            + "<td>" + roleObject.roleId + "</td>"
            + "<td>" + roleName + "</td>"
            + "</tr>";
    }
    roleTableOuter.append(htmlContent);
}

function getRoleAjax() {
    $.ajax({
        url    : "getRole",
        type   : "POST",
        success: loadRoleTable
    });
}

$(document).ready(function () {
    getRoleAjax();
});