var EVENTS = {
    
};

$(document).ready(function() {

    var allProducts;
    var productNames = [];

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
    });
    
    $("body").on("click", ".removeThisLine", function() {
        var productOrder = $(this).parents(".productOrder");
        if (productOrder.find(".orderLine").length === 1) {
            addOrderLine(productOrder);
        }
        $(this).parents(".orderLine").remove();
        updateTotal(productOrder);
    });
    
    $("body").on("click", ".clearOrderForm", function(){
        var orderDiv = $(this).parents(".MakeOrderInfo")
        orderDiv.find(".orderLine").remove();
        addOrderLine(orderDiv);
    });
    
    $("body").on("click", ".makeOrderButton", function(){
        
    	var grandparent = $(this).parent().parent();
        
        grandparent.find(".orderLine").length>0 || addOrderLine(grandparent.find(".productOrder"));
        
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
        return $.grep(allProducts, function(e){ return e.id === Number(id); })[0];
    };
    
    var getProdByName = function (name) {
        return $.grep(allProducts, function(e){ return e.name === name; })[0];
    };
    
    var addOrderLine = function(orderDiv) {
        
        orderDiv.find(".total-row").before('<div class = "btn-group orderLine" role = "group">'+
					'<div class = "input-group col-xs-12">'+
                                 '<div class="col-xs-3 text-box"><div class="ui-widget"><input class="product-input form-control"></div></div>' +
                                 '<div class="col-xs-2 text-box"><input class="text-right pid-input form-control" type = "text" /></div>'+
                                 '<div class="col-xs-2 text-box"><input class="text-right unit-cost-display form-control" type = "text" value = "0" readonly="true"/></div>'+
                                 '<div class="col-xs-2 text-box"><input class="text-right qty-input form-control" type = "number" min="1" value="1"/></div>'+
                                 '<div class="col-xs-2 text-box"><input class="text-right line-cost-display form-control" type = "text" value = "0" readonly="true"/></div>'+
                                 '<div class="col-xs-1 text-right"><button title="Remove This Line" class="btn btn-danger sm-button removeThisLine">x</button></div>'+                                
					'</div>'+
                                        
				'</div>');
       
       $( ".product-input" ).autocomplete({
    	   source: productNames,
    	   autoFocus: true
           
       });
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
    
    var updateViewPurchaseOrderByRetailer = function(data, row) {
    	var myRow = row;
    	var newRow = $("<div class='orderTable container-fluid'></div>");
    	console.log(data);
    	console.log(newRow);
    	
    	
    	newRow.append("<div class='col-sm-1'>ID</div>");
    	newRow.append("<div class='col-sm-2'>Date</div>");
    	newRow.append("<div class='col-sm-3'>Supplier Name</div>");
    	newRow.append("<div class='col-sm-3'>Product Name</div>");
    	newRow.append("<div class='col-sm-2'>Quantity</div>");
    	newRow.append("<div class='col-sm-1'>Cost</div>");
    	
        for (i=0; i<data.length; i++) {
        	
        	newRow.append("<div class='col-sm-1'>"+data[i].purchaseOrder.id+"</div>");
        	newRow.append("<div class='col-sm-2'>"+data[i].purchaseOrder.purchaseDate+"</div>");
        	newRow.append("<div class='col-sm-3'>"+data[i].purchaseOrder.supplier.name+"</div>");
        	console.log(data[i].product);
        	console.log(data[i].product.name);
        	newRow.append("<div class='col-sm-3'>"+data[i].product.name+"</div>");
        	newRow.append("<div class='col-sm-2'>"+data[i].quantity+"</div>");
        	newRow.append("<div class='col-sm-1'>"+data[i].cost+"</div>");
        	 
        }
        myRow.append(newRow);

    };
    
    var loadProducts = function(data){
        allProducts = data;
        $.each(data, function(){
        	productNames.push(this.name);
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
    	});
    };
    
	preLoad('product');	
    
    var sendRequest = function (group,id,row) {
        var tempUrl = "/ims/"+group+"/";
        var myRow = row;
        
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
                } else if(group === "purchase-order-line/po") {
                	updateViewPurchaseOrderByRetailer(data,myRow);
                }

            },

            failure: function() {
                setTimeout(function(){productRequest(group,id);},2000);
            }
        });
    };
    
    var checkProdField = function(prodField){
        var prod = getProdByName(prodField.val());
        var prodCheck = false;
        if (prod === undefined) {
            prodField.addClass("invalid-input");
        } else {
            prodField.removeClass("invalid-input");
            prodCheck = true;
        }
        
        return prodCheck;
    };
    
    var checkPidField = function(pidField){
        var prod = getProdById(pidField.val());
        var prodCheck = false;
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
    };
    
    var createPo = function(retRow) {
        var retId = retRow.find("p").html();
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
        orderDiv.find(".total-cost-display").val(total);
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

    var prodInputFunc = function(prodInput) {
        var orderLine = $(prodInput).parents(".orderLine");
        var prod;
        if (checkProdField($(prodInput)) === true) {
            prod = getProdByName($(prodInput).val());
            orderLine.find(".pid-input").val(prod.id);
            checkPidField(orderLine.find(".pid-input"));
            orderLine.find(".unit-cost-display").val(prod.supplierPrice);
            orderLine.find(".line-cost-display").val(
                    prod.supplierPrice * orderLine.find(".qty-input").val()).change();
        }
    };
    
    $("body").on("change autocompleteselect focusout keypress", ".product-input", function(event) {
        if (event.key && (event.key !== "Enter")) return;
            setTimeout(() => prodInputFunc(this),10);
    });
    
    $("body").on("focusout keypress", ".pid-input", function(event) {
        if (event.key && (event.key !== "Enter")) return;
        var orderLine = $(this).parents(".orderLine");
        var prod;
        if (checkPidField($(this)) === true) {
            prod = getProdById($(this).val());
            orderLine.find(".product-input").val(prod.name);
            checkProdField(orderLine.find(".product-input"));
            orderLine.find(".unit-cost-display").val(prod.supplierPrice);
            orderLine.find(".line-cost-display").val(
                    prod.supplierPrice * orderLine.find(".qty-input").val()).change();
        }
    });
    
    $("body").on("change focusout keypress", ".qty-input", function() {
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

    $(".ordersButton").click(function(){
    	var ancestor = $(this).parent().parent();
    	if(!ancestor.children().hasClass("orderTable")) {
	    	var uncle;
	    	var id;
	    	var grandparent;
	    	
	    	if(ancestor.hasClass("RetailRow")) {
		    	uncle = $(this).parents('.RetailRow').find('.myID');
		    	id = uncle.html();
		    	grandparent = $(this).parents('.RetailRow');
	    	} else {
	    		uncle = $(this).parents('.RetailRowClone').find('.myID');
		    	id = uncle.html();
		    	console.log(id);
		    	console.log(uncle);
		    	grandparent = $(this).parents('.RetailRowClone');
	    	}
    	
    	
    		sendRequest("purchase-order-line/po", id, grandparent);
    	}
    });
});
