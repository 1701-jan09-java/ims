/**
 * 
 */

global = {};


var dollarByProductUrl = "/ims/reports/dollars-by-product";

console.log(input);
var dollarByProduct = $.ajax({
	  method: "GET",
	  url: dollarByProductUrl,
});

$.when(dollarByProduct).done(function(data){
	 
	console.log("this is graph data"+ data);
	
	 	global.dollarByProductData = data.slice();
	 	
	 	 
	     $('#modal').modal('show');
	     $("#modal").on("hidden.bs.modal", function(){
	    	 $(".modal-body").html("");
		});
});
