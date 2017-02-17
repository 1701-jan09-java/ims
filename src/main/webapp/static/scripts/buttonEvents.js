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
        var poObj = createPo(retRow);
        if (poObj !== null) {
            sendCreatePoRequest(poObj);
            uncle.find(".orderLine").each(function(){
                    $(this).remove();
            });
            addOrderLine(uncle);
            updateTotal(uncle);
        }
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
        var numRows = uncle.find(".orderLine").length;
            uncle.find(".orderLine").last().remove();
        if (numRows <= 1 ){
            addOrderLine(uncle);
        }
        var orderDiv = $(this).parents(".MakeOrderInfo");
        updateTotal(orderDiv);
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
    
    var getProdById = function (id) {
        return $.grep(allProducts, function(e){ return e.id == id; })[0];
    };
    
    var addOrderLine = function(orderDiv) {
//        var retId = orderDiv.parents(".RetailRow").attr("id");
//        var id = orderDiv.children(".orderLine").length;
        
        orderDiv.children(".total-row").before('<div class = "btn-group orderLine" role = "group">'+
					'<div class = "col-xs-2 btn-group" role = "group">'+
						'<button type = "button" class = "btn dropdown-toggle" data-toggle="dropdown">'+
						'Product <span class = "caret"></span></button>'+
						'<ul class = "dropdown-menu" role = "menu">'+
							'<li><a href = "#">Product 1</a></li>'+
							'<li><a href = "#">Product 2</a></li>'+
						'</ul>'+
					'</div>'+
					'<div class = "input-group col-xs-10">'+
						'<div class="col-xs-3 text-box"><input class="text-right pid-input form-control" type = "text" /></div>'+
                                                '<div class="col-xs-3 text-box"><input class="text-right unit-cost-display form-control" type = "text" value = "0" readonly="true"/></div>'+
                                                '<div class="col-xs-3 text-box"><input class="text-right qty-input form-control" type = "number" min="1" value="1"/></div>'+
                                                '<div class="col-xs-3 text-box"><input class="text-right line-cost-display form-control" type = "text" value = "0" readonly="true"/></div>'+
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
        	 
        };

    };
    
    var loadProducts = function(data){
    	var menu = $('.productMenu');
    	menu.each(function(index){
    		$.each(data, function(indexB){
    			var name = data[indexB].name;
    			var option = document.createElement("li");
    			var aaa = document.createElement("a");
    			aaa.innerHTML = name;
    			option.append(aaa);
    			menu[index].append(option);
                        allProducts = data;
    		});
    		
    	});
    };
    
    var preLoad = function(group){
    	var tempUrl = "/ims/"+group+"/";
    	$.ajax({
            method: "GET",
            url: tempUrl,
            success: function(data) {
            	loadProducts(data);
            }
    	})
    };
    
	preLoad('product');	
    
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
    
    var checkPidField = function(pidField){
        var prod = getProdById(pidField.val());
        var prodCheck = false;
        console.log(prod);
        if (prod === undefined) {
            pidField.addClass("invalid-input");
        } else {
            pidField.removeClass("invalid-input");
            prodCheck = true;
        }
        
        return prodCheck;
    };
    
    var checkQtyField = function(qtyField) {
        var qty = Number(qtyField.val());
        var qtyCheck = false;
        console.log(qty);
        if (!Number.isInteger(qty) || qty < 1) {
            qtyField.addClass("invalid-input");
        } else {
            qtyField.removeClass("invalid-input");
            qtyCheck = true;
        }
        
        return qtyCheck;
    };
    
    var checkPoFields = function(orderDiv) {
        var pass = true;
        orderDiv.find(".pid-input").each(function(){
            if (checkPidField($(this)) === false) {
                pass = false;
            }
        });
        orderDiv.find(".qty-input").each(function(){
            if (checkQtyField($(this)) === false) {
                pass = false;
            }
            
        });
        if (pass === false) {
            alert("Invalid fields marked in red.");
        }
        return pass;
    }
    
    var createPo = function(retRow) {
        var retId = retRow.attr("id").split("-")[1];
        var supId = 20;
        var orderLines = retRow.find(".orderLine");
        var orderDiv = retRow.find(".MakeOrderInfo");
        if (!checkPoFields(orderDiv) === true){
            console.log("invalid fields");
            return null;
        }
        console.log("all fields passed");
        
        var poObj = {
            retId: retId,
            supId: supId,
            cost: 0,
            lines: []
        };
        
        var PoLine = function(product, qty, cost) {
            // constructor
            this.prodId = product;
            this.cost = cost;
            this.count = qty;
            return this;
        };
        
        for (let i=0;i<orderLines.length;i++) {
            let product = $($(orderLines[i]).find(".pid-input")[0]).val();
            let qty = $($(orderLines[i]).find(".qty-input")[0]).val();
            let cost = getProdById(product).supplierPrice;
            poObj.cost += cost * qty;
            poObj.lines[i] = new PoLine(product,qty,cost);
        }
        
        console.log(poObj);
        
        return poObj;
    };
    
    var updateTotal = function(orderDiv) {
        var total = 0;
        orderDiv.find(".line-cost-display").each(function() {
            total += Number($(this).val());
        });
        console.log(total);
        orderDiv.find(".total-cost-display").val(total);
    }
    
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
    
    $("body").on("focusout", ".pid-input", function() {
        var orderLine = $(this).parents(".orderLine");
        var prod;
        if (checkPidField($(this)) === true) {
            prod = getProdById($(this).val())
            orderLine.find(".unit-cost-display").val(prod.supplierPrice);
            orderLine.find(".line-cost-display").val(
                    prod.supplierPrice * orderLine.find(".qty-input").val()).change();
        }
    });
    
    $("body").on("change", ".qty-input", function() {
        var orderLine = $(this).parents(".orderLine");
       
        if (checkQtyField($(this)) === true) {
            orderLine.find(".line-cost-display").val(
                    orderLine.find(".unit-cost-display").val() *
                    $(this).val()).change();
        }
    });
    
    $("body").on("change", ".line-cost-display", function() {
        var orderDiv = $(this).parents(".MakeOrderInfo");
        updateTotal(orderDiv);
    });

});
