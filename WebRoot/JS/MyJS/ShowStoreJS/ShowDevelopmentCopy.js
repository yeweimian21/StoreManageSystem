/*
 * useful
 */

function loadSimpleStoreAllDevelopmentTableAjax(dataJsonDevelopment) {
	var developmentTableOuter = $("#developmentTableOuter");
	developmentTableOuter.empty();
	var developmentArray = dataJsonDevelopment;
	var htmlContent = "";
	for ( var i = 0; i < developmentArray.length; i++) {
		developmentObject = developmentArray[i];
		htmlContent = htmlContent + "<tr>" + "<td>"
				+ developmentObject.developmentId + "</td>" + "<td>"
				+ developmentObject.developmentType + "</td>" + "<td>"
				+ developmentObject.storeName + "</td>" + "<td>"
				+ developmentObject.developmentTitle + "</td>" + "<td>"
				+ developmentObject.developmentContent + "</td>" + "</tr>";
	}
	developmentTableOuter.append(htmlContent);
}

function loadSimpleStoreAllDevelopmentAjax(storeId) {
	$.ajax( {
		url : "getDevelopment",
		data : {
			storeIdParamAjax : storeId
		},
		type : "POST",
		success : loadSimpleStoreAllDevelopmentTableAjax
	});
}

function loadAllStoreOptionAjaxOnload(dataJsonStore) {
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
	} else {
		htmlContent = "<option value='0' class='optionStoreId'>所有店铺</option>";
		for ( var i = 0; i < storeArray.length; i++) {
			var storeObject = storeArray[i];
			htmlContent = htmlContent + "<option value='" + storeObject.storeId
					+ "' class='optionStoreId'>" + storeObject.storeName
					+ "</option>";
		}
		storeIdSelect.append(htmlContent);

		var storeId = storeIdSelect.val();
		loadSimpleStoreAllDevelopmentAjax(storeId);

		$(".optionStoreId").click(function(event) {
			var storeId = $(this).attr("value");
			loadSimpleStoreAllDevelopmentAjax(storeId);
			event.stopPropagation();
			return false;
		});
	}
}

function loadAllStoreAjaxOnload() {
	$.ajax( {
		url : "getStore",
		type : "POST",
		success : loadAllStoreOptionAjaxOnload
	});
}

$(document).ready(function() {
	loadAllStoreAjaxOnload();
	$("#storeIdSelect").click(function() {
		loadAllStoreAjaxOnload();
	});
});