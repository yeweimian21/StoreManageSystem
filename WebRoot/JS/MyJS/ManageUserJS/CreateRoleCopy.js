function checkCreateRole(){
    if($("#roleNameLabel").val()!=''){
        return true;
    }else{
    	alert("有角色信息未填写");
        return false;
    }
}

$(document).ready(function(){
    $("#form1").submit(function(){
        return checkCreateRole();
    });
});