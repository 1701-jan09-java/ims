var ORDER={};
ORDER.invObjArray=[];
ORDER.invProdIdArray=[];
ORDER.invProdNameArray=[];
ORDER.invProdQuantArray=[];




 function ordersByRetButton(input) {
	 
	function clearArrays(){
		// not sure if want to use object array or field arrays
		ORDER.invObjArray=[];// Order Object Array
		
		// data fields arrays
		ORDER.invProdIdArray=[];
		ORDER.invProdNameArray=[];
		ORDER.invProdQuantArray=[];
	};
	
	function storeData(arrayInv){
		console.log("I am a mouse");		   
		for(ii=0; ii<(arrayInv.length); ii++){
			console.log("no you are a mouse");
			ORDER.invProdIdArray[ii]=arrayInv[ii].id;
			ORDER.invProdNameArray[ii]=arrayInv[ii].product.name;
			ORDER.invProdQuantArray[ii]=arrayInv[ii].productQuantity;
		}
		displayData(ORDER.invObjArray);
	};

	function displayData(invArray){
		for(ii=0;ii<invArray.length;ii++){
			console.log("Inventory Id: " +ORDER.invObjArray[ii].id);
			console.log("Product: "+ ORDER.invObjArray[ii].product.name);
			console.log("Amount: "+ORDER.invObjArray[ii].productQuantity);
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
    	   ORDER.invObjArray= data.slice();
    	   ORDER.modalBody = document.getElementById("modal-body");
     	 	console.log(ORDER.modalBody);
     	 	
     	 	ORDER.modalHeader = document.getElementById("modal-title");
     	 	
     	 	var inventTable = document.createElement("table");
     	 	inventTable.classList.add("table", "table-hover", "table-bordered", "table-responsive");
     	 	ORDER.modalBody.appendChild(inventTable);
     	 	
     	 	var inventTableBody = document.createElement("tbody");
     	 	inventTable.appendChild(inventTableBody);
     	 	var inventHeader = document.createElement("thead");
     	 	inventTable.appendChild(inventHeader);
     	 	
     	 	var inventHeadRow = document.createElement("tr");
     	 	inventHeader.appendChild(inventHeadRow);
     	 	
     	 	var inventoryIdHeader = document.createElement("th");
     	 	inventoryIdHeader.innerHTML = "Inventory ID";
     	 	inventHeadRow.appendChild(inventoryIdHeader);
     	 	
     	 	var inventoryProductNameHeader = document.createElement("th");
     	 	inventoryProductNameHeader.innerHTML = "Product Name";
     	 	inventHeadRow.appendChild(inventoryProductNameHeader);
     	 	
     	 	var retailerPriceHeader = document.createElement("th");
     	 	retailerPriceHeader.innerHTML = "Retailer Price";
     	 	inventHeadRow.appendChild(retailerPriceHeader);
     	 	
     	 	var supplierPriceHeader = document.createElement("th");
     	 	supplierPriceHeader.innerHTML = "Supplier Price";
     	 	inventHeadRow.appendChild(supplierPriceHeader);
     	 	
     	 	var productQuantityHeader = document.createElement("th");
     	 	productQuantityHeader.innerHTML = "Product Quantity";
     	 	inventHeadRow.appendChild(productQuantityHeader);
     	 	
     	 	var productThresholdHeader = document.createElement("th");
     	 	productThresholdHeader.innerHTML = "Product Threshold";
     	 	inventHeadRow.appendChild(productThresholdHeader);
    
     	 	ORDER.modalHeader.innerHTML = ORDER.invObjArray[0].retailer.name;
       
     	 	for(let index = 0; index < ORDER.invObjArray.length; index++){
     	 		
     	 		 let inventoryID = ORDER.invObjArray[index].id;
     	 		 let productName = ORDER.invObjArray[index].product.name;
     	 		 let retailerPrice = ORDER.invObjArray[index].product.retailerPrice;
     	 		 let supplierPrice = ORDER.invObjArray[index].product.supplierPrice;
     	 		 let productQuantity = ORDER.invObjArray[index].productQuantity;
     	 		 let productThreshold = ORDER.invObjArray[index].productThreshold
     	 		 
     	 		var newTableRow = document.createElement("tr");
     	 		inventTableBody.appendChild(newTableRow);     	 		
    	 		
    	 		var inventID = document.createElement("td");
    	 		inventID.innerHTML = inventoryID;
    	 		newTableRow.appendChild(inventID);
    	 		
    	 		var prodName = document.createElement("td");
    	 		prodName.innerHTML = productName;
    	 		newTableRow.appendChild(prodName);
    	 		
    	 		var retPrice = document.createElement("td");
    	 		retPrice.innerHTML = retailerPrice;
    	 		newTableRow.appendChild(retPrice);
    	 		
    	 		var supPrice = document.createElement("td");
    	 		supPrice.innerHTML = supplierPrice;
    	 		newTableRow.appendChild(supPrice);
    	 		
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