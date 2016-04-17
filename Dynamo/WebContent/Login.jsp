<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>DYNAMO Project</title>
</head>
<%@ include file="/css/style.css"%>
<%@ include file="header.jsp" %>
<body>
<br/>
<div align="center" class="outerdiv" style="width:50%;margin:0 auto;">
<h2>Please enter user name and password:</h2>
<s:actionerror />
<s:form action="login" method="post">
    <s:textfield name="username" label="User Name" size="20" />
    <span></span>
    <s:password name="password" label="Password"  size="20" />
    <span></span>
    <s:submit cssClass="button" method="execute" value="login" align="center" />
</s:form>
<s:url value="addForm" var="url">
   <s:param name="member_id" value="%{member_id}" /> 
</s:url>

</div>

</body>
</html>