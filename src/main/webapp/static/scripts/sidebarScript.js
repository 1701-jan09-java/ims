/**
 * 
 */

var global = {};

$(document).ready(function(){
	global.toggleRight = false;
	
		$("#openNavBar").click(function(){
                    if ($(this).attr("disabled")) return;
			if(global.toggleRight === false){
				document.getElementById("mySideNav").style.width = "250px";
			    document.getElementById("ResultsView").style.marginLeft = "250px";
                            document.getElementById("login-view").style.marginLeft = "250px";
			    global.toggleRight = true;
			}
			else if(global.toggleRight === true){
				document.getElementById("mySideNav").style.width = "0";
			    document.getElementById("ResultsView").style.marginLeft = "0";
                            document.getElementById("login-view").style.marginLeft = "0";
			    global.toggleRight = false;
			}		    
		});	
	
	
});


