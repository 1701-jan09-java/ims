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
		global.invObjArray=[];
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
			console.log(global.invObjArray[ii]);
		}
	}
	 
	 var inventURL = "/ims/inventory/"+input;
	 
       console.log(input);
       $.ajax({
    	  method: "GET",
    	  url: inventURL,
    	  success: function(data){
    		  clearArrays();
    		  global.invObjArray = [];
    		  global.invObjArray=(data);
//    		  console.log(data);
    		  storeData(data);
     	  },
    	  
    	  error: function(){
    		  alert("OOPSIES! Something Went Wrong");
    	  } 
    	   
       });      
    
       
    
       
 }
 