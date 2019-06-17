/*
 * useful
 */

function loadSimpleStoreAllServiceTableAjax(dataJsonService) {
    var serviceTableOuter = $("#serviceTableOuter");
    serviceTableOuter.empty();
    var serviceArray = dataJsonService;
    var htmlContent = "";
    for (var i = 0; i < serviceArray.length; i++) {
        serviceObject = serviceArray[i];
        if (serviceObject.serviceCheap == "cheaper") {
            var cheaperParam = "有优惠";
        } else if (serviceObject.serviceCheap == "notCheaper") {
            var cheaperParam = "暂无优惠";
        }
        htmlContent = htmlContent + "<tr>"
            + "<td>" + serviceObject.serviceId + "</td>"
            + "<td>" + serviceObject.serviceName + "</td>"
            + "<td>" + serviceObject.storeName + "</td>"
            + "<td>" + cheaperParam + "</td>"
            + "<td>" + serviceObject.beforePrice + "</td>"
            + "<td>" + serviceObject.afterPrice + "</td>"
            + "<td>" + serviceObject.costTime + "</td>"
            + "</tr>";
    }
    serviceTableOuter.append(htmlContent);
}

function loadSimpleStoreAllServiceAjax(storeId) {
    $.ajax({
        url    : "getService",
        data   : {
            storeIdParamAjax: storeId
        },
        type   : "POST",
        success: loadSimpleStoreAllServiceTableAjax
    });
}

function loadAllStoreOptionAjaxOnload(dataJsonStore) {
    var storeIdSelect = $("#storeIdSelect");
    storeIdSelect.empty();
    var storeArray = dataJsonStore;
    var htmlContent;
    if(storeArray.length==0){
        htmlContent="<option value='-1' id='optionNoStore'>暂无店铺</option>";
        storeIdSelect.append(htmlContent);
        $("#optionNoStore").click(function(event){
            event.stopPropagation();
            return false;
        });
    }else{
        htmlContent = "<option value='0' class='optionStoreId'>所有店铺</option>";
        for (var i = 0; i < storeArray.length; i++) {
            var storeObject = storeArray[i];
            htmlContent = htmlContent + "<option value='"
                + storeObject.storeId + "' class='optionStoreId'>"
                + storeObject.storeName + "</option>";
        }
        storeIdSelect.append(htmlContent);

        var storeId = storeIdSelect.val();
        loadSimpleStoreAllServiceAjax(storeId);

        $(".optionStoreId").click(function (event) {
            var storeId = $(this).attr("value");
            loadSimpleStoreAllServiceAjax(storeId);
            event.stopPropagation();
            return false;
        });
    }

}

function loadAllStoreAjaxOnload() {
    $.ajax({
        url    : "getStore",
        type   : "POST",
        success: loadAllStoreOptionAjaxOnload
    });
}

$(document).ready(function () {
    loadAllStoreAjaxOnload();
    $("#storeIdSelect").click(function () {
        loadAllStoreAjaxOnload();
    });
});