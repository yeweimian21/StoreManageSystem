/*
 * useful
 */

function loadSimpleServiceInformationText(dataJsonSimpleService) {
    $("#serviceNameLabel").val(dataJsonSimpleService.serviceName);
    $("#beforePriceLabel").val(dataJsonSimpleService.beforePrice);
    $("#afterPriceLabel").val(dataJsonSimpleService.afterPrice);
    $("#costTimeLabel").val(dataJsonSimpleService.costTime);

    var serviceCheapRadio = $("input[name='serviceCheapParam']");
    for (var i = 0; i < serviceCheapRadio.length; i++) {
        serviceCheapRadio[i].checked = false;
        if ($(serviceCheapRadio[i]).attr("value") == dataJsonSimpleService.serviceCheap) {
            serviceCheapRadio[i].checked = true;
        }
    }
}

function loadSimpleServiceInformationAjax(serviceId) {
    $.ajax({
        url    : "getSimpleService",
        data   : {
            serviceIdParamAjax: serviceId
        },
        type   : "POST",
        success: loadSimpleServiceInformationText
    });
}

function selectedStoreIdAjaxOption(dataJsonSimpleService) {
    var storeId = dataJsonSimpleService.storeIdSelf;
    var optionStoreIdAfter = $(".optionStoreIdAfter");
    for (var i = 0; i < optionStoreIdAfter.length; i++) {
        optionStoreIdAfter[i].selected = false;
        if ($(optionStoreIdAfter[i]).attr("value") == storeId) {
            optionStoreIdAfter[i].selected = true;
        }
    }

    var serviceId = $("#serviceIdSelect").val();
    loadSimpleServiceInformationAjax(serviceId);
}

function selectedStoreIdAjax(serviceId) {
    $.ajax({
        url    : "getSimpleService",
        data   : {
            serviceIdParamAjax: serviceId
        },
        type   : "POST",
        success: selectedStoreIdAjaxOption
    });
}

function refreshStoreIdAfterAjaxOption(dataJsonStore) {
    var storeIdSelectAfter = $("#storeIdSelectAfter");
    storeIdSelectAfter.empty();
    var storeArray = dataJsonStore;
    var htmlContent = "";
    for (var i = 0; i < storeArray.length; i++) {
        var storeObject = storeArray[i];
        htmlContent = htmlContent + "<option value='"
            + storeObject.storeId + "' class='optionStoreIdAfter'>"
            + storeObject.storeName + "</option>";
    }
    storeIdSelectAfter.append(htmlContent);

    var serviceId = $("#serviceIdSelect").val();
    selectedStoreIdAjax(serviceId);

    $(".optionStoreIdAfter").click(function (event) {
        event.stopPropagation();
        return false;
    });

}

function refreshStoreIdAfterAjax() {
    $.ajax({
        url    : "getStore",
        type   : "POST",
        success: refreshStoreIdAfterAjaxOption
    });
}

function refreshServiceIdAjaxoption(dataJsonService) {
    var serviceIdSelect = $("#serviceIdSelect");
    serviceIdSelect.empty();
    var serviceArray = dataJsonService;
    var htmlContent;
    if (serviceArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoService'>暂无服务</option>";
        $("#serviceIdSelect").append(htmlContent);
        $("#optionNoService").click(function (event) {
            event.stopPropagation();
            return false;
        });

        var htmlContent1 = "<option value='-1' id='optionNoStoreAfter'>暂无店铺</option>";
        $("#storeIdSelectAfter").empty();
        $("#storeIdSelectAfter").append(htmlContent1);
        $("#storeIdSelectAfter").unbind();
        $("#optionNoStoreAfter").click(function (event) {
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

        refreshStoreIdAfterAjax();

        $(".optionServiceId").click(function (event) {
            refreshStoreIdAfterAjax();
            event.stopPropagation();
            return false;
        });

        $("#storeIdSelectAfter").click(function () {
            refreshStoreIdAfterAjax();
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
        success: refreshServiceIdAjaxoption
    });
}

function refreshStoreIdAjaxOption(dataJsonStore) {
    var storeIdSelectBefore = $("#storeIdSelectBefore");
    storeIdSelectBefore.empty();
    var storeArray = dataJsonStore;
    var htmlContent;
    if (storeArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoStoreBefore'>暂无店铺</option>";
        storeIdSelectBefore.append(htmlContent);
        $("#optionNoStoreBefore").click(function (event) {
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

        var htmlContent2 = "<option value='-1' id='optionNoStoreAfter'>暂无店铺</option>";
        $("#storeIdSelectAfter").empty();
        $("#storeIdSelectAfter").append(htmlContent2);
        $("#storeIdSelectAfter").unbind();
        $("#optionNoStoreAfter").click(function (event) {
            event.stopPropagation();
            return false;
        });
    } else {
        htmlContent = "";
        for (var i = 0; i < storeArray.length; i++) {
            var storeObject = storeArray[i];
            htmlContent = htmlContent + "<option value='"
                + storeObject.storeId + "' class='optionStoreIdBefore'>"
                + storeObject.storeName + "</option>";
        }
        storeIdSelectBefore.append(htmlContent);

        var storeId = $("#storeIdSelectBefore").val();
        refreshServiceIdAjax(storeId);

        $(".optionStoreIdBefore").click(function (event) {
            var storeId = $(this).attr("value");
            refreshServiceIdAjax(storeId);
            event.stopPropagation();
            return false;
        });

        $("#serviceIdSelect").click(function () {
            var storeId = $("#storeIdSelectBefore").val();
            refreshServiceIdAjax(storeId);
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

function checkSerivceId() {
    if ($("#serviceIdSelect").val() != -1
        && $("#serviceNameLabel").val() != ''
        && $("#beforePriceLabel").val() != ''
        && $("#afterPriceLabel").val() != ''
        && $("#costTimeLabel").val() != '') {
        return true;
    } else {
    	alert("有服务信息未填写");
        return false;
    }
}

$(document).ready(function () {
    //表单提交验证

    $("#form1").submit(function () {
        return checkSerivceId();
    });

    //添加加载事件

    refreshStoreIdAjax();

    //添加点击事件
    $("#storeIdSelectBefore").click(function () {
        refreshStoreIdAjax();
    });

});