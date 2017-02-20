var INVENTORY={};
INVENTORY.invObjArray=[];
INVENTORY.invProdIdArray=[];
INVENTORY.invProdNameArray=[];
INVENTORY.invProdQuantArray=[];




 function inventoryByRetButton(input) {
	 
	function clearArrays(){
		// not sure if want to use object array or field arrays
		INVENTORY.invObjArray=[];// Inventory Object Array
		
		// data fields arrays
		INVENTORY.invProdIdArray=[];
		INVENTORY.invProdNameArray=[];
		INVENTORY.invProdQuantArray=[];
	};
	
	function storeData(arrayInv){
		console.log("I am a mouse");		   
		for(ii=0; ii<(arrayInv.length); ii++){
			console.log("no you are a mouse");
			INVENTORY.invProdIdArray[ii]=arrayInv[ii].id;
			INVENTORY.invProdNameArray[ii]=arrayInv[ii].product.name;
			INVENTORY.invProdQuantArray[ii]=arrayInv[ii].productQuantity;
		}
		displayData(INVENTORY.invObjArray);
	};

	function displayData(invArray){
		for(ii=0;ii<invArray.length;ii++){
			console.log("Inventory Id: " +INVENTORY.invObjArray[ii].id);
			console.log("Product: "+ INVENTORY.invObjArray[ii].product.name);
			console.log("Amount: "+INVENTORY.invObjArray[ii].productQuantity);
		}
	}
	 
	 var inventURL = "/ims/inventory/"+input;
	 
       console.log(input);
       var inventoryAjax = $.ajax({
    	  method: "GET",
    	  url: inventURL,
       });
       $.when(inventoryAjax).done(function(data){
           EVENTS.updateTimeout();
    	   console.log(data);
    	   INVENTORY.invObjArray= data.slice();
    	   INVENTORY.modalBody = document.getElementById("modal-body");
     	 	console.log(INVENTORY.modalBody);
     	 	
     	 	INVENTORY.modalHeader = document.getElementById("modal-title");
     	 	
     	 	var inventTable = document.createElement("table");
     	 	inventTable.classList.add("table", "table-hover", "table-bordered", "table-responsive");
     	 	INVENTORY.modalBody.appendChild(inventTable);
     	 	
     	 	var inventTableBody = document.createElement("tbody");
     	 	inventTable.appendChild(inventTableBody);
     	 	var inventHeader = document.createElement("thead");
     	 	inventTable.appendChild(inventHeader);
     	 	
     	 	var inventHeadRow = document.createElement("tr");
     	 	inventHeader.appendChild(inventHeadRow);
     	 	
//     	 	var inventoryIdHeader = document.createElement("th");
//     	 	inventoryIdHeader.innerHTML = "Inventory ID";
//     	 	inventHeadRow.appendChild(inventoryIdHeader);
     	 	
     	 	var inventoryProductNameHeader = document.createElement("th");
     	 	inventoryProductNameHeader.innerHTML = "Product Name";
     	 	inventHeadRow.appendChild(inventoryProductNameHeader);
     	 	
//     	 	var retailerPriceHeader = document.createElement("th");
//     	 	retailerPriceHeader.innerHTML = "Retailer Price";
//     	 	inventHeadRow.appendChild(retailerPriceHeader);
//     	 	
//     	 	var supplierPriceHeader = document.createElement("th");
//     	 	supplierPriceHeader.innerHTML = "Supplier Price";
//     	 	inventHeadRow.appendChild(supplierPriceHeader);
//     	 	
     	 	var productQuantityHeader = document.createElement("th");
     	 	productQuantityHeader.innerHTML = "Stock Quantity";
     	 	inventHeadRow.appendChild(productQuantityHeader);
     	 	
     	 	var productThresholdHeader = document.createElement("th");
     	 	productThresholdHeader.innerHTML = "Stock Threshold";
     	 	inventHeadRow.appendChild(productThresholdHeader);
    
     	 	INVENTORY.modalHeader.innerHTML = INVENTORY.invObjArray[0].retailer.name;
       
     	 	for(let index = 0; index < INVENTORY.invObjArray.length; index++){
     	 		
     	 		 let inventoryID = INVENTORY.invObjArray[index].id;
     	 		 let productName = INVENTORY.invObjArray[index].product.name;
     	 		 let retailerPrice = INVENTORY.invObjArray[index].product.retailerPrice;
     	 		 let supplierPrice = INVENTORY.invObjArray[index].product.supplierPrice;
     	 		 let productQuantity = INVENTORY.invObjArray[index].productQuantity;
     	 		 let productThreshold = INVENTORY.invObjArray[index].productThreshold
     	 		 
     	 		var newTableRow = document.createElement("tr");
     	 		inventTableBody.appendChild(newTableRow);     	 		
    	 		
//    	 		var inventID = document.createElement("td");
//    	 		inventID.innerHTML = inventoryID;
//    	 		newTableRow.appendChild(inventID);
    	 		
    	 		var prodName = document.createElement("td");
    	 		prodName.innerHTML = productName;
    	 		newTableRow.appendChild(prodName);
    	 		
//    	 		var retPrice = document.createElement("td");
//    	 		retPrice.innerHTML = retailerPrice;
//    	 		newTableRow.appendChild(retPrice);
//    	 		
//    	 		var supPrice = document.createElement("td");
//    	 		supPrice.innerHTML = supplierPrice;
//    	 		newTableRow.appendChild(supPrice);
    	 		
    	 		var prodQuantity = document.createElement("td");
    	 		prodQuantity.innerHTML = productQuantity;
    	 		newTableRow.appendChild(prodQuantity);
    	 		
    	 		var prodThreshold = document.createElement("td");
    	 		prodThreshold.innerHTML = productThreshold;
    	 		newTableRow.appendChild(prodThreshold);
    	 
     	 	 }
     	 	 $('#modal').modal('show');
      	     $("#modal").on("hidden.bs.modal", function(){
      		    $(".modal-body").html("");
      	     });
       });
   
     
    
       
    
       
 }