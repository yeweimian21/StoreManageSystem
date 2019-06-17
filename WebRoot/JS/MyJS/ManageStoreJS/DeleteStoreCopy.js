/*
 * useful
 */

function loadStoreIdOption(dataJsonStore) {
    var storeIdSelect = $("#storeIdSelect");
    storeIdSelect.empty();
    var storeArray = dataJsonStore;
    var htmlContent;
    if (dataJsonStore.length == 0) {
        htmlContent = "<option value='-1' id='optionNostore'>暂无店铺</option>"
        $("#storeIdSelect").append(htmlContent);
        $("#optionNostore").click(function (event) {
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
        $(".optionStoreId").click(function (event) {
            event.stopPropagation();
            return false;
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

function checkStoreId() {
    if($("#storeIdSelect").val()==-1){
        alert("暂无店铺");
        return false;
    }else{
        return true;
    }
}

$(document).ready(function () {
    $("#form1").submit(function () {
        return checkStoreId();
    });

    refreshStoreIdAjax();

    $("#storeIdSelect").click(function(){
        refreshStoreIdAjax();
    });
});