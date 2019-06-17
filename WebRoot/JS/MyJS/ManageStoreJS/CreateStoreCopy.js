/*
 * useful
 */

function loadManagerIdOption(dataJsonManager) {
    var managerIdSelect = $("#managerIdSelect");
    managerIdSelect.empty();
    var managerArray = dataJsonManager;
    var htmlContent;
    if (managerArray.length == 0) {
        htmlContent = "<option value='-1' id='optionNoManager'>暂无店长</option>";
        $("#managerIdSelect").append(htmlContent);
        $("#optionNoManager").click(function (event) {
            event.stopPropagation();
            return false;
        });
    } else {
        htmlContent = "";
        for (var i = 0; i < managerArray.length; i++) {
            var managerObject = managerArray[i];
            htmlContent = htmlContent + "<option value='"
                + managerObject.userId + "' class='optionManagerId'>"
                + managerObject.userName + "</option>"
        }
        managerIdSelect.append(htmlContent);

        $(".optionManagerId").click(function (event) {
            event.stopPropagation();
            return false;
        });
    }

}

function refreshManagerIdAjax() {
    $.ajax({
        url    : "getSimpleRoleUserMix",
        data   : {
            roleNameParamAjax: "Manager"
        },
        type   : "POST",
        success: loadManagerIdOption
    });
}

function checkInformation() {
    if ($("#storeNameLabel").val() != ''
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
        return checkInformation();
    });

    refreshManagerIdAjax();

    $("#managerIdSelect").click(function () {
        refreshManagerIdAjax();
    });
});