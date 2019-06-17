/*
 * useful
 */

function operateSuccessfullyTip(operateState) {
	if (operateState == null) {

	} else if (operateState == "addSuccessfully") {
		alert("添加成功");
	} else if (operateState == "updateSuccessfully") {
		alert("修改成功");
	} else if (operateState == "deleteSuccessfully") {
		alert("删除成功");
	}else if(operateState=="manageSuccessfully"){
		alert("管理成功");
	}
}

operateSuccessfullyTip(operateState);