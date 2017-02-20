var EVENTS_INITIALIZE = {
    timeout: 20, // minutes
    authenticated: false
};

var EVENTS = $.extend(true, {}, EVENTS_INITIALIZE);

$(document).ready(function() {

    var allProducts;
    var productNames = [];
    var appendSups = false;
    var notice = "";
    
    $.get("login").done(function(data){
        if (data === true) {
            loginEvent();
        } else {
            EVENTS.authenticated = false;
            $("#login-view").removeClass("hidden");
            EVENTS.currentView = "#login-view";
        }
    });
    
    $('.dropdown-toggle').dropdown();
    
    // To notify user when a retailer has a product below a certain threshold on welcome page 
    function inventoryCheck() {
    	
    	 $.ajax({
    	        method: "GET",
    	        url: "/ims/retailer",
    	        success: function(data) {
    	        	
    	        	for (i = 0; i < data.length+1; i++) {
    	        		checkInventory(i);
    	        	}
    	        	
    	        }
    	 });
    	 	    	
    }    
 
    
    function checkInventory(input) {
    	
    	$.ajax({
    		
    		method: "GET",
            url: "/ims/inventory/"+input,
    		success: function(data) {
    			EVENTS.updateTimeout();
    			console.log(data);
    			
    			for (i = 0; i < data.length; i++) {
    				
    				if(data[i].productQuantity < data[i].productThreshold) {   					
    					
    					console.log("checking");
    					// this notice variable is for more verbose alert display
//    					notice = "INVENTORY ALERT--RETAILER: " + data[i].retailer.name + "--PRODUCT: " + data[i].product.name + " " +
//    							"--STOCK AMT: " + data[i].productQuantity + "--THRESHOLD: " 
//    							+ data[i].productThreshold + ". ------ ORDER NEEDED: " + (data[i].productThreshold-data[i].productQuantity)+" units." ;
    					
    					alerter = (("INVENTORY ALERT! ").bold()).big();
    					retailer = "Retailer: " + ((data[i].retailer.name).bold()).big();
    					product = "-- Product: " + ((data[i].product.name).bold()).big() + "-- STOCK AMT: " + data[i].productQuantity + " --- ";
    					minOrderAmount = (((data[i].productThreshold-data[i].productQuantity).toString()).bold()).big();
    					notice = " UNITS BELOW THRESHOLD";
    					var alert = $("#Notification");
    					alert.html(alert.html()+ alerter + retailer + product + minOrderAmount + notice);
    					
//    					alert.html(alert.html()+ notice); used with longer notice above			
    					alert.html(alert.html()+"<br/>");
    					$("#Notification").removeClass("hidden");
    				}
    				
    			}
    			
    		}
    	});
    	
    }    	
   
    
    $('body').on('click', '.supplierDropdown', function() {
    	
    	if (appendSups === false) {
    		
    		showingSups();    		
    	}    	
    });
    
    $('body').on('click','.submitOrder', function(){
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
    
    $('body').on('click','.addLine',function(){
        addOrderLine($(this).parents('.MakeOrderInfo').find(".productOrder"));		
    });
    
    $('body').on('click','.removeLine',function(){
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
        var orderDiv = $(this).parents(".MakeOrderInfo");
        orderDiv.find(".orderLine").remove();
        addOrderLine(orderDiv);
        updateTotal(orderDiv);
    });
    
    $("body").on("click", ".makeOrderButton", function(){
        console.log(this);
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
    
    getSupByName = function (name) {
        if (!EVENTS.allSuppliers) return undefined;
        return $.grep(EVENTS.allSuppliers, function(e){ return e.name === name; })[0];
    };
    
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
                                 '<div class="col-xs-2 text-box"><input class="text-right unit-cost-display form-control" type = "text" value = "$0" readonly="true"/></div>'+
                                 '<div class="col-xs-2 text-box"><input class="text-right qty-input form-control" type = "number" min="1" value="1"/></div>'+
                                 '<div class="col-xs-2 text-box"><input class="text-right line-cost-display form-control" type = "text" value = "$0" readonly="true"/></div>'+
                                 '<div class="col-xs-1 text-right"><button title="Remove This Line" class="btn btn-danger sm-button removeThisLine">x</button></div>'+                                
					'</div>'+
                                        
				'</div>');
       
       $( ".product-input" ).autocomplete({
    	   source: productNames,
    	   autoFocus: true
           
       });
    };
    
    $('body').on('click','.makeSaleButton',function(){
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
    

	//EVENTS.viewArea = $("#ResultsView");
    

    var updateViewProducts = function(data){
        var viewArea = $("#ProductsView");
        viewArea.empty();
        viewArea.append(
            "<div class='row'>"+
                "<div class='col-xs-2'><b>Product ID</b></div>"+
                "<div class='col-xs-4'><b>Product Name</b></div>"+
                "<div class='col-xs-6'><b>Category</b></div>"+
            "</div>");
        var i = 0;
        var n = 0;
        for (i=0; i<data.length; i++) {
            viewArea.append(
                "<div class='row'>"+
                    "<div class='col-xs-2'>"+data[i].id+"</div>"+
                    "<div class='col-xs-4'>"+data[i].name+"</div>"+
                    "<div id='categories"+i+"' class='col-xs-6'></div>"+
                "</div>");
            var a = $("#categories"+i);
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
    
//    var updateViewCategories = function(data){
//        EVENTS.viewArea.empty();
//        EVENTS.viewArea.append("<div class='col-xs-2'>Category ID</div>");
//        EVENTS.viewArea.append("<div class='col-xs-4'>Category Name</div>");
//        EVENTS.viewArea.append("<div class='col-xs-6'>Products</div>");
//        var i = 0;
//        var n = 0;
//        for (i=0; i<data.length; i++) {
//            EVENTS.viewArea.append("<div class='col-xs-2'>"+data[i].id+"</div>");
//            EVENTS.viewArea.append("<div class='col-xs-4'>"+data[i].name+"</div>");
//            EVENTS.viewArea.append("<div id='products"+i+"' class='col-xs-6'></div>");
//            var a = $("#products"+i);
//            console.log(a); 
//            if (data[i].products.length === 0) {
//                a.html("&ltNone&gt");
//            } else {
//                for (n=0; n<data[i].products.length; n++) {
//                    a.html(a.html()+data[i].products[n].name);
//                    if (n<data[i].products.length-1) {
//                        a.html(a.html()+", ");
//                    }
//            }
//            };
//        }
//        
//    };
    
    var updateViewSales = function(data) {
    	var viewArea = $("#SalesView");
    	viewArea.empty();
        viewArea.append(
            "<div class='row'>"+
//                "<div class='col-sm-1'><b>Sale ID</b></div>"+
                "<div class='col-sm-3'><b>Retailer Name</b></div>"+
                "<div class='col-sm-3'><b>Product Name</b></div>"+
                "<div class='col-sm-2'><b>Quantity</b></div>"+
                "<div class='col-sm-1'><b>Cost</b></div>"+
                "<div class='col-sm-2'><b>Sale Date</b></div>"+
            "</div>");
    	
        for (i=0; i<data.length; i++) {
            viewArea.append(
                "<div class='row'>"+
//                    "<div class='col-sm-1'>"+data[i].id+"</div>"+
                    "<div id='retailer"+i+"' class='col-sm-3'></div>"+
                    "<div id='product"+i+"' class='col-sm-3'></div>"+
                    "<div class='col-sm-2'>"+data[i].productQuantity+"</div>"+
                    "<div class='col-sm-1'>$"+((data[i].cost)/100).toString()+"</div>"+
                    "<div class='col-sm-2'>"+data[i].saleDate+"</div>"+
                "</div>");
        	 
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
                EVENTS.updateTimeout();
            	loadProducts(data);
            }
    	});
    };	
    
    function showingSups() {
		
		$.ajax({
			
            method: "GET",
            url: "/ims/supplier",
            
            success: function(data) {
            	EVENTS.updateTimeout();
                EVENTS.allSuppliers = data;
            	var allSuppliers = '';
        		$.each(data, function(index, value) {
        		    allSuppliers += '<li><a href = "#">' + value.name + '</a></li>';
        		});

        		$('.dropdown-menu').append(allSuppliers);
            	
        		appendSups = true;
        		
            	} 
		});
		
	}
	
	$(document).on('click', '.dropdown-menu li a', function() {
                var retRow = $(this).parents(".RetailRow");
                console.log(retRow);
		$(retRow.find('#datebox')).val($(this).html());
                
		var supName = $(this).html();
        checkSupField($(retRow.find('#datebox')));
		console.log(supName);
		
		//var x = getSupId(supName);
		//console.log(x);
	});
	
	function getSupId(supName) {
		
		var x = 0;
		
		$.ajax({
		
			async: false,
            method: "GET",
            url: "/ims/supplier",
            
            success: function(data) {
            	EVENTS.updateTimeout();
            	for (i = 0; i < data.length; i++) {
            		
            		if(data[i].name === supName) {
            			
            			console.log(data[i].id);            			
            		
            			x = data[i].id
            		}
            	}
            	
            }
            
		});
		
		return x;
		
	}

    
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
                EVENTS.updateTimeout();
                console.log(data);
                if (group === "product") {
                    allProducts = data;
                    updateViewProducts(data);
                } else if (group === "category") {
                    updateViewCategories(data);
                } else if(group === "retailer") {
//                	updateViewRetailers(data);
                } else if(group === "sale") {
                	updateViewSales(data);
                } else if(group === "purchase-order-line/po") {
                	updateViewPurchaseOrderByRetailer(data,myRow);
                }

            },

        });
    };

    EVENTS.updateTimeout = () => EVENTS.lastActionTimeStamp = Date.now();
    
    var checkIdle = function() {
        console.log(Date.now() - EVENTS.lastActionTimeStamp);
        if (Date.now() - EVENTS.lastActionTimeStamp > EVENTS.timeout*60000) {
            EVENTS.authenticated = false;
            EVENTS.logout("Session timeout.");
        } else if (Date.now() - EVENTS.lastActionTimeStamp > EVENTS.timeout*60000-120000) {
            alert("2 Minutes Until Idle Logout.")
            EVENTS.checkLogin();
        }
            
    };
    
    var loginEvent = function () {
        EVENTS.authenticated = true;
        EVENTS.timerInterval = setInterval(checkIdle,1000);
        EVENTS.updateTimeout();
        preLoad('product');
        changeView("#Welcome");
        $("#username").html(EVENTS.user);
        $("#logout-button, #username").removeClass("hidden");
        $("#openNavBar").removeAttr("disabled");
        inventoryCheck();
    };
    
    var changeView = function(newViewId) {
    	
        var exists = false;
        for (let value of pageMap.values()) {
            value === newViewId && (exists = true);
        }
        if (exists) {
            $(EVENTS.currentView).addClass("hidden");
            EVENTS.currentView = newViewId;
            $(EVENTS.currentView).removeClass("hidden");
        } else throw "Error: Page does not exist in pageMap.";
    };
    
    EVENTS.login = function() {
        $("#login-button").val("Authenticating...");
        var loginObj = {};
        loginObj.username = $("#user-input").val();
        loginObj.password = $("#pass-input").val();
//        sendLoginRequest(loginObj);
        $.post("/ims/login/",loginObj).done(function(data){
            console.log(data);
            if (data === true) {
                EVENTS.user = loginObj.username;
                loginEvent();
            } else $(".error").removeClass("hidden");
        });
    };
    
    EVENTS.logout = function(cause) {
        $.post("/ims/logout");
        location.reload();
        clearInterval(EVENTS.timerInterval);
        EVENTS = jQuery.extend(true, {}, EVENTS_INITIALIZE);
        console.log("logged out");
        if (cause !== undefined) {
            alert(cause);
        }
    };
//    this doesn't work right now
    EVENTS.checkLogin = function() {
        var result;
        $.when($.get("/ims/login")).done(function(data){
            result = data;
        
            EVENTS.updateTimeout();
            console.log(result);
            EVENTS.authenticated = result;

            if (!EVENTS.authenticated) EVENTS.logout();
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
    
    var checkSupField = function(supField){
        var sup = getSupByName(supField.val());
        var supCheck = false;
        if (sup === undefined) {
            supField.addClass("invalid-input");
        } else {
            supField.removeClass("invalid-input");
            supCheck = true;
        }
        
        return supCheck;
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
        orderDiv.find(".product-input").each(function(){
            if (checkProdField($(this)) === false) {
                pass = false;
            }
        });
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
        if (!checkSupField(orderDiv.find("#datebox"))){
            pass = false;
        }
        if (pass === false) {
            setTimeout(function(){
                alert("Invalid fields marked in red.");
            },10);
        }
        return pass;
    };
    
    var createPo = function(retRow) {
        var retId = retRow.find(".retId").html();
        var orderLines = retRow.find(".orderLine");
        var orderDiv = retRow.find(".MakeOrderInfo");
        
        if (!checkPoFields(orderDiv) === true){
            console.log("invalid fields");
            return null;
        }
        
        
        var supName = retRow.find('#datebox').val();
        var supId = getSupByName(supName).id;
        
        
        
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
        total = total || "0";
        orderDiv.find(".total-cost-display").val("$"+total);
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
                EVENTS.updateTimeout();
                if (data === true) {
                    // TODO tell user it succeeded or failed
                    console.log("successful");
                } else alert("Order submission failed.");
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
    
    $("body").on("change autocompleteselect focusout keypress", "#datebox", function(event) {
        if (event.key && (event.key !== "Enter")) return;
            setTimeout(() => {
            checkSupField($(this));
        },10);
    });
    
    $("body").on("focusout keypress", ".pid-input", function(event) {
        if (event.key && (event.key !== "Enter")) return;
        var orderLine = $(this).parents(".orderLine");
        var prod;
        if (checkPidField($(this)) === true) {
            prod = getProdById($(this).val());
            orderLine.find(".product-input").val(prod.name);
            checkProdField(orderLine.find(".product-input"));
            orderLine.find(".unit-cost-display").val("$"+prod.supplierPrice);
            orderLine.find(".line-cost-display").val("$"+
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

    $('body').on('click','.ordersButton',function(){
    	var ancestor = $(this).parent().parent();
    	if(!ancestor.children().hasClass("orderTable")) {
	    	var uncle;
	    	var id;
	    	var grandparent;
                uncle = $(this).parents('.RetailRow').find('span.retId');
                id = uncle.html();
                grandparent = $(this).parents('.RetailRow');    	
    	
    		sendRequest("purchase-order-line/po", id, grandparent);
    	}
    });
    
    $("body").on("click","#mySideNav p", function(){
        var divId = pageMap.get($(this).attr("id"));
        changeView(divId);
        $("#Notification").addClass("hidden");
        console.log(divId);
        if (divId === "#RetailersView") {
            unhide();
        } else if (divId === "#SalesView") {
            sendRequest("sale");
        } else if (divId === "#ProductsView") {
            sendRequest("product");
        } else if (divId === "#Welcome"){
        	$("#Notification").removeClass("hidden")
        }
        
    });
    
    $("#login-button").on("click",function(){
        console.log("login submit");
        EVENTS.login();
    });
    
    $("#logout-button").on("click",function(){
        EVENTS.logout();
    });
    
    var pageMap = new Map([
        [ "home-button", "#Welcome" ],
        [ "retailersButton", "#RetailersView" ],
        [ "productsButton", "#ProductsView" ],
        [ "salesButton", "#SalesView" ]
    ]);

});