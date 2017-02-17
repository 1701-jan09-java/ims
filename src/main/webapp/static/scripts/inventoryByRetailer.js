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
       $.ajax({
    	  method: "GET",
    	  url: inventURL,
    	  success: function(data){
    		  clearArrays();
    		  INVENTORY.invObjArray=(data);
    		  storeData(data);
     	  },
    	  
    	  error: function(){
    		  alert("OOPSIES! Something Went Wrong");
    	  } 
    	   
       });      
    
       
    
       
 }
 