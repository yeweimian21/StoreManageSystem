function loadHtmlDisplay(dataJsonRight) {
	var rightArray = dataJsonRight;
	var userRightFlag = rightArray.userRightFlag;
	if (userRightFlag == "AllUser") {

	} else if (userRightFlag == "SelfUser") {
		$("#deleteUserItem").remove();
	} else {
		$("#updateUserItem").remove();
		$("#deleteUserItem").remove();
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