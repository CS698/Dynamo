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
	color: black;
}
</style>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>
<script type="text/javascript">

function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(40.27751,-74.00395),
    zoom:30,
    mapTypeId:google.maps.MapTypeId.SATELLITE
  };
  var readerlocations = [
                   ['Reader 1', 40.2776, -74.00355],
                   ['Reader 2', 40.27729, -74.003647],
                   ['Reader 3', 40.27751, -74.00395]
                 ];
  image = 'http://localhost:8080/Dynamo/images/RFIDReader.jpg';
  var map=new google.maps.Map(document.getElementById("googleMap"), mapProp);
  
  var infowindow = new google.maps.InfoWindow();

  var marker, i;
 
  for (i = 0; i < readerlocations.length; i++) {  
    marker = new google.maps.Marker({
      position: new google.maps.LatLng(readerlocations[i][1], readerlocations[i][2]),
      map: map,
      icon : image
    });

    google.maps.event.addListener(marker, 'click', (function(marker, i) {
      return function() {
        infowindow.setContent('<b>' +readerlocations[i][0] + '</b>');
        infowindow.open(map, marker);
      }
    })(marker, i));
  }
}
google.maps.event.addDomListener(window, 'load', initialize);

</script>
<head>
</head>
<body>
	<h2 align="center">View RFID Readers</h2>
	<table>
		<tr>
			<td height="600px"><%@ include file="Menu.jsp"%>
			</td>
			<td height="600px" width="75%">

				<div  class="outerdiv" id="googleMap" style="width: 1600px; height: 600px;"></div>
			</td>
		</tr>
	</table>
</body>
</html>