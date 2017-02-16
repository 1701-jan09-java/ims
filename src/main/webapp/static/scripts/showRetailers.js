/**
 * 
 */

 function unhide(clickedButton, divID, ret) {
			
	 		console.log("here");
	 		console.log(divID); 
	 		  
    		
    		$.ajax({
    			method: "GET",
    			url: "/ims/retailer",
    			success: function(data) {
    				
    				console.log(data); 				
    				
    				var item = document.getElementById(divID);
					console.log(item);  
					
    				for(i=0; i<data.length; i++) {   					
    					
//    					var item = document.getElementById(divID);
//    					console.log(item);    
    					
    					var ret = document.createElement("DIV");   					
    					
    					
    					ret.className = "unhidden row RetailRow";
    					
    					document.getElementById("ResultsView").appendChild(ret);     					   	
    					
    					//var rowClass = item.className;
    					//$(ret).addClass("unhidden row RetailRow");
    					//ret.innerHTML = " - "+data[i].id+"&nbsp;&nbsp;"+data[i].name;
    					$(ret).html(" - "+data[i].id+"&nbsp;&nbsp;"+data[i].name);
    					
    					
    					
    					item.className = "unhidden row RetailRow";
    					
    					
//    					var $div = $("<div>");
//    					$("#ResultsView").append(
//    							  $('<div/>')    						
//    							    .addClass("unhidden row RetailRow")
//    							    .append("<p class = \"myID\">RetailerID-<span id=\"retID\">"+data[i].id+"</span> &nbsp; <span id=\"retName\">"+data[i].name+"</span></p>"+ 
//    							    		"<div class = \"btn-group\">"+
//    							    			"<button type = \"button\" class = \"btn RetailButton inventoryButton\">Inventory</button>" +
//    							    			"<button type = \"button\" class = \"btn RetailButton salesButton\">Sales</button>" +
//    							    			"<button type = \"button\" class = \"btn RetailButton ordersButton\">Orders</button></div>" +    							    		
//    							    		"<div class = 'btn-group pull-right'>"+
//    							    			"<button class = \"btn RetailButton makeSaleButton\">Make Sale</button>"+
//    							    			"<button class = \"btn RetailButton makeOrderButton\">Make Order</button>'</div>')")
//    					);
    							      
    			
    				}
    				
    				
    			}
    			
    		});
 		
    		
  }