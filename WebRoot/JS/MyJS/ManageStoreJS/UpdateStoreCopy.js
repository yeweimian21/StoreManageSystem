/*
 * useful
 */

function loadInformationText(dataJsonSimpleStore) {
    $("#storeNameLabel").val(dataJsonSimpleStore.storeName);
    $("#storeAddressLabel").val(dataJsonSimpleStore.storeAddress);
    $("#storePhoneLabel").val(dataJsonSimpleStore.storePhone);
}

function loadInformationAjax(storeId) {
    $.ajax({
        url    : "getSimpleStore",
        data   : {
            storeIdParamAjax: storeId
        },
        type   : "POST",
        success: loadInformationText
    });
}

function selectedManagerIdOption(dataJsonManager) {
    var managerId = dataJsonManager.managerId;
    var optionManagerId = $(".optionManagerId");
    for (var i = 0; i < optionManagerId.length; i++) {
        optionManagerId[i].selected = false;
        if ($(optionManagerId[i]).attr("value") == managerId) {
            optionManagerId[i].selected = true;
        }
    }

    var storeId = $("#storeIdSelect").val();
    loadInformationAjax(storeId);
}

function getManagerIdAjax(storeId) {
    $.ajax({
        url    : "getManagerIdStore",
        data   : {
            storeIdParamAjax: storeId
        },
        type   : "POST",
        success: selectedManagerIdOption
    });
}

function refreshManagerIdAjaxOption(dataJsonManager) {
    var managerIdSelect = $("#managerIdSelect");
    managerIdSelect.empty();
    var managerArray = dataJsonManager;
    var htmlContent = "";
    for (var i = 0; i < managerArray.length; i++) {
        var managerObject = managerArray[i];
        htmlContent = htmlContent + "<option value='"
            + managerObject.userId + "' class='optionManagerId'>"
            + managerObject.userName + "</option>"
    }
    managerIdSelect.append(htmlContent);

    var storeId = $("#storeIdSelect").val();
    getManagerIdAjax(storeId);

    $(".optionManagerId").click(function (event) {
        event.stopPropagation();
        return false;
    });
}

function refreshManagerIdAjax() {
    $.ajax({
        url    : "getSimpleRoleUserMix",
        data   : {
            roleNameParamAjax: "Manager"
        },
        type   : "POST",
        success: refreshManagerIdAjaxOption
    });
}

function refreshStoreIdAjaxOption(dataJsonStore) {
    var storeIdSelect = $("#storeIdSelect");
    storeIdSelect.empty();
    var storeArray = dataJsonStore;
    var htmlContent;
    if (storeArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoStore'>暂无店铺</option>";
        storeIdSelect.append(htmlContent);
        $("#optionNoStore").click(function (event) {
            event.stopPropagation();
            return false;
        });

        var htmlContent1 = "<option value='-1' id='optionNoManager'>暂无店长</option>";
        $("#managerIdSelect").empty();
        $("#managerIdSelect").append(htmlContent1);
        $("#managerIdSelect").unbind();
        $("#optionNoManager").click(function (event) {
            event.stopPropagation();
            return false;
        });
    } else {
        htmlContent = "";
        for (var i = 0; i < storeArray.length; i++) {
            var storeObject = storeArray[i];
            htmlContent = htmlContent + "<option value='"
                + storeObject.storeId + "' class='optionStoreId'>"
                + storeObject.storeName + "</option>";
        }
        storeIdSelect.append(htmlContent);

        refreshManagerIdAjax();

        $(".optionStoreId").click(function (event) {
            refreshManagerIdAjax();
            event.stopPropagation();
            return false;
        });

        $("#managerIdSelect").click(function () {
            refreshManagerIdAjax();
        });
    }

}

function refreshStoreIdAjax() {
    $.ajax({
        url    : "getStore",
        type   : "POST",
        success: refreshStoreIdAjaxOption
    });
}

function checkStoreId() {
    if ($("#storeIdSelect").val() != -1
        && $("#storeNameLabel").val() != ''
        && $("#storeAddressLabel").val() != ''
        && $("#storePhoneLabel").val() != ''
        && $("#managerIdSelect").val() != -1) {
        return true;
    } else {
    	alert("有店铺信息未填写");
        return false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function () {
        return checkStoreId();
    });

    refreshStoreIdAjax();

    $("#storeIdSelect").click(function () {
        refreshStoreIdAjax();
    });
});