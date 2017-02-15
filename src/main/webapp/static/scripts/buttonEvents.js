var EVENTS = {
    
};

var saleButton;
var orderButton;

$(document).ready(function() {

    $('.dropdown-toggle').dropdown();
    
    $('.inventoryButton').on('click', function(){
    	var view = $('#ResultsView');
    	var row = $('.RetailRow');
    	var clone = row.clone(true);
    	clone.removeClass('RetailRow');
    	clone.addClass('RetailRowClone');
    	view.append(clone);
    });
    
    $('.submitOrder').on('click', function(){
    	var uncle = $(this).parents('.MakeOrderInfo').find(".productOrder");
    	uncle.find(".orderClone").each(function(){
    		$(this).remove();
    	})
    });
    
    $('.addLine').on('click',function(){
    	
		var uncle = $(this).parents('.MakeOrderInfo').find(".productOrder");
		var elmnt = uncle.find(".orderLine");
    	var clone = elmnt.clone(true);
    	clone.removeClass("orderLine");
    	clone.addClass("orderClone");

		uncle.append(clone);
		
    });
    
    $('.removeLine').on('click',function(){
    	var uncle = $(this).parents('.MakeOrderInfo').find(".productOrder");
    	$('.orderClone:last-child', uncle).remove();
    });
    
    $('.makeOrderButton').click(function(){
    	var grandparent = $(this).parent().parent();
    	
    	if(grandparent.hasClass('RetailRow')){
	    	var uncle = $(this).parents('.RetailRow').find(".MakeOrderInfo");
	    	var saleUncle = $(this).parents('.RetailRow').find(".MakeSaleInfo");
    	} else {
    		var uncle = $(this).parents('.RetailRowClone').find(".MakeOrderInfo");
	    	var saleUncle = $(this).parents('.RetailRowClone').find(".MakeSaleInfo");
    	}
    	if(uncle.hasClass('hidden')){
    		uncle.removeClass('hidden');
    	} else {
    		uncle.addClass('hidden');
    	}
    	
    	if(!saleUncle.hasClass('hidden')){
    		saleUncle.addClass('hidden');
    	}
    });
    
    $('.makeSaleButton').click(function(){
    	var grandparent = $(this).parent().parent();
    	
    	if(grandparent.hasClass('RetailRow')){
	    	var uncle = $(this).parents('.RetailRow').find(".MakeSaleInfo");
	    	var orderUncle = $(this).parents('.RetailRow').find(".MakeOrderInfo");
    	} else {
    		var uncle = $(this).parents('.RetailRowClone').find(".MakeSaleInfo");
	    	var orderUncle = $(this).parents('.RetailRowClone').find(".MakeOrderInfo");
    	}
    	if(uncle.hasClass('hidden')){
    		uncle.removeClass('hidden');
    	} else {
    		uncle.addClass('hidden');
    	}
    	
    	if(!orderUncle.hasClass('hidden')){
    		orderUncle.addClass('hidden');
    	}
    });
    
    EVENTS.viewArea = $("#ResultsView");
    
    var updateViewProducts = function(data){
        EVENTS.viewArea.empty();
        EVENTS.viewArea.append("<div class='col-xs-2'>Product ID</div>");
        EVENTS.viewArea.append("<div class='col-xs-4'>Product Name</div>");
        EVENTS.viewArea.append("<div class='col-xs-6'>Categories</div>");
        var i = 0;
        var n = 0;
        for (i=0; i<data.length; i++) {
            EVENTS.viewArea.append("<div class='col-xs-2'>"+data[i].id+"</div>");
            EVENTS.viewArea.append("<div class='col-xs-4'>"+data[i].name+"</div>");
            EVENTS.viewArea.append("<div id='categories"+i+"' class='col-xs-6'></div>");
            var a = $("#categories"+i);
            console.log(a); 
            if (data[i].categories.length === 0) {
                a.html("&ltNone&gt");
            } else {
                for (n=0; n<data[i].categories.length; n++) {
                    a.html(a.html()+data[i].categories[n].c_name);
                    if (n<data[i].categories.length-1) {
                        a.html(a.html()+", ");
                    }
            }
            };
        }
        
    };
    
    var updateViewCategories = function(data){
        EVENTS.viewArea.empty();
        EVENTS.viewArea.append("<div class='col-xs-2'>Category ID</div>");
        EVENTS.viewArea.append("<div class='col-xs-4'>Category Name</div>");
        EVENTS.viewArea.append("<div class='col-xs-6'>Products</div>");
        var i = 0;
        var n = 0;
        for (i=0; i<data.length; i++) {
            EVENTS.viewArea.append("<div class='col-xs-2'>"+data[i].id+"</div>");
            EVENTS.viewArea.append("<div class='col-xs-4'>"+data[i].name+"</div>");
            EVENTS.viewArea.append("<div id='products"+i+"' class='col-xs-6'></div>");
            var a = $("#products"+i);
            console.log(a); 
            if (data[i].products.length === 0) {
                a.html("&ltNone&gt");
            } else {
                for (n=0; n<data[i].products.length; n++) {
                    a.html(a.html()+data[i].products[n].name);
                    if (n<data[i].products.length-1) {
                        a.html(a.html()+", ");
                    }
            }
            };
        }
        
    };
    
    var sendRequest = function (group,id) {
        var tempUrl = "/ims/"+group+"/";
        
        if (id) {
            tempUrl += id;
        }
        
        $.ajax({
            method: "GET",
            url: tempUrl,

            success: function(data) {
                console.log(data);
                if (group === "product") {
                    updateViewProducts(data);
                } else if (group === "category") {
                    updateViewCategories(data);
                }

            },

            failure: function() {
                setTimeout(function(){productRequest(group,id);},2000);
            }
        });
    };
    
    $("#prodById").click(function(){
        var input = $("#idInput").val();
        console.log(input);
        if ($.isNumeric(input)) {
            var id = input;
            sendRequest("product",id);
        } else console.log("Invalid Entry");
    });
    
    $("#productsButton").click(function(){
        sendRequest("product");
    });
    
    $("#catById").click(function(){
        var input = $("#idInput").val();
        console.log(input);
        if ($.isNumeric(input)) {
            var id = input;
            sendRequest("category",id);
        } else console.log("Invalid Entry");
    });
    
    $("#categoriesButton").click(function(){
        sendRequest("category");
    });
});
