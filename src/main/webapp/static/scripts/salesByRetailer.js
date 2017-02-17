/**
 * 
 */
var global = {};
global.retailData = [];
global.retail=[];
global.getInput = 0;



function salesByRetButton(input) {
	var retailURL = "/ims/sale/retail?id="+input;
	var ajax1 =	$.ajax({
		     	  method: "GET",
		     	  url: retailURL,
	});
	$.when(ajax1).done(function(data){
		 console.log(data); 
  	 	 global.retailData = data.slice();
  	 	global.modalBody = document.getElementById("modal-body");
  	 	global.modalHeader = document.getElementById("modal-title")
  	 	var saleRow = document.createElement("div");
  	 	saleRow.className = "row";
  	 	global.modalBody.appendChild(saleRow);
  	 	
  	 	var saleHeader = document.createElement("div");
  	 	saleHeader.className = "col-md-12";
  	 	saleRow.appendChild(saleHeader);
  	 	
  	 	var saleIdHeader = document.createElement("div");
  	 	saleIdHeader.innerHTML = '<b>'+"Sale ID"+'</b>';
  	 	saleIdHeader.className = "col-md-2";
  	 	saleHeader.appendChild(saleIdHeader);
  	 	
  	 	var productNameHeader = document.createElement("div");
  	 	productNameHeader.innerHTML = '<b>'+"Product Name"+'</b>';
  	 	productNameHeader.className = "col-md-4";
  	 	saleHeader.appendChild(productNameHeader);
  	 	
  	 	var productCostHeader = document.createElement("div");
  	 	productCostHeader.innerHTML = '<b>'+"Cost"+'</b>';
  	 	productCostHeader.className = "col-md-2";
  	 	saleHeader.appendChild(productCostHeader);
  	 	
  	 	var productIdHeader = document.createElement("div");
  	 	productIdHeader.innerHTML = '<b>'+"Product ID"+'</b>';
  	 	productIdHeader.className = "col-md-2";
  	 	saleHeader.appendChild(productIdHeader);
  	 	
  	 	var quantitySoldHeader = document.createElement("div");
  	 	quantitySoldHeader.innerHTML = '<b>'+"Quantity"+'</b>';
  	 	quantitySoldHeader.className = "col-md-2";
  	 	saleHeader.appendChild(quantitySoldHeader);
  	 	
  	 	global.modalHeader.innerHTML = global.retailData[0].retailer.name;
  	 	
  	 	 for(let index = 0; index < global.retailData.length; index++){
  	 		 console.log("print id: "+global.retailData[index].id);
  	 		 let saleID = global.retailData[index].id;
  	 		 let productID = global.retailData[index].product.id;
  	 		 let productName = global.retailData[index].product.name;
  	 		 let productCost = global.retailData[index].cost;
  	 		 let quantitySold = global.retailData[index].productQuantity;
  	 		 
  	 		 var newRow = document.createElement("div");
  	 		 newRow.className="row";
  	 		 global.modalBody.appendChild(newRow);
  	 		 
  	 		var newInnerRow = document.createElement("div");
  	 		newInnerRow.className="col-md-12";
 	 		newRow.appendChild(newInnerRow);
 	 		
 	 		var sale = document.createElement("div");
 	 		sale.innerHTML = saleID;
  	 		sale.className="col-md-2";
  	 		newInnerRow.appendChild(sale);
  	 		
  	 		var prodName = document.createElement("div");
  	 		prodName.innerHTML = productName;
  	 		prodName.className="col-md-4";
  	 		newInnerRow.appendChild(prodName);
  	 		
  	 		var prodCost = document.createElement("div");
  	 		prodCost.innerHTML = productCost;
  	 		prodCost.className="col-md-2";
  	 		newInnerRow.appendChild(prodCost);
  	 		
  	 		var prodID = document.createElement("div");
  	 		prodID.innerHTML = productID;
  	 		prodID.className="col-md-2";
  	 		newInnerRow.appendChild(prodID);
  	 		
  	 		var prodQuantity = document.createElement("div");
  	 		prodQuantity.innerHTML = quantitySold;
  	 		prodQuantity.className="col-md-2";
  	 		newInnerRow.appendChild(prodQuantity); 
 	 		 
  	 	 }
  	 	 
  	     $('#modal').modal('show');
  	     $("#modal").on("hidden.bs.modal", function(){
  		    $(".modal-body").html("");
  		});
	});
}		




 
 