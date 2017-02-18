/**
 * 
 */
 function unhide(clickedButton, divID, ret) {
	 		
	 		hideOtherViews();	 		
	 
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
    					
    					var $retDiv = $("<div/>")  	
    								
    							    .addClass("unhidden row RetailRow")
    							    .attr("id", "Retailers")
    							    .html("<p class = \"myID\">RetailerID-<span id=\"retID\">"+data[i].id+"</span> &nbsp; <span id=\"retName\">"+data[i].name+"</span>"+ 
    							    		"&nbsp;&nbsp;<span class=\"addr\">Address: "+data[i].address.street + " " + data[i].address.city + ", " +data[i].address.state + " " + data[i].address.zip+"</span></p>"+
    							    		"<div class = \"btn-group\">"+
    							    			"<button type = \"button\" class = \"btn RetailButton inventoryButton\">Inventory</button>" +
    							    			"<button onclick=\"salesByRetButton('"+data[i].id+"')\" type = \"button\" class = \"btn RetailButton salesButton\">Sales</button>" +
    							    			"<button type = \"button\" class = \"btn RetailButton ordersButton\">Orders</button></div>" +    							    		
    							    		"<div class = 'btn-group pull-right'>"+
    							    			"<button class = \"btn RetailButton makeSaleButton\">Make Sale</button>"+
    							    			"<button class = \"btn RetailButton makeOrderButton\">Make Order</button></div>");
    					
    					$("#ResultsView").append($retDiv);				
    					
    				} 				
    				
    			}
    			
    		}); 			
    		
 	}
 
 function hideOtherViews(){
	 
	 
	 $("#Loading").addClass("hidden");
	 $("#ProductsView").addClass("hidden");
	 $("#SalesView").addClass("hidden");
	 
	 
	 
 }
 
