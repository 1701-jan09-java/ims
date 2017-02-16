/**
 * 
 */

 function salesByRetButton(input) {
	 
	 var retailURL = "/ims/sale/retail?id="+input;
	 
       console.log(input);
       
       $.ajax({
    	  method: "GET",
    	  url: retailURL,
    	  success: function(data){
    		  
    		  console.log(data);    		  
    		  
    		  
    	  },
    	  
    	  //failure: 
    	   
       });      
    
 }
 
 