/**
 * 
 */

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
    	   console.log(data);
    	   INVENTORY.invObjArray= data.slice();
    	   INVENTORY.modalBody = document.getElementById("modal-body");
     	 	console.log(INVENTORY.modalBody);
     	 	
     	 	INVENTORY.modalHeader = document.getElementById("modal-title");
     	 	
     	 	var inventRow = document.createElement("div");
     	 	inventRow.className = "row";
     	 	INVENTORY.modalBody.appendChild(inventRow);
     	 	
     	 	var inventHeader = document.createElement("div");
     	 	inventHeader.className = "col-md-12";
     	 	inventRow.appendChild(inventHeader);
     	 	
     	 	var inventIdHeader = document.createElement("div");
     	 	inventIdHeader.innerHTML = '<b>'+"Inventory ID"+'</b>';
     	 	inventIdHeader.className = "col-md-2";
     	 	inventHeader.appendChild(inventIdHeader);
     	 	
     	 	var productNameHeader = document.createElement("div");
     	 	productNameHeader.innerHTML = '<b>'+"Product Name"+'</b>';
     	 	productNameHeader.className = "col-md-2";
     	 	inventHeader.appendChild(productNameHeader);
     	 	
     	 	var retailerPriceHeader = document.createElement("div");
     	 	retailerPriceHeader.innerHTML = '<b>'+"Retailer Price"+'</b>';
     	 	retailerPriceHeader.className = "col-md-2";
     	 	inventHeader.appendChild(retailerPriceHeader);
     	 	
     	 	var supplierPriceHeader = document.createElement("div");
     	 	supplierPriceHeader.innerHTML = '<b>'+"Supplier Price"+'</b>';
     	 	supplierPriceHeader.className = "col-md-2";
     	 	inventHeader.appendChild(supplierPriceHeader);
     	 	
     	 	var productQuantityHeader = document.createElement("div");
     	 	productQuantityHeader.innerHTML = '<b>'+"Quantity"+'</b>';
     	 	productQuantityHeader.className = "col-md-2";
     	 	inventHeader.appendChild(productQuantityHeader);
     	 	
     	 	var productThresholdHeader = document.createElement("div");
     	 	productThresholdHeader.innerHTML = '<b>'+"Threshold"+'</b>';
     	 	productThresholdHeader.className = "col-md-2";
     	 	inventHeader.appendChild(productThresholdHeader);
     	 	
     	 	INVENTORY.modalHeader.innerHTML = INVENTORY.invObjArray[0].retailer.name;
       
     	 	for(let index = 0; index < INVENTORY.invObjArray.length; index++){
     	 		
     	 		 let inventoryID = INVENTORY.invObjArray[index].id;
     	 		 let productName = INVENTORY.invObjArray[index].product.name;
     	 		 let retailerPrice = INVENTORY.invObjArray[index].product.retailerPrice;
     	 		 let supplierPrice = INVENTORY.invObjArray[index].product.supplierPrice;
     	 		 let productQuantity = INVENTORY.invObjArray[index].productQuantity;
     	 		 let productThreshold = INVENTORY.invObjArray[index].productThreshold
     	 		 
     	 		 var newRow = document.createElement("div");
     	 		 newRow.className="row";
     	 		 INVENTORY.modalBody.appendChild(newRow);
     	 		 
     	 		var newInnerRow = document.createElement("div");
     	 		newInnerRow.className="col-md-12";
    	 		newRow.appendChild(newInnerRow);
    	 		
    	 		var inventID = document.createElement("div");
    	 		inventID.innerHTML = inventoryID;
    	 		inventID.className="col-md-2";
     	 		newInnerRow.appendChild(inventID);
     	 		
     	 		var prodName = document.createElement("div");
     	 		prodName.innerHTML = productName;
     	 		prodName.className="col-md-2";
     	 		newInnerRow.appendChild(prodName);
     	 		
     	 		var retPrice = document.createElement("div");
     	 		retPrice.innerHTML = retailerPrice;
     	 		retPrice.className="col-md-2";
     	 		newInnerRow.appendChild(retPrice);
     	 		
     	 		var supPrice = document.createElement("div");
     	 		supPrice.innerHTML = supplierPrice;
     	 		supPrice.className="col-md-2";
     	 		newInnerRow.appendChild(supPrice);
     	 		
     	 		var prodQuantity = document.createElement("div");
     	 		prodQuantity.innerHTML = productQuantity;
     	 		prodQuantity.className="col-md-2";
     	 		newInnerRow.appendChild(prodQuantity);
     	 		
     	 		var prodThreshold = document.createElement("div");
     	 		prodThreshold.innerHTML = productThreshold;
     	 		prodThreshold.className="col-md-2";
     	 		newInnerRow.appendChild(prodThreshold);
    	 		 
     	 	 }
     	 	 $('#modal').modal('show');
      	     $("#modal").on("hidden.bs.modal", function(){
      		    $(".modal-body").html("");
      	     });
       });
   
     
    
       
    
       
 }
 