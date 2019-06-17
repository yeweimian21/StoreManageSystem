/*
 * useful
 */

function loadSimpleDevelopmentInformationText(dataJsonSimpleDevelopment) {
    $("#developmentTypeLabel").val(dataJsonSimpleDevelopment.developmentType);
    $("#developmentTitleLabel").val(dataJsonSimpleDevelopment.developmentTitle);
    $("#developmentContentLabel").val(dataJsonSimpleDevelopment.developmentContent);

}

function loadSimpleDevelopmentInformationAjax(developmentId) {
    $.ajax({
        url    : "getSimpleDevelopment",
        data   : {
            developmentIdParamAjax: developmentId
        },
        type   : "POST",
        success: loadSimpleDevelopmentInformationText
    });
}

function selectedStoreIdAjaxOption(dataJsonSimpleDevelopment) {
    var storeId = dataJsonSimpleDevelopment.storeIdSelf;
    var optionStoreIdAfter = $(".optionStoreIdAfter");
    for (var i = 0; i < optionStoreIdAfter.length; i++) {
        optionStoreIdAfter[i].selected = false;
        if ($(optionStoreIdAfter[i]).attr("value") == storeId) {
            optionStoreIdAfter[i].selected = true;
        }
    }

    var developmentId = $("#developmentIdSelect").val();
    loadSimpleDevelopmentInformationAjax(developmentId);
}

function selectedStoreIdAjax(developmentId) {
    $.ajax({
        url    : "getSimpleDevelopment",
        data   : {
            developmentIdParamAjax: developmentId
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

    var developmentId = $("#developmentIdSelect").val();
    selectedStoreIdAjax(developmentId);

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

function refreshDevelopmentIdAjaxoption(dataJsonDevelopment) {
    var developmentIdSelect = $("#developmentIdSelect");
    developmentIdSelect.empty();
    var developmentArray = dataJsonDevelopment;
    var htmlContent;
    if (developmentArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoDevelopment'>暂无动态</option>";
        $("#developmentIdSelect").append(htmlContent);
        $("#optionNoDevelopment").click(function (event) {
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
        for (var i = 0; i < developmentArray.length; i++) {
            developmentObject = developmentArray[i];
            htmlContent = htmlContent + "<option value='"
                + developmentObject.developmentId + "' class='optionDevelopmentId'>"
                + developmentObject.developmentTitle + "</option>"
        }
        developmentIdSelect.append(htmlContent);

        refreshStoreIdAfterAjax();

        $(".optionDevelopmentId").click(function (event) {
            refreshStoreIdAfterAjax();
            event.stopPropagation();
            return false;
        });

        $("#storeIdSelectAfter").click(function () {
            refreshStoreIdAfterAjax();
        });
    }
}

function refreshDevelopmentIdAjax(storeId) {
    $.ajax({
        url    : "getDevelopment",
        data   : {
            storeIdParamAjax: storeId
        },
        type   : "POST",
        success: refreshDevelopmentIdAjaxoption
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

        var htmlContent1 = "<option value='-1' id='optionNoDevelopment'>暂无动态</option>";
        $("#developmentIdSelect").empty();
        $("#developmentIdSelect").append(htmlContent1);
        $("#developmentIdSelect").unbind();
        $("#optionNoDevelopment").click(function (event) {
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
        refreshDevelopmentIdAjax(storeId);

        $(".optionStoreIdBefore").click(function (event) {
            var storeId = $(this).attr("value");
            refreshDevelopmentIdAjax(storeId);
            event.stopPropagation();
            return false;
        });

        $("#developmentIdSelect").click(function () {
            var storeId = $("#storeIdSelectBefore").val();
            refreshDevelopmentIdAjax(storeId);
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

function checkDevelopmentId() {
    if ($("#developmentIdSelect").val() != -1
        && $("#developmentTypeLabel").val() != ''
        && $("#developmenTitleLabel").val() != ''
        && $("#developmentContentLabel").val() != '') {
        return true;
    } else {
    	alert("有动态信息未填写");
        return false;
    }
}

$(document).ready(function () {
    //表单提交验证

    $("#form1").submit(function () {
        return checkDevelopmentId();
    });

    //添加加载事件

    refreshStoreIdAjax();

    //添加点击事件
    $("#storeIdSelectBefore").click(function () {
        refreshStoreIdAjax();
    });

});