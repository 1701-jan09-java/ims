/**
 * 
 */

 function unhideSup(clickedButton, divID) {

    hideOtherViews();	 		

    console.log("here");
    console.log(divID); 


    $.ajax({
        method: "GET",
        url: "/ims/suppliers",
        success: function(data) {

            console.log(data); 				

            var item = document.getElementById(divID);
                console.log(item);  


            for(i=0; i<data.length; i++) {	

                var $supDiv = $("<div/>")  	
                    .addClass("row SupplyRow")
                    .html("<p class = \"useless\">SupplierID-<span class=\"supId\">"+data[i].id+"</span> &nbsp; <span class=\"supName\">"+data[i].name+"</span>"+ 
                        "&nbsp;&nbsp;<span class=\"addr\">Address: "+data[i].address.street + " " + data[i].address.city + ", " +data[i].address.state + " " + data[i].address.zip+"</span></p>"+
                        "<div class = \"btn-group\">" +    							    		

                            "<button onclick=\"salesBySupButton('"+data[i].id+"')\" type = \"button\" class = \"btn btn-warning SupplyButton salesButton\">Dollar Sales</button>" +
                            "<button type = \"button\" class = \"btn btn-success SupplyButton ordersButton\">Quantity Sales</button></div>"   
                        );

                $("#SuppliersView").append($supDiv);				

            } 				

        },

      error: function(){
              alert("OOPSIES! Something Went Wrong");
      }

    }); 			


}

    function hideOtherViews(){


        $("#Welcome").addClass("hidden");
        $("#Loading").addClass("hidden");
        $("#ProductsView").addClass("hidden");
        $("#SalesView").addClass("hidden");
        $("#AllRetailers").addClass("hidden");
        $("#AllSuppliers").removeClass("hidden");
        $("#SuppliersView").removeClass("hidden");


 }

