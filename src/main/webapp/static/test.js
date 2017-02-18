var TEST = {
    Products: {}
};

$(document).ready(function() {
    
    var sendCreatePoRequest = function (poObj) {
        var url = "/ims/purchase-order";
        var jsonData = JSON.stringify(poObj);
        console.log(jsonData);
        
        $.ajax({
            method: "POST",
            url: url,
            contentType: "application/json; charset=utf-8",
            processData: false,
            data: jsonData,
            
            success: function(data) {
                if (data === true) {
                    console.log("successful");
                } else console.log("failed");
            }
        });
    };
    
    var testPo = {
        "retId":5,
        "supId":100,
        "cost": 550,
        "lines":
                [{
                    "prodId":100,
                    "count":10,
                    "cost":500
                },
                {
                    "cost":50,
                    "count":1,
                    "prodId":200
                }]
    };
    
    sendCreatePoRequest(testPo);
    
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
                setTimeout(function(){productRequest(group,id);},2000);
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
        sendRequest("category");
    });
});
