<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <title>ABC</title>
    <link href="css/bootstrap.css" rel="stylesheet" />
  </head>
  <body class="bg">
	
	<s:include value="header-1.jsp" /> 
	<span style="color: green;"><s:property value="Message" /></span>
	<h2>Thank you for registering</h2><br />
	<p class="lead">Click Here to <a href="loginform">Login</a></p>
	<br />
	<s:include value="footer.jsp" />
	
  </body>
</html>