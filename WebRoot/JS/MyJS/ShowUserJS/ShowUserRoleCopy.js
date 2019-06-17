function loadUserRoleTable(dataJsonUserRole) {
	var userRoleTable = $("#userRoleTable");
	userRoleTable.empty();
	var userRoleArray = dataJsonUserRole;
	var htmlContent = "";
	for ( var i = 0; i < userRoleArray.length; i++) {
		var userRoleObject = userRoleArray[i];
		var userObject = userRoleObject.user;
		var roleObject = userRoleObject.role;
        var roleName=roleObject.roleName;
        if(roleName=="SuperAdmin"){
            roleName="超级管理员";
        }else if(roleName=="Admin"){
            roleName="管理员";
        }else if(roleName=="Manager"){
            roleName="店长";
        }
		htmlContent = htmlContent + "<tr>" + "<td>" + userObject.userId
				+ "</td>" + "<td>" + userObject.userName + "</td>" + "<td>"
				+ roleObject.roleId + "</td>" + "<td>" + roleName
				+ "</td>" + "</tr>";
	}
	userRoleTable.append(htmlContent);
}

function getUserRoleAjax(userId) {
	$.ajax( {
		url : "getUserRoleMix",
		data : {
			userIdParamAjax : userId
		},
		type : "POST",
		success : loadUserRoleTable
	});
}

function loadUserOption(dataJsonUser) {
	var userIdSelect = $("#userIdSelect");
	userIdSelect.empty();
	var userArray = dataJsonUser;
	var htmlContent = "<option value='0' class='optionUserId'>所有用户</option>";
	for ( var i = 0; i < userArray.length; i++) {
		var userObject = userArray[i];
		htmlContent = htmlContent + "<option value='" + userObject.userId
				+ "' class='optionUserId'>" + userObject.userName + "</option>";
	}
	userIdSelect.append(htmlContent);

	var userId = $("#userIdSelect").val();
	getUserRoleAjax(userId);

	$(".optionUserId").click(function(event) {
		var userId = $(this).attr("value");
		getUserRoleAjax(userId);
		event.stopPropagation();
		return false;
	});
}

function getUserAjax() {
	$.ajax( {
		url : "getUser",
		type : "POST",
		success : loadUserOption
	});
}

$(document).ready(function() {
	getUserAjax();

	$("#userIdSelect").click(function() {
		getUserAjax();
	});
});