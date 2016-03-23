<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Add</title>
</head>
 
<body>
<h2>Add New Member</h2>
<s:actionerror />
<s:form action="add" method="post" enctype="multipart/form-data">
	 <s:textfield name = "member_id" hidden="true" value = "%{member_id}"/>
    <s:textfield name="name" key="Name" size="20" />
    <s:textfield name="address" key="Address" size="20" />

    <s:textfield name="skill" key="skill" size="20" />
   
    <s:textfield name="info" key="info" size="20" />
     
    <s:textfield name="zipcode" key="zipcode" size="20" />
    <s:textfield name="role" key="Role" size="20" />
     <s:textfield name="phone" key="phone" size="20" />
    
   
    <s:file name ="userImage" label="Upload Photo"/>
   
   
    <s:submit method="add" key="add" value ="Add" align="center" />
</s:form>
</body>
</html>