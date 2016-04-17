<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
 <%@ include file="/css/style.css"%>
<%@ include file="header.jsp" %>
<head>
<title>Add User</title>
</head>
<body>
<h2 align="center">Add User</h2>
<table>
<tr>
<td height="600px">
<%@ include file="Menu.jsp" %>
</td>
<td height="600px" width="100%">
<div align="center" class="outerdiv" style="margin:0 auto;width:90%;height:inherit;">
<s:actionerror />
<s:form action="addUser" method="post" enctype="multipart/form-data" cssStyle="margin-top:100px;">

	 <s:textfield name = "member_id" hidden="true" value = "%{member_id}"/>
    <s:textfield name="name" key="Name" size="20" />
    <s:textfield name="address" key="Address" size="20" />

    <s:textfield name="skill" key="skill" size="20" />
   
    <s:textfield name="info" key="info" size="20" />
     
    <s:textfield name="zipcode" key="zipcode" size="20" />
    <s:textfield name="role" key="Role" size="20" />
     <s:textfield name="phone" key="phone" size="20" />
    
   
    <s:file name ="userImage" label="Upload Photo"/>
   
   
    <s:submit method="addUser"  cssClass="button" key="addUser" value ="AddUser" align="center" />

</s:form>
</div>
</td>
</tr>
</table>
</body>
</html>

</body>
</html>