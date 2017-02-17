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
    					
    					var $retDiv = $("<div/>")  						
    							    .addClass("unhidden row RetailRow")
    							    .attr("id", "retailers")
    							    .html("<p class = \"myID\">RetailerID-<span id=\"retID\">"+data[i].id+"</span> &nbsp; <span id=\"retName\">"+data[i].name+"</span>"+ 
    							    		"&nbsp;&nbsp;<span class=\"addr\">Address: "+data[i].address.street + " " + data[i].address.city + ", " +data[i].address.state + " " + data[i].address.zip+"</span></p>"+
    							    		"<div class = \"btn-group\">"+
    							    			"<button onclick=\"inventoryByRetButton('"+data[i].id+"')\" type = \"button\" class = \"btn btn-info RetailButton inventoryButton\">Inventory</button>" +
    							    			"<button onclick=\"salesByRetButton('"+data[i].id+"')\" type = \"button\" class = \"btn btn-warning RetailButton salesButton\">Sales</button>" +
    							    			"<button type = \"button\" class = \"btn btn-success RetailButton ordersButton\">Orders</button></div>" +    							    		
    							    		"<div class = 'btn-group pull-right'>"+
    							    			"<button class = \"btn btn-primary RetailButton makeSaleButton\">Make Sale</button>"+
    							    			"<button class = \"btn btn-danger RetailButton makeOrderButton\">Make Order</button></div>");
    					
    					$("#ResultsView").append($retDiv);
    				
    					
    					

    				}
    				
    				
    			},
    		
    		  error: function(){
        		  alert("OOPSIES! Something Went Wrong");
        	  }
    			
    		});
 		
    		

 	}
 

