/**
 * 
 */


 function unhide() {

    $.ajax({
        method: "GET",
        url: "/ims/retailer",
        success: function(data) {
            EVENTS.updateTimeout();

            console.log(data); 				 


            for(i=0; i<data.length; i++) {	

                var $retDiv = $("<div/>")  	
                    .addClass("row RetailRow")
                    .html("<p class = \"useless\">RetailerID-<span class=\"retId\">"+data[i].id+"</span> &nbsp; <span class=\"retName\">"+data[i].name+"</span>"+ 
                        "&nbsp;&nbsp;<span class=\"addr\">Address: "+data[i].address.street + " " + data[i].address.city + ", " +data[i].address.state + " " + data[i].address.zip+"</span></p>"+
                        "<div class = \"btn-group\">" +    							    		

                            "<button onclick=\"inventoryByRetButton('"+data[i].id+"')\" type = \"button\" class = \"btn btn-info RetailButton inventoryButton\">Inventory</button>" +
                            "<button onclick=\"salesByRetButton('"+data[i].id+"')\" type = \"button\" class = \"btn btn-warning RetailButton salesButton\">Sales</button>" +
                            "<button type = \"button\" class = \"btn btn-success RetailButton ordersButton\">Orders</button></div>" +    							    		

                        "<div class = 'btn-group pull-right'>"+
                            "<button class = \"btn btn-primary RetailButton makeSaleButton\">Make Sale</button>"+
                            "<button class = \"btn btn-danger RetailButton makeOrderButton\">Make Order</button></div>"+
                        '<div class = "hidden">Heyyy</div>'+
                        '<div class = "MakeOrderInfo hidden">'+
			'<p>Make an Order</p>'+
			'<div class = "btn-group" role = "group">'+
				'<div class = "btn-group supplierDropdown" role = "group" >'+
					'<input type="TextBox" ID="datebox" Class="form-control"></input>'+
					'<button type = "button" class = "btn dropdown-toggle" data-toggle="dropdown">'+
					'Supplier <span class = "caret"></span></button>'+
					'<ul class = "dropdown-menu" role = "menu">'+
					'</ul>'+
				'</div>'+ 
				'<div class = "btn-group pull-right" role = "group">'+
					'<button type = "button" class = "btn addLine">Add Line</button>'+
					'<button type = "button" class = "btn removeLine">Remove Line</button>'+
					'<button type = "button" class = "btn submitOrder">Submit</button>'+
                                        '<button type = "button" class = "btn pull-right clearOrderForm">Clear</button>'+
				'</div>'+
			'</div>'+
			
			'<div class="productOrder">'+
                            '<div class="row">'+
                                '<div class="col-xs-12 orderHeader">'+
                                    '<div class="col-xs-3 text-center">Product</div>'+
                                    '<div class="col-xs-2 text-center">Product ID</div>'+
                                    '<div class="col-xs-2 text-center">Unit Cost</div>'+
                                    '<div class="col-xs-2 text-center">Quantity</div>'+
                                    '<div class="col-xs-2 text-center">Total Cost</div>'+
                                '</div>'+
                            '</div>'+

                            '<div class="row total-row">'+
                                '<div class="col-xs-2 text-right sm-button"><button title="Add Line" class="btn btn-success addLine">+</button></div>'+
                                '<div class="col-xs-10 input-group">'+
                                    '<div class="col-xs-7 text-right">Order Total:</div>'+
                                    '<div class="col-xs-3 text-box"><input class="text-right total-cost-display form-control" type="text" value = "0" readonly="true"/></div>'+
                                '</div>'+
                            '</div>'+
			'</div>'+
		'</div>'+
		
		'<div class = "MakeSaleInfo hidden">'+
			'<p>Make a Sale</p>'+
			'<div class = "btn-group saleLine" role = "group">'+
				'<div class = "btn-group" role = "group">'+
					'<button type = "button" class = "btn dropdown-toggle" data-toggle="dropdown">'+
					'Product <span class = "caret"></span></button>'+
					'<ul class = "dropdown-menu productMenu" role = "menu">'+
					'</ul>'+
				'</div>'+
			'</div>'+

			'<div class="MakeSaleInfo hidden">'+
				'<p>Make a Sale</p>'+
				'<div class="btn-group saleLine" role="group">'+
					'<div class="btn-group" role="group">'+
						'<button type="button" class="btn dropdown-toggle"'+
							'data-toggle="dropdown">'+
							'Product <span class="caret"></span>'+
						'</button>'+
						'<ul class="dropdown-menu" role="menu">'+
							'<li><a href="#">Product 1</a></li>'+
							'<li><a href="#">Product 2</a></li>'+
						'</ul>'+
					'</div>'+
					'<div class="col-sm-4" style="padding: 0; margin-top: 2px">'+
						'<div class="input-group">'+
							'<input id="userInput" type="text" class="form-control"'+
								'placeholder="Quantity" />'+
						'</div>'+
					'</div>'+
					'<button type="button" class="btn submitSale">Submit</button>'+
				'</div>'+
			'</div>'+


		'</div> '   
                        );

                $("#RetailersView").append($retDiv);				

            } 				

        },

      error: function(data){
          console.log(data); 	
              alert("OOPSIES! Something Went Wrong");
      }

    }); 			


}


//    function hideOtherViews(){
//
//
//        $("#Welcome").addClass("hidden");
//        $("#Loading").addClass("hidden");
//        $("#ProductsView").addClass("hidden");
//        $("#SalesView").addClass("hidden");
//        $("#Notification").addClass("hidden");
//        $("#AllRetailers").removeClass("hidden");
//        
//
//
// }


