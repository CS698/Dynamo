<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/css/style.css"%>
<%@ include file="header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<h2 align="center">Welcome Admin!</h2>

<table>
<tr>
<td height="600px">
<%@ include file="Menu.jsp" %>
</td>
<td height="600px" width="75%">
<div align="center">
<h2 align="center"> PROFILE</h2>
<s:iterator value="profileViewLst">  
  
Name :<s:property value="name"/><br/>  <br/> 
 
Phone Number :<s:property value="phone"/><br/>  <br/> 
Address :<s:property value="address"/><br/> <br/> 

Email Address :<s:property value="email"/><br/><br/> 
  
 
 
<s:url value="addForm" var="url">
   <s:param name="member_id" value="%{member_id}" /> 
</s:url>
<%-- <s:a href="%{url}">
    Add First Responder
</s:a>

<s:url value="addFormUser" var="url">
   <s:param name="member_id" value="%{member_id}" /> 
</s:url>
<s:a href="%{url}">
    Add User
</s:a> --%>
</s:iterator> 
</div>
</td>
</tr>
</table>

</body>
</html>