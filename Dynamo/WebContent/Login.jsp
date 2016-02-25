<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>DYNAMO</title>
</head>
 
<body>
<h2>DYNAMO</h2>
<s:actionerror />
<s:form action="login" method="post">
    <s:textfield name="username" key="UserName" size="20" />
    <s:password name="password" key="Password" size="20" />
    <s:submit method="execute" key="login" value="login" align="center" />
</s:form>
<s:url value="addForm" var="url">
   <s:param name="member_id" value="%{member_id}" /> 
</s:url>
<s:a href="%{url}">
   Register New Member
</s:a>
</body>
</html>