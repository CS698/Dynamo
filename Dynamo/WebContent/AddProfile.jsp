<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<%@ include file="/css/style.css"%>
<%@ include file="header.jsp" %>
<head>
<title>Add Responder</title>
</head>
 
<body>
<h2 align="center">Add Responder</h2>
<table>
<tr>
<td height="600px">
<%@ include file="Menu.jsp" %>
</td>
<td height="600px" width="75%">
<div align="center">
<s:actionerror />
<s:form action="add" method="post" enctype="multipart/form-data">
	 <s:textfield name = "member_id" hidden="true" value = "%{member_id}"/>
    <s:textfield name="name" key="Name" size="20" />
    <s:textfield name="address" key="Address" size="20" />

    
 <s:select name="skill" key ="Skills"  list="#{'Select':'Select Skill','doctor':'doctor', 'police':'police',

                    'comander':'comander'}"/>
 
    
   
    <s:textfield name="info" key="Organization" size="20" />
     
    <s:textfield name="zipcode" key="zipcode" size="20" />
    <s:textfield name="role" key="Role" size="20" />
     <s:textfield name="phone" key="phone" size="20" />
    <s:textfield name="tagId" key="Tag ID" size="20" />
   
    <s:file name ="userImage" label="Upload Photo"/>
   
   
    <s:submit method="add" key="add" value ="Add Responder" align="center" />
</s:form>
</div>
</td>
</tr>
</table>

</body>
</html>