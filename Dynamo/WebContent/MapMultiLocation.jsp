<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/css/style.css"%>
<%@ include file="header.jsp"%>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Google Maps Multiple Markers</title>
<style>
div {
     color:black;
}
</style>
 
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>
<script type="text/javascript">
var counter=1;
  function ShowResLocations(Map) {
	  var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 50,
          center: new google.maps.LatLng(40.277625, -74.003671),
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

     var pathcolors = ['#3366ff','#FF0000','#ffff00','#cc0099','#009933','#663300','#00ffff','#666699','#000000'];
	 var j=0;
      var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
		//var start=0;
		//var end =0;
	  for (var key in Map) {
		   // alert(key + ': ' + Map[key]);
		    
		    var locations=Map[key];
		   // alert(locations[0].resName);
		   // alert(locations.length);
		  //  end = end + locations.length;
		    if(key==100){
		    	 image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';	
		    }
		    else image='http://localhost:8080/Dynamo/images/s1044534.jpg';
		    /* alert(listI);
		    alert(locations[0].resName);
		
        	alert(locations.value);
        	var list=locations[0];
        	alert(list[0].resName); */
        	
     //////
     //
    var marker, i;
   
	//alert(locations[0].lattitude)
	
	var arr = [];
	 	
        for (i = 0; i < locations.length; i++) {  
    	  
        	// for (i = start; i < end; i++) {
        	 image = 'http://localhost:8080/Dynamo/images/'+locations[i].imageName;
        	 counter=locations[i].counter;
        	 document.getElementById('counter').value = counter;
        	 //alert(counter);
        	// alert(document.getElementById('counter').value);
        	 
        	 //document.forms.login_form.submit();
        	 
         var infowindow = new google.maps.InfoWindow();		
           marker = new google.maps.Marker({
             position: new google.maps.LatLng(locations[i].lattitude, locations[i].longitude),
             map: map,
             icon : image
           });
           arr.push(marker.getPosition());
           
           
	      google.maps.event.addListener(marker, 'click', (function(marker, i,key) {
	        return function() {
	        	var list=Map[key];
	          infowindow.setContent('Name : ' +list[i].resName + '</br>' +'Organization : ' 
	        		  +list[i].organization + '</br>'+ 'Phone no :'+ ' ' +
	        		  '</br>'+'<img src="http://localhost:8080/Dynamo/images/' + list[i].imageName + '"/>');
	          infowindow.open(map, marker);
	        }
	      })(marker, i,key));
    
        
         }
        	// start=i+1;
        	 
         
         
         var poly = new google.maps.Polyline({
             path: arr,
             strokeColor: pathcolors[j],
             strokeOpacity: 1.0,
             strokeWeight: 3,
             map: map    
           });
         
         if(j<pathcolors.length)
        	j+=1; 
         else
        	 j=0;
	  }
  }

(function loadMap() {	 
		
	  $.ajax({
		type : 'GET',
		dataType: "json",
	    url: 'fetchToMap', 
	    data:{counter:counter},
	    success: function(res) {
	    	ShowResLocations(res.resDetailsMap);
	    },
	    complete: function() {
	      // Schedule the next request when the current one's complete
	      setTimeout(loadMap, 10000);
	    }
	  });
	})();

</script>
<head>
</head>
<body>
	<h2 align="center">Location Map</h2>
	<table>
		<tr>
			<td height="600px"><%@ include file="Menu.jsp"%>
		
			
			<s:hidden id="counter" name="counter" 
                  />	</td>
			<td height="600px" width="75%">
				<table>
				<tr>
				<td><div id="map" style="width: 800px; height: 600px;"></div></td>
				<td><embed  name="mediaplayer1" ShowStatusBar="true" EnableContextMenu="false" autostart="true" width="800" height="600" loop="false" src="<%=request.getContextPath()%>/videos/2016-03-24 00.00.00 Drone Video.mp4" /></td>
				</tr>
				</table>
				
				
			</td>
		</tr>
	</table>
</body>
</html>