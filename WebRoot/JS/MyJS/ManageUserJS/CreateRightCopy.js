function checkCreateRight() {
    if($("#rightNameLabel").val()!=''){
        return true;
    }else{
    	alert("有权限信息未填写");
        return false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function () {
        return checkCreateRight();
    });
});