var EVENTS = {
    
};

var saleButton;
var orderButton;

$(document).ready(function() {

    var allProducts;

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
    	var retRow = $(this).parents(".RetailRow");
        createPo(retRow);
        uncle.find(".orderLine").each(function(){
    		$(this).remove();
    	});
        addOrderLine(uncle);
    });
    
    $('.addLine').on('click',function(){
    	
        addOrderLine($(this).parents('.MakeOrderInfo').find(".productOrder"));
//		var uncle = $(this).parents('.MakeOrderInfo').find(".productOrder");
//		var elmnt = uncle.find(".orderLine");
//    	var clone = elmnt.clone(true);
//    	clone.removeClass("orderLine");
//    	clone.addClass("orderClone");
//
//		uncle.append(clone);
		
    });
    
    $('.removeLine').on('click',function(){
    	var uncle = $(this).parents('.MakeOrderInfo').find(".productOrder");
        if (uncle.find(".orderLine").length > 1 ){
            $('.orderLine:last-child', uncle).remove();
        }
//        $('.orderClone:last-child', uncle).remove();
    });
    
    $('.makeOrderButton').click(function(){
        
    	var grandparent = $(this).parent().parent();
        
        addOrderLine(grandparent.find(".productOrder"));
        
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
    
    var addOrderLine = function(orderDiv) {
        var retId = orderDiv.parents(".RetailRow").attr("id");
        var id = orderDiv.children(".orderLine").length;
        var orderLineId = retId+'-POL-'+id;
        
        orderDiv.append('<div id="'+orderLineId+'" class = "btn-group orderLine" role = "group">'+
					'<div class = "col-md-2 btn-group" role = "group">'+
						'<button type = "button" class = "btn dropdown-toggle" data-toggle="dropdown">'+
						'Product <span class = "caret"></span></button>'+
						'<ul class = "dropdown-menu" role = "menu">'+
							'<li><a href = "#">Product 1</a></li>'+
							'<li><a href = "#">Product 2</a></li>'+
						'</ul>'+
					'</div>'+
					'<div class = "input-group col-md-10">'+
						'<div class="col-md-3 text-box"><input class="text-right pid-input form-control" type = "text" /></div>'+
                                                '<div class="col-md-3 text-box"><input class="text-right form-control" type = "text" value = "0" disabled="disabled"/></div>'+
                                                '<div class="col-md-3 text-box"><input class="text-right qty-input form-control" type = "text" value="0"/></div>'+
                                                '<div class="col-md-3 text-box"><input class="text-right form-control" type = "text" value = "0" disabled="disabled"/></div>'+
					'</div>'+
				'</div>');
    };
    
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
    
    var updateViewRetailers = function(data) {
    	
    	EVENTS.viewArea.empty();
    	EVENTS.viewArea.append("<div class='col-xs-2'>Retailer ID</div>");
    	EVENTS.viewArea.append("<div class='col-xs-4'>Retailer Name</div>");
        EVENTS.viewArea.append("<div class='col-xs-6'>Address</div>");
        var i = 0;
        var n = 0;
        var fullAddr = "";
        
        for (i=0; i<data.length; i++) {
        	 EVENTS.viewArea.append("<div class='col-xs-2'>"+data[i].id+"</div>");
             EVENTS.viewArea.append("<div class='col-xs-4'>"+data[i].name+"</div>");
             EVENTS.viewArea.append("<div id='address"+i+"' class='col-xs-6'></div>");
             
             var a = $("#address"+i);
             console.log(a);
             if(data[i].address.length === 0) {
            	 a.html("&ltNone&gt");            	 
             } else {
            	
            	fullAddr = data[i].address.street + " " + data[i].address.city + " " +
            		 	   data[i].address.state + " " + data[i].address.zip;
            	a.html(a.html() + fullAddr);
            	 
             };
        }    	
    };
    
    var updateViewSales = function(data) {
    	
    	EVENTS.viewArea.empty();
    	EVENTS.viewArea.append("<div class='col-sm-2'>Sale ID</div>");
    	EVENTS.viewArea.append("<div class='col-sm-3'>Retailer Name</div>");
        EVENTS.viewArea.append("<div class='col-sm-3'>Product Name</div>");
        EVENTS.viewArea.append("<div class='col-sm-1'>Quantity</div>");
        EVENTS.viewArea.append("<div class='col-sm-1'>Cost</div>");
        EVENTS.viewArea.append("<div class='col-sm-2'>Sale Date</div>");
    	
        for (i=0; i<data.length; i++) {
        	
        	 EVENTS.viewArea.append("<div class='col-sm-2'>"+data[i].id+"</div>");
        	 EVENTS.viewArea.append("<div id='retailer"+i+"' class='col-sm-3'></div>");
        	 EVENTS.viewArea.append("<div id='product"+i+"' class='col-sm-3'></div>");
        	 EVENTS.viewArea.append("<div class='col-sm-1'>"+data[i].productQuantity+"</div>");
        	 EVENTS.viewArea.append("<div class='col-sm-1'>"+data[i].cost+"</div>");
        	 EVENTS.viewArea.append("<div class='col-sm-2'>"+data[i].saleDate+"</div>");
        	 
        	 var r = $("#retailer"+i);
        	 console.log(r);
        	 var p = $("#product"+i);
        	 console.log(p);
        	 
        	 r.html(r.html()+data[i].retailer.name);
        	 p.html(p.html()+data[i].product.name);
        	 
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
                    allProducts = data;
//                    updateViewProducts(data);
                } else if (group === "category") {
                    updateViewCategories(data);
                } else if(group === "retailer") {
                	updateViewRetailers(data);
                } else if(group === "sale") {
                	updateViewSales(data);
                }

            },

            failure: function() {
                setTimeout(function(){productRequest(group,id);},2000);
            }
        });
    };
    
    var createPo = function(retRow) {
        var retId = retRow.attr("id").split("-")[1];
        var supId = 123;
        var orderLines = retRow.find(".orderLine");
        var product;
        var qty;
        var cost = 500;
        
        var poObj = {
            retId: retId,
            supId: supId,
            cost: cost,
            lines: []
        };
        
        for (let i=0;i<orderLines.length;i++) {
            product = $($(orderLines[i]).find(".pid-input")[0]).val();
            qty = $($(orderLines[i]).find(".qty-input")[0]).val();
            console.log(product);
            console.log(qty);
            poObj.
        }
        
        
        
    };
    
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
                    // TODO tell user it succeeded or failed
                    console.log("successful");
                } else console.log("failed");
            }
        });
    };
    
    var getProdById = function (id) {
        return $.grep(allProducts, function(e){ return e.id == id; })[0];
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
    
    $("#retailersButton").click(function(){
    	sendRequest("retailer");
    });
    
    $("#salesButton").click(function(){
    	sendRequest("sale");
    });
    
    sendRequest("product");
    setTimeout(function(){
        getProdById(100);
    },1000);
});
