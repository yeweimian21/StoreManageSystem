function checkRegister() {
    if ($("#userNameLabel").val() != ''
        && $("#password1").val() != ''
        && $("#password2").val() != ''
        && $("#userAgeLabel").val() != ''
        && $("#userPhoneLabel").val() != ''
        && $("#usereEmailLabel").val() != '') {
        return true;
    } else {
    	alert("有用户信息未填写");
        return false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function () {
        return checkRegister();
    });
});