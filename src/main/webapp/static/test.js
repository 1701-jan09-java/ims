var TEST = {
    Products: {}
};

$(document).ready(function() {
    var sendRequest = function (group,id) {
        var tempUrl = "/ims/"+group+"/";
        
        if (id) {
            tempUrl += id;
        }
        
        $.ajax({
            method: "GET",
            url: tempUrl,

            success: function(data) {
                TEST.Products = data;
                console.log(data);
            },

            failure: function() {
                setTimeout(function(){productRequest(id);},2000);
            }
        });
    };
    
    $("#prodById").click(function(){
        console.log("hi");
        var input = $("#idInput").val();
        console.log(input);
        if ($.isNumeric(input)) {
            var id = input;
            sendRequest("product",id);
        } else console.log("Invalid Entry");
    });
    
    $("#allProd").click(function(){
        console.log("hi");
        sendRequest("product");
    });
    
    $("#catById").click(function(){
        console.log("hi");
        var input = $("#idInput").val();
        console.log(input);
        if ($.isNumeric(input)) {
            var id = input;
            sendRequest("category",id);
        } else console.log("Invalid Entry");
    });
    
    $("#allCat").click(function(){
        console.log("hi");
        sendRequest("category");
    });
});
