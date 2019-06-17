/*
 * useful
 */

function loadRightTable(dataJsonRight) {
    var rightTableOuter = $("#rightTableOuter");
    rightTableOuter.empty();
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
        htmlContent = htmlContent + "<tr>"
            + "<td>" + rightObject.rightId + "</td>"
            + "<td>" + rightName + "</td>"
            + "</tr>";
    }
    rightTableOuter.append(htmlContent);
}

function getRightAjax() {
    $.ajax({
        url    : "getRight",
        type   : "POST",
        success: loadRightTable
    });
}

$(document).ready(function () {
    getRightAjax();
});