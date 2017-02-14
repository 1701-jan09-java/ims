/**
 * 
 */

var global = {};

$(document).ready(function(){
	global.toggleRight = false;
	
		$("#openNavBar").click(function(){
			if(global.toggleRight === false){
				document.getElementById("mySideNav").style.width = "250px";
			    document.getElementById("ResultsView").style.marginLeft = "250px";
			    global.toggleRight = true;
			}
			else if(global.toggleRight === true){
				document.getElementById("mySideNav").style.width = "0";
			    document.getElementById("ResultsView").style.marginLeft = "0";
			    global.toggleRight = false;
			}		    
		});	
	
	
});


