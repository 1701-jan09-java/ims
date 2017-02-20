var ORDER={};
ORDER.ordObjArray=[];
ORDER.orderIdArray=[];
ORDER.supNameArray=[];
ORDER.ordCostArray=[];
ORDER.retNameArray=[];
ORDER.orderPurchaseDate=[];



 function ordersByRetButton(input) {
	 
	function clearArrays(){
		// not sure if want to use object array or field arrays
		ORDER.ordObjArray=[];// Order Object Array
		
		// data fields arrays
		ORDER.orderIdArray=[];
		ORDER.supNameArray=[];
		ORDER.ordCostArray=[];
		ORDER.retNameArray=[];
		ORDER.orderPurchaseDate=[];
	};
	
	function storeData(arrayOrd){
		console.log("Am a mouse?");		   
		for(ii=0; ii<(arrayInv.length); ii++){
			console.log("no you are a mouse");
			ORDER.orderIdArray[ii]=arrayOrd[ii].id;
			ORDER.supNameArray[ii]=arrayOrd[ii].supplier.name;
			ORDER.ordCostArray[ii]=arrayOrd[ii].cost;
			ORDER.retNameArray[ii]=arrayOrd[ii].retailer.name;
			ORDER.orderPurchaseDate[ii]=arrayOrd[ii].purchaseDate;
		}
		displayData(ORDER.ordObjArray);
	};

	function displayData(ordArray){
		for(ii=0;ii<ordArray.length;ii++){
			console.log("Order Id: " +ORDER.arrayOrd[ii].id);
			console.log("Product: "+ ORDER.arrayOrd[ii].supplier.name);
			console.log("Amount: "+ORDER.arrayOrd[ii].cost);
			console.log("Amount: "+ORDER.arrayOrd[ii].retailer.name);
			console.log("Amount: "+ORDER.arrayOrd[ii].purchaseDate);
		}
	}
	 
	 var orderURL = "/ims/purchase-order/"+input; //FIX
	 
       console.log(input);
       var orderAjax = $.ajax({
    	  method: "GET",
    	  url: orderURL,
       });
       $.when(orderAjax).done(function(data){
           EVENTS.updateTimeout();
    	   console.log(data);
    	   ORDER.ordObjArray= data.slice();
    	   ORDER.modalBody = document.getElementById("modal-body");
     	 	console.log(ORDER.modalBody);
     	 	
     	 	ORDER.modalHeader = document.getElementById("modal-title");
     	 	
     	 	var orderTable = document.createElement("table");
     	 	orderTable.classList.add("table", "table-hover", "table-bordered", "table-responsive");
     	 	ORDER.modalBody.appendChild(orderTable);
     	 	
     	 	var orderTableBody = document.createElement("tbody");
     	 	orderTable.appendChild(orderTableBody);
     	 	var orderHeader = document.createElement("thead");
     	 	orderTable.appendChild(orderHeader);
     	 	
     	 	var orderHeadRow = document.createElement("tr");
     	 	orderHeader.appendChild(orderHeadRow);
     	 	
     	 	var orderIdHeader = document.createElement("th");
     	 	orderIdHeader.innerHTML = "Order ID";
     	 	orderHeadRow.appendChild(orderIdHeader);
     	 	
     	 	var orderProductNameHeader = document.createElement("th");
     	 	orderProductNameHeader.innerHTML = "Product Name";
     	 	orderHeadRow.appendChild(orderProductNameHeader);
     	 	
     	 	var orderCostHeader = document.createElement("th");
     	 	orderCostHeader.innerHTML = "Order Cost";
     	 	OrderHeadRow.appendChild(orderCostHeader);
     	 	
     	 	var orderPurchaseDateHeader = document.createElement("th");
     	 	orderPurchaseDateHeader.innerHTML = "Date";
     	 	orderHeadRow.appendChild(orderPurchaseDateHeader);
     	 	
//     	 	var productQuantityHeader = document.createElement("th");
//     	 	productQuantityHeader.innerHTML = "Product Quantity";
//     	 	orderHeadRow.appendChild(productQuantityHeader);
     	 	
//     	 	var productThresholdHeader = document.createElement("th");
//     	 	productThresholdHeader.innerHTML = "Product Threshold";
//     	 	orderHeadRow.appendChild(productThresholdHeader);
    
     	 	ORDER.modalHeader.innerHTML = ORDER.ordObjArray[0].retailer.name;
       
     	 	for(let index = 0; index < ORDER.ordObjArray.length; index++){
     	 		
     	 		 let orderID = ORDER.ordObjArray[index].id;
     	 		 let supplierName = ORDER.ordObjArray[index].supplier.name;
     	 		 let orderCost = ORDER.ordObjArray[index].cost;
     	 		 let orderPurchaseDate = ORDER.ordObjArray[index].purchaseDate;
     	 		 //let productQuantity = ORDER.ordObjArray[index].productQuantity;
     	 		 //let productThreshold = ORDER.ordObjArray[index].productThreshold
     	 		 
     	 		var newTableRow = document.createElement("tr");
     	 		ordTableBody.appendChild(newTableRow);     	 		
    	 		
    	 		var ordID = document.createElement("td");
    	 		ordID.innerHTML = orderID;
    	 		newTableRow.appendChild(ordID);
    	 		
    	 		var supName = document.createElement("td");
    	 		supName.innerHTML = supplierName; //fix
    	 		newTableRow.appendChild(supName);
    	 		
    	 		var retPrice = document.createElement("td");
    	 		retPrice.innerHTML = orderCost;
    	 		newTableRow.appendChild(retPrice);
    	 		
    	 		var supPrice = document.createElement("td");
    	 		supPrice.innerHTML = orderPurchaseDate;
    	 		newTableRow.appendChild(supPrice);
    	 		
//    	 		var prodQuantity = document.createElement("td");
//    	 		prodQuantity.innerHTML = productQuantity;
//    	 		newTableRow.appendChild(prodQuantity);
    	 		
//    	 		var prodThreshold = document.createElement("td");
//    	 		prodThreshold.innerHTML = productThreshold;
//    	 		newTableRow.appendChild(prodThreshold);
    	 
     	 	 }
     	 	 $('#modal').modal('show');
      	     $("#modal").on("hidden.bs.modal", function(){
      		    $(".modal-body").html("");
      	     });
       });
   
     
    
       
    
       
 }