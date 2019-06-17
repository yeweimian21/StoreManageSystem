function loadRoleRightTable(dataJsonRoleRight) {
	var roleRightTable = $("#roleRightTable");
	roleRightTable.empty();
	var roleRightArray = dataJsonRoleRight;
	var htmlContent = "";
	for ( var i = 0; i < roleRightArray.length; i++) {
		var roleRightObject = roleRightArray[i];
		var roleObject = roleRightObject.role;
        var roleName=roleObject.roleName;
        if(roleName=="SuperAdmin"){
            roleName="超级管理员";
        }else if(roleName=="Admin"){
            roleName="管理员";
        }else if(roleName=="Manager"){
            roleName="店长";
        }
		var rightObject = roleRightObject.right;
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
		htmlContent = htmlContent + "<tr>" + "<td>" + roleObject.roleId
				+ "</td>" + "<td>" + roleName + "</td>" + "<td>"
				+ rightObject.rightId + "</td>" + "<td>"
				+ rightName + "</td>" + "</tr>";
	}
	roleRightTable.append(htmlContent);
}

function getRoleRightAjax(roleId) {
	if (roleId == 0) {
		$.ajax( {
			url : "getRoleRightMix",
			type : "POST",
			success : loadRoleRightTable
		});
	} else {
		$.ajax( {
			url : "getSimpleRoleRightMix",
			data : {
				roleIdParamAjax : roleId
			},
			type : "POST",
			success : loadRoleRightTable
		});
	}
}

function loadRoleOption(dataJsonRole) {
	var roleIdSelect = $("#roleIdSelect");
	roleIdSelect.empty();
	var roleArray = dataJsonRole;
	var htmlContent = "<option value='0' class='optionRoleId'>所有角色</option>";
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
				+ "' class='optionRoleId'>" + roleName + "</option>";
	}
	roleIdSelect.append(htmlContent);

	var roleId = $("#roleIdSelect").val();
	getRoleRightAjax(roleId);

	$(".optionRoleId").click(function(event) {
		var roleId = $(this).attr("value");
		getRoleRightAjax(roleId);
		event.stopPropagation();
		return false;
	});
}

function getRoleAjax() {
	$.ajax( {
		url : "getRole",
		type : "POST",
		success : loadRoleOption
	});
}

$(document).ready(function() {
	getRoleAjax();

	$("#roleIdSelect").click(function() {
		getRoleAjax();
	});
});