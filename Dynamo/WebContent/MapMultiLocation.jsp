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
     
  function ShowResLocations(locations) {
        	
	  var map = new google.maps.Map(document.getElementById('map'), {
           zoom: 10,
           center: new google.maps.LatLng(-33.92, 151.25),
           mapTypeId: google.maps.MapTypeId.ROADMAP
         });

         var infowindow = new google.maps.InfoWindow();
			//alert(locations[0].lattitude)
         var marker, i;
         var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
         for (i = 0; i < locations.length; i++) {  
           marker = new google.maps.Marker({
             position: new google.maps.LatLng(locations[i].lattitude, locations[i].longitude),
             map: map,
             icon : image
           });
	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        return function() {
	          infowindow.setContent('Name : ' +locations[i].resName + '</br>' +'Organization : ' 
	        		  +locations[i].organization + '</br>'+ 'Phone no :'+ ' ' +
	        		  '</br>'+'<img src="<%=request.getContextPath()%>/images/icon.jpg"/>');
	          infowindow.open(map, marker);
	        }
	      })(marker, i));
    }
  }
(function loadMap() {	 
		
	  $.ajax({
		type : 'GET',
		dataType: "json",
	    url: 'fetchToMap', 
	    success: function(res) {
	    	ShowResLocations(res.responderDetailsList);
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
			</td>
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