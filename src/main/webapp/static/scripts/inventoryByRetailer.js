/**
 * 
 */

var global={};
global.invObjArray=[];
global.invProdIdArray=[];
global.invProdNameArray=[];
global.invProdQuantArray=[];




 function inventoryByRetButton(input) {
	 
	function clearArrays(){
		// not sure if want to use object array or field arrays
		global.invObjArray=[];// Inventory Object Array
		
		// data fields arrays
		global.invProdIdArray=[];
		global.invProdNameArray=[];
		global.invProdQuantArray=[];
	};
	
	function storeData(arrayInv){
		console.log("I am a mouse");		   
		for(ii=0; ii<(arrayInv.length); ii++){
			console.log("no you are a mouse");
			global.invProdIdArray[ii]=arrayInv[ii].id;
			global.invProdNameArray[ii]=arrayInv[ii].product.name;
			global.invProdQuantArray[ii]=arrayInv[ii].productQuantity;
		}
		displayData(global.invObjArray);
	};

	function displayData(invArray){
		for(ii=0;ii<invArray.length;ii++){
			console.log("Inventory Id: " +global.invObjArray[ii].id);
			console.log("Product: "+ global.invObjArray[ii].product.name);
			console.log("Amount: "+global.invObjArray[ii].productQuantity);
		}
	}
	 
	 var inventURL = "/ims/inventory/"+input;
	 
       console.log(input);
       $.ajax({
    	  method: "GET",
    	  url: inventURL,
    	  success: function(data){
    		  clearArrays();
    		  global.invObjArray=(data);
    		  storeData(data);
     	  },
    	  
    	  error: function(){
    		  alert("OOPSIES! Something Went Wrong");
    	  } 
    	   
       });      
    
       
    
       
 }
 