function loadHtmlDisplay(dataJsonRight) {
    var rightArray = dataJsonRight;
    var storeRightFlag = rightArray.storeRightFlag;
    if(storeRightFlag=="AllStore"){

    }else if(storeRightFlag=="SelfStore"){

    }else{
        $("#storeMenu").remove();
    }
}

function getCheckDisplayAjax() {
    $.ajax({
        url    : "getCheckDisplay",
        type   : "POST",
        success: loadHtmlDisplay
    });
}

$(document).ready(function(){
    getCheckDisplayAjax();
});