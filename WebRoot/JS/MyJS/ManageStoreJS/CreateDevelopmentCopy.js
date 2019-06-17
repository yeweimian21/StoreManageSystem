/*
 * useful
 */

function loadStoreIdOption(dataJsonStore) {
    var storeIdSelect = $("#storeIdSelect");
    storeIdSelect.empty();
    var storeArray = dataJsonStore;
    var htmlContent;
    if(storeArray.length==0){
        htmlContent="<option value='-1' id='optionNoStore'>暂无店铺</option>";
        $("#storeIdSelect").append(htmlContent);
        $("#optionNoStore").click(function(event){
            event.stopPropagation();
            return false;
        });
    }else{
        htmlContent = "";
        for (var i = 0; i < storeArray.length; i++) {
            var storeObject = storeArray[i];
            htmlContent = htmlContent + "<option value='"
                + storeObject.storeId + "' class='optionStoreId'>"
                + storeObject.storeName + "</option>";
        }
        storeIdSelect.append(htmlContent);

        $(".optionStoreId").click(function(event){
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

function checkInformation(){
    if($("#developmentTypeLabel").val()!=''
        &&$("#developmenTitleLabel").val()!=''
        &&$("#developmentContentLabel").val()!=''
        &&$("#storeIdSelect").val()!=-1){
        return true;
    }else{
        alert("有动态信息未填写");
        return false;
    }
}

$(document).ready(function () {
    $("#form1").submit(function(){
        return checkInformation();
    });

    refreshStoreIdAjax();

    $("#storeIdSelect").click(function(){
        refreshStoreIdAjax();
    });
});