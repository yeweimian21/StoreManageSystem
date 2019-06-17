/*
 * useful
 */

function loadStoreInformationTable(dataJsonStore) {
    var storeTableOuter = $("#storeTableOuter");
    storeTableOuter.empty();
    var storeArray = dataJsonStore;
    var htmlContent = "";
    for (var i = 0; i < storeArray.length; i++) {
        storeObject = storeArray[i];
        htmlContent = htmlContent + "<tr>"
            + "<td>" + storeObject.storeId + "</td>"
            + "<td>" + storeObject.storeName + "</td>"
            + "<td>" + storeObject.managerName + "</td>"
            + "<td>" + storeObject.storeAddress + "</td>"
            + "<td>" + storeObject.storePhone + "</td>"
            + "</tr>";
    }
    storeTableOuter.append(htmlContent);
}

function loadStoreInformationTableAjax() {
    $.ajax({
        url    : "getStore",
        type   : "POST",
        success: loadStoreInformationTable
    });
}

$(document).ready(function () {
    loadStoreInformationTableAjax();
});