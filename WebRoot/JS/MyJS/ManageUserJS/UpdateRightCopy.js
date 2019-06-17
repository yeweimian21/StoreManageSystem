/*
 * useful
 */

function loadSimpleRightInformationText(dataJsonSimpleRight) {
	var rightName=dataJsonSimpleRight.rightName;
	if(rightName=="manageAllStore"){
        rightName="管理所有店铺";
    }else if(rightName=="manageSelfStore"){
        rightName="管理自己店铺";
    }else if(rightName=="manageAllUser"){
        rightName="管理所有用户";
    }else if(rightName=="manageSelfUser"){
    	rightName="管理自己用户";
    }
    $("#rightNameLabel").val(rightName);
}

function getSimpleRightAjax(rightId) {
    $.ajax({
        url    : "getSimpleRight",
        data   : {
            rightIdParamAjax: rightId
        },
        type   : "POST",
        success: loadSimpleRightInformationText
    });
}

function loadRightOption(dataJsonRight) {
    var rightIdSelect = $("#rightIdSelect");
    rightIdSelect.empty();
    var rightArray = dataJsonRight;
    var htmlContent = "";
    for (var i = 0; i < rightArray.length; i++) {
    	var rightObject = rightArray[i];
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
        htmlContent = htmlContent + "<option value='" + rightObject.rightId
            + "' class='optionRightId'>" + rightName
            + "</option>"
    }
    rightIdSelect.append(htmlContent);

    var rightId = $("#rightIdSelect").val();
    getSimpleRightAjax(rightId);

    $(".optionRightId").click(function (event) {
        var rightId = $(this).attr("value");
        getSimpleRightAjax(rightId);
        event.stopPropagation();
        return false;
    });

}

function getRightAjax() {
    $.ajax({
        url    : "getRight",
        type   : "POST",
        success: loadRightOption
    });
}

function checkUpdateDevelopment(){
    if($("#rightNameLabel").val()!=''){
        return true;
    }else{
    	alert("有权限信息未填写");
        return false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function(){
        return checkUpdateDevelopment();
    });

    getRightAjax();

    $("#rightIdSelect").click(function () {
        getRightAjax();
    });
})