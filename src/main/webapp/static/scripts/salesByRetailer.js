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

		EVENTS.updateTimeout();
                

		 
		console.log(data);
		

  	 	global.retailData = data.slice();
  	 	//console.log(global.retailData);
  	 	global.modalBody = document.getElementById("modal-body");
  	 	//console.log(global.modalBody);
  	 	global.modalHeader = document.getElementById("modal-title");
  	 	
  	 	var saleTable = document.createElement("table");
 	 	saleTable.classList.add("table", "table-hover", "table-bordered", "table-responsive");
 	 	global.modalBody.appendChild(saleTable);
 	 	
 	 	var saleTableBody = document.createElement("tbody");
 	 	saleTable.appendChild(saleTableBody);
 	 	var saleHeader = document.createElement("thead");
 	 	saleTable.appendChild(saleHeader);
 	 	
 	 	var saleHeadRow = document.createElement("tr");
 	 	saleHeader.appendChild(saleHeadRow);
 	 	
 	 	var saleIdHeader = document.createElement("th");
 	 	saleIdHeader.innerHTML = "Sale ID";
 	 	saleHeadRow.appendChild(saleIdHeader);
 	 	
 	 	var saleProductNameHeader = document.createElement("th");
 	 	saleProductNameHeader.innerHTML = "Product Name";
 	 	saleHeadRow.appendChild(saleProductNameHeader);
 	 	
 	 	var saleProductIdHeader = document.createElement("th");
 		saleProductIdHeader.innerHTML = "Product ID";
 	 	saleHeadRow.appendChild(saleProductIdHeader);
 	 	
 	 	var saleProductCostHeader = document.createElement("th");
 	 	saleProductCostHeader.innerHTML = "Cost";
 	 	saleHeadRow.appendChild(saleProductCostHeader); 		
 	 	
 	 	var saleProductQuantityHeader = document.createElement("th");
 	 	saleProductQuantityHeader.innerHTML = "Quantity";
 	 	saleHeadRow.appendChild(saleProductQuantityHeader);
 	 
  	 	global.modalHeader.innerHTML = global.retailData[0].retailer.name;
  	 	
  	 	 for(let index = 0; index < global.retailData.length; index++){
  	 		 console.log("print id: "+global.retailData[index].id);
  	 		 let saleID = global.retailData[index].id;
  	 		 let productID = global.retailData[index].product.id;
  	 		 let productName = global.retailData[index].product.name;
  	 		 let productCost = global.retailData[index].cost;
  	 		 let quantitySold = global.retailData[index].productQuantity;
  	 		 
  	 		 var newTableRow = document.createElement("tr");
  	 		 saleTableBody.appendChild(newTableRow);     	 		
	 		
  	 		 var sID = document.createElement("td");
  	 		 sID.innerHTML = saleID;
  	 		 newTableRow.appendChild(sID);
  	 		 
  	 		 var prodID = document.createElement("td");
  	 		 prodID.innerHTML = productID;
 	 		 newTableRow.appendChild(prodID);
  	 		 
 	 		 var prodName = document.createElement("td");
  	 		 prodName.innerHTML = productName;
 	 		 newTableRow.appendChild(prodName);
 	 		 
 	 		 var prodCost = document.createElement("td");
 	 		 prodCost.innerHTML = productCost;
 	 		 newTableRow.appendChild(prodCost);
 	 		 
 	 		 var prodQuantity = document.createElement("td");
 	 		 prodQuantity.innerHTML = quantitySold;
 	 		 newTableRow.appendChild(prodQuantity);
 	 		 
  	 	 }
  	 	 
  	     $('#modal').modal('show');
  	     $("#modal").on("hidden.bs.modal", function(){
  	    	 $(".modal-body").html("");
  		});
	});
}		




 
 
 