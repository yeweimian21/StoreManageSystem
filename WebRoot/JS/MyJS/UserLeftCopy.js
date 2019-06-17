function loadHtmlDisplay(dataJsonRight) {
	var rightArray = dataJsonRight;
	var userRightFlag = rightArray.userRightFlag;
	if (userRightFlag == "AllUser") {

	} else if (userRightFlag == "SelfUser") {
		$("#manageRoleItem").remove();
		$("#manageRightItem").remove();
		$("#manageUserRoleItem").remove();
		$("#manageRoleRightItem").remove();
	} else {
		$("#manageUserItem").remove();
		$("#manageRoleItem").remove();
		$("#manageRightItem").remove();
		$("#manageUserRoleItem").remove();
		$("#manageRoleRightItem").remove();
		$("#showUserItem").remove();
		$("#showRoleItem").remove();
		$("#showRightItem").remove();
		$("#showUserRoleItem").remove();
		$("#showRoleRightItem").remove();
	}
}

function getCheckDisplayAjax() {
	$.ajax( {
		url : "getCheckDisplay",
		type : "POST",
		success : loadHtmlDisplay
	});
}

$(document).ready(function() {
	getCheckDisplayAjax();
});