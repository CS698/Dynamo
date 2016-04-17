<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 200px;
}

li a {
	display: block;
	color: white;
	padding: 8px 0 8px 16px;
	text-decoration: none;
	height: 50px;
	font-size: 20px
}

/* Change the link color on hover */
li a:hover {
	background-color: #FF0099;
	color: white;
}

.menu {
	border-radius: 25px;
	padding: 20px;
	background: linear-gradient(to left, #5f2c82, #49a09d);
	-webkit-box-shadow: 7px 7px 5px 0px rgba(50, 50, 50, 0.75);
	-moz-box-shadow: 7px 7px 5px 0px rgba(50, 50, 50, 0.75);
	box-shadow: 10px 10px 10px 0px rgba(50, 50, 50, 0.75);
}
</style>


<div style="height: 100%;" class="menu">

	<ul>
		
		<li><s:url value="addFormUser" var="url"></s:url>
		 <s:a href="%{url}"> Add User</s:a>
		</li>
		<li><s:url value="addForm" var="url"></s:url>
		 <s:a href="%{url}"> Add Responder</s:a>
		</li>
		<li><s:a href="ViewRFIDReader.jsp">View RFID Reader</s:a></li>
		<li><s:a href="SearchResponders.jsp">Search Responder</s:a></li>
		<li><s:a href="MapMultiLocation.jsp">View Map</s:a></li>
		<li><s:a href="MapMultiLocation.jsp">Find Path</s:a></li>
		<li><s:url value="addUAV" var="url"></s:url>
		 <s:a href="%{url}"> UAV Data</s:a>
		</li>
		<li><s:a href="Login.jsp">Log Out</s:a></li>
		
	
		
	</ul>
</div>
</html>