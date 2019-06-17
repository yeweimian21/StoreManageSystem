/*
 * useful
 */

function loadUserRoleInformationText(dataJsonUserRole){
    $("#roleTip").empty();
    var userRoleArray=dataJsonUserRole;
    var roleName;
    for(var i=0;i<userRoleArray.length;i++){
        var userRoleObject=userRoleArray[i];
        var roleObject=userRoleObject.role;
        roleName=roleObject.roleName;
        if(roleName=="SuperAdmin"){
            roleName="超级管理员";
        }else if(roleName=="Admin"){
            roleName="管理员";
        }else if(roleName=="Manager"){
            roleName="店长";
        }
    }
    $("#roleTip").text(roleName);
}

function getUserRoleAjax(userId){
    $.ajax({
        url:"getSimpleUserRoleMix",
        data:{
            userIdParamAjax:userId
        },
        type:"POST",
        success:loadUserRoleInformationText
    });
}

function loadSimpleUserInformationText(dataJsonSimpleUser){
    $("#userTip").empty();
    var userObject=dataJsonSimpleUser;
    var userName=userObject.userName;
    var userId=userObject.userId;
    $("#userTip").text(userName);

    getUserRoleAjax(userId);
}

function getUserAjax(){
    $.ajax({
        url:"getTipSimpleUser",
        type:"POST",
        success:loadSimpleUserInformationText
    });
}

function loadHtmlDisplay(dataJsonRight) {
	var rightArray = dataJsonRight;
	var storeRightFlag = rightArray.storeRightFlag;
	var userRightFlag = rightArray.userRightFlag;
	if (storeRightFlag == "AllStore") {

	} else if (storeRightFlag == "SelfStore") {

	} else {
		$("#storeManageTag").remove();
	}
	if (userRightFlag == "AllUser") {

	} else if (userRightFlag == "SelfUser") {

	} else {
		$("#userManageTag").remove();
	}
	
	getUserAjax();
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

	$(".nav li a").click(function() {
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
});