/*
 * useful
 */

function loadServiceIdOption(dataJsonService) {
    var serviceIdSelect = $("#serviceIdSelect");
    serviceIdSelect.empty();
    var serviceArray = dataJsonService;
    var htmlContent;
    if (serviceArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoService'>暂无服务</option>"
        serviceIdSelect.append(htmlContent);
        $("#optionNoService").click(function (event) {
            event.stopPropagation();
            return false;
        });
    } else {
        htmlContent = "";
        for (var i = 0; i < serviceArray.length; i++) {
            serviceObject = serviceArray[i];
            htmlContent = htmlContent + "<option value='"
                + serviceObject.serviceId + "' class='optionServiceId'>"
                + serviceObject.serviceName + "</option>"
        }
        serviceIdSelect.append(htmlContent);

        $(".optionServiceId").click(function (event) {
            event.stopPropagation();
            return false;
        });
    }

}

function refreshServiceIdAjax(storeId) {
    $.ajax({
        url    : "getService",
        data   : {
            storeIdParamAjax: storeId
        },
        type   : "POST",
        success: loadServiceIdOption
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
        $("#optionNoStore").click(function (event) {
            event.stopPropagation();
            return false;
        });

        var htmlContent1 = "<option value='-1' id='optionNoService'>暂无服务</option>";
        $("#serviceIdSelect").empty();
        $("#serviceIdSelect").append(htmlContent1);
        $("#serviceIdSelect").unbind();
        $("#optionNoService").click(function (event) {
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

        var storeId = storeIdSelect.val();
        refreshServiceIdAjax(storeId);

        $(".optionStoreId").click(function (event) {
            var storeId = $(this).attr("value");
            refreshServiceIdAjax(storeId);
            event.stopPropagation();
            return false;
        });

        $("#serviceIdSelect").click(function () {
            var storeId = $("#storeIdSelect").val();
            refreshServiceIdAjax(storeId);
        });
    }

}

function refreshStoreIdAjax() {
    $.ajax({
        url    : "getStore",
        type   : "POST",
        success: loadStoreIdOption
    });
}

function checkServiceId(){
    if($("#serviceIdSelect").val()==-1){
        alert("暂无服务");
        return false;
    }else{
        return true;
    }
}

$(document).ready(function () {
    $("#form1").submit(function(){
        return checkServiceId();
    });

    refreshStoreIdAjax();

    $("#storeIdSelect").click(function () {
        refreshStoreIdAjax();
    });
});