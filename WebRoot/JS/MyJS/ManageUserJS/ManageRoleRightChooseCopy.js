/*
 * useful
 */

function checkedRoleRightcheckbox(dataJsonRoleRight) {
    var checkboxRightId = $(".checkboxRightId");
    var roleRightArray = dataJsonRoleRight;
    for (var i = 0; i < checkboxRightId.length; i++) {
        checkboxRightId[i].checked=false;
        for(var j=0;j<roleRightArray.length;j++){
            if($(checkboxRightId[i]).attr("value")==roleRightArray[j].right.rightId){
                checkboxRightId[i].checked=true;
                break;
            }
        }
    }
}

function getRoleRightAjax(roleId) {
    $.ajax({
        url    : "getSimpleRoleRightMix",
        data   : {
            roleIdParamAjax: roleId
        },
        type   : "POST",
        success: checkedRoleRightcheckbox
    });
}

function loadRightCheckbox(dataJsonRight) {
    var rightIdDivOuter = $("#rightIdDivOuter");
    rightIdDivOuter.empty();
    var rightArray = dataJsonRight;
    var htmlContent = "";
    for (var i = 0; i < rightArray.length; i++) {
    	var rightObject=rightArray[i];
    	var rightName=rightObject.rightName;
        if(rightName=="manageAllStore"){
            rightName="管理所有店铺";
        }else if(rightName=="manageSelfStore"){
            rightName="管理自己店铺";
        }else if(rightName=="manageAllUser"){
            rightName="管理所有用户";
        }else if(rightName=="manageSelfUser"){
        	rightName="管理自己用户";
        }
        htmlContent = htmlContent + "<div class='checkbox'>"
            + "<label>"
            + "<input type='checkbox' name='rightIdParam' value='"
            + rightObject.rightId + "' class='checkboxRightId'>"
            + rightName
            + "</label>"
            + "</div>";
    }
    rightIdDivOuter.append(htmlContent);

    var roleId = $("#roleIdSelect").val();
    getRoleRightAjax(roleId);

    $(".optionRoleId").click(function(event){
        var roleId=$(this).attr("value");
        getRoleRightAjax(roleId);
        event.stopPropagation();
        return false;
    });
}

function getRightAjax() {
    $.ajax({
        url    : "getRight",
        type   : "POST",
        success: loadRightCheckbox
    });
}

function loadRoleOption(dataJsonRole) {
    var roleIdSelect = $("#roleIdSelect");
    roleIdSelect.empty();
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
        htmlContent = htmlContent + "<option value='"
            + roleObject.roleId + "' class='optionRoleId'>"
            + roleName + "</option>";
    }
    roleIdSelect.append(htmlContent);

    getRightAjax();
}

function getRoleAjax() {
    $.ajax({
        url    : "getRole",
        type   : "POST",
        success: loadRoleOption
    });
}

$(document).ready(function () {
    getRoleAjax();

    $("#roleIdSelect").click(function () {
        getRoleAjax();
    });
});