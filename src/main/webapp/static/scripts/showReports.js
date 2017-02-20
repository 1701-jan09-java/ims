/**
 * 
 */
global = {};
global.dollarsbyProd = [];
global.dollarsbyProdName = [];

 function unhideReports() {
	 

}

 $("#dollarsByProduct").click(function(){
	 var dolarsByProductUrl = "/ims/reports/dollars-by-product";
		var dollarsByProductAjax =	$.ajax({
							     	  method: "GET",
							     	  url: dolarsByProductUrl,
		});
		
		$.when(dollarsByProductAjax).done(function(data){
			EVENTS.updateTimeout();
			global.modalHeader = document.getElementById("modal-title");
			global.modalHeader.innerHTML = "Sales in Dollars per Product";
			var dollarsByProdData = data.slice();
			var chartColors = [];
			for(index = 0; index < dollarsByProdData.length; index++){
				global.dollarsbyProd[index] = dollarsByProdData[index][0];
				global.dollarsbyProdName[index] = dollarsByProdData[index][1].name;
				chartColors[index] = '#'+Math.floor(Math.random()*16777215).toString(16);
			}
			
			var doughnutData = {
				    labels: global.dollarsbyProdName,
				    datasets: [
				        {
				        	data: global.dollarsbyProd,
				            backgroundColor: chartColors,
				            hoverBackgroundColor: chartColors
				        }]
				};
			
			var ctx = document.getElementById("myChart");
			var myPieChart = new Chart(ctx,{
			    type: 'doughnut',
			    data: doughnutData,
			});
			
		     $('#modal').modal('show');

		});
	 
 });

 
