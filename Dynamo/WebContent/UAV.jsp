<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/css/style.css"%>
<%@ include file="header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h2 align="center" >UAV DATA</h2>

<table>
<tr>
<td height="600px">
<%@ include file="Menu.jsp" %>
</td>
<td height="600px">
<embed type="application/x-mplayer2" pluginspage="http://www.microsoft.com/Windows/MediaPlayer/" name="mediaplayer1" ShowStatusBar="true" EnableContextMenu="false" autostart="true" width="1600" height="600" loop="false" src="http://localhost:8080/Dynamo/Videos/SampleVideo.mp4" />
</td>
</tr>
</table>
</body>
</html>
