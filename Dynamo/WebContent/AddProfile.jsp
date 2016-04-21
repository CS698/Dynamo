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
<td height="600px" width="100%">
<div align="center" class="outerdiv" style="margin:0 auto;width:90%;height:inherit;">
<s:actionerror />
<s:form action="add" method="post" enctype="multipart/form-data" cssStyle="margin-top:100px;">
	 <s:textfield name = "member_id" hidden="true" value = "%{member_id}"/>
    <s:textfield name="name" label="Name" size="20" />
    <s:textfield name="address" label="Address" size="20" />

    
 <s:select name="skill" key ="Skills"  list="#{'Select':'Select Skill','Security guards':'Security guards','EMS':'EMS','Life guards':'Life guards','fire fighters':'fire fighters','doctor':'doctor', 'police':'police',

                    'comander':'comander'}"/>
 
    
   
    <s:textfield name="info" label="Organization" size="20" />
     
    <s:textfield name="zipcode" label="Zipcode" size="20" />
   
     <s:textfield name="phone" label="Phone" size="20" />
    <%-- <s:textfield name="tagId" key="Tag ID" size="20" /> --%>
    <s:select label="Tag ID" headerKey="-1" headerValue="Select Tag Id" list="tagIds" name="tagId" value="-1" /> 
    <s:file name ="userImage" label="Upload Photo"/>
   
   
    <s:submit cssClass="button" method="add" label="ADD" value ="Add Responder" align="center" />
</s:form>
</div>
</td>
</tr>
</table>

</body>
</html>