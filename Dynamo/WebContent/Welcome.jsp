<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>ADMIN PAGE</h1>
<h2> PROFILE</h2>
<s:iterator value="profileViewLst">  
  
Name :<s:property value="name"/><br/>  
Address :<s:property value="address"/><br/>  
Phone Number :<s:property value="phone"/><br/>  

Country Code :<s:property value="name"/><br/>
Email Address :<s:property value="email"/><br/>

Date of Birth:<s:property value="name"/><br/>    
 
</s:iterator>  

</body>
</html>