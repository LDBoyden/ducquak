/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var lati=0;
var longi=0;
   
function getPosition(position) 
{
	lati= position.coords.latitude;
	longi = position.coords.longitude;   
     
	document.getElementById("longsub").value = longi;
	document.getElementById("latsub").value = lati;
}

function getLocation() 
{
	if (navigator.geolocation) 
	{		
		navigator.geolocation.getCurrentPosition(getPosition);
	}else 
	{ 
		document.getElementById("longsub").value = "3";
		document.getElementById("latsub").value = "5";
		document.write("Geolocation is not supported by this browser.");
	}
}