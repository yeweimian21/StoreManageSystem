/*
 * useful
 */

function loadSimpleRoleInformationText(dataJsonSimpleRole) {
	var roleName=dataJsonSimpleRole.roleName;
	if(roleName=="SuperAdmin"){
        roleName="超级管理员";
    }else if(roleName=="Admin"){
        roleName="管理员";
    }else if(roleName=="Manager"){
        roleName="店长";
    }
    $("#roleNameLabel").val(roleName);
}

function getSimpleRoleAjax(roleId) {
    $.ajax( {
        url : "getSimpleRole",
        data : {
            roleIdParamAjax : roleId
        },
        type : "POST",
        success : loadSimpleRoleInformationText
    });
}

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

    var roleId = $("#roleIdSelect").val();
    getSimpleRoleAjax(roleId);

    $(".optionRoleId").click(function(event) {
        var roleId = $(this).attr("value");
        getSimpleRoleAjax(roleId);
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

function checkUpdateRole(){
    if($("#roleNameLabel").val()!=''){
        return true;
    }else{
    	alert("有角色信息未填写");
        return false;
    }
}

$(document).ready(function() {
    $("#form1").submit(function(){
        return checkUpdateRole();
    });

    getRoleAjax();

    $("#roleIdSelect").click(function(){
        getRoleAjax();
    });
})