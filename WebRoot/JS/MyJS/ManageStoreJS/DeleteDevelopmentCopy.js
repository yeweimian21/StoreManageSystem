/*
 * useful
 */

function loadDevelopmentIdOption(dataJsonDevelopment) {
	var developmentIdSelect = $("#developmentIdSelect");
	developmentIdSelect.empty();
	var developmentArray = dataJsonDevelopment;
	var htmlContent;
	if (developmentArray.length == 0) {
		htmlContent = "<option value='-1' id='optionNoDevelopment'>暂无动态</option>"
		developmentIdSelect.append(htmlContent);
		$("#optionNoDevelopment").click(function(event) {
			event.stopPropagation();
			return false;
		});
	} else {
		htmlContent = "";
		for ( var i = 0; i < developmentArray.length; i++) {
			developmentObject = developmentArray[i];
			htmlContent = htmlContent + "<option value='"
					+ developmentObject.developmentId + "' class='optionDevelopmentId'>"
					+ developmentObject.developmentTitle + "</option>"
		}
		developmentIdSelect.append(htmlContent);

		$(".optionDevelopmentId").click(function(event) {
			event.stopPropagation();
			return false;
		});
	}

}

function refreshDevelopmentIdAjax(storeId) {
	$.ajax( {
		url : "getDevelopment",
		data : {
			storeIdParamAjax : storeId
		},
		type : "POST",
		success : loadDevelopmentIdOption
	});
}

function loadStoreIdOption(dataJsonStore) {
	var storeIdSelect = $("#storeIdSelect");
	storeIdSelect.empty();
	var storeArray = dataJsonStore;
	var htmlContent;
	if (storeArray.length == 0) {
		htmlContent = "<option value='-1' id='optionNoStore'>暂无店铺</option>";
		storeIdSelect.append(htmlContent);
		$("#optionNoStore").click(function(event) {
			event.stopPropagation();
			return false;
		});

		var htmlContent1 = "<option value='-1' id='optionNoDevelopment'>暂无动态</option>";
		$("#developmentIdSelect").empty();
		$("#developmentIdSelect").append(htmlContent1);
		$("#developmentIdSelect").unbind();
		$("#optionNoDevelopment").click(function(event) {
			event.stopPropagation();
			return false;
		});
	} else {
		htmlContent = "";
		for ( var i = 0; i < storeArray.length; i++) {
			var storeObject = storeArray[i];
			htmlContent = htmlContent + "<option value='" + storeObject.storeId
					+ "' class='optionStoreId'>" + storeObject.storeName
					+ "</option>";
		}
		storeIdSelect.append(htmlContent);

		var storeId = storeIdSelect.val();
		refreshDevelopmentIdAjax(storeId);

		$(".optionStoreId").click(function(event) {
			var storeId = $(this).attr("value");
			refreshDevelopmentIdAjax(storeId);
			event.stopPropagation();
			return false;
		});

		$("#developmentIdSelect").click(function() {
			var storeId = $("#storeIdSelect").val();
			refreshDevelopmentIdAjax(storeId);
		});
	}

}

function refreshStoreIdAjax() {
	$.ajax( {
		url : "getStore",
		type : "POST",
		success : loadStoreIdOption
	});
}

function checkDevelopmentId(){
    if($("#developmentIdSelect").val()==-1){
        alert("暂无动态");
        return false;
    }else{
        return true;
    }
}

$(document).ready(function () {
	$("#form1").submit(function(){
        return checkDevelopmentId();
    });
	
    refreshStoreIdAjax();
    
    $("#storeIdSelect").click(function () {
        refreshStoreIdAjax();
    });
});