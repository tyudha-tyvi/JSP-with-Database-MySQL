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
	
	<s:include value="header-3.jsp" />
	<div class="container">
	<div class="row text-center">
	  <div class="col-4">						
	  </div>
	  <div class="col-4">
  	  <h4 class="is-large-text">Manage Users</h4>
	  <span><s:property value="message" /></span><br><br>
	  <a class="button" href="profilelist"><button type="button" class="btn btn-info">Manage Users</button></a>
	</div>
	<div class="col-4">						
	  </div>
	</div>
	</div>
	<br />
	<s:include value="footer.jsp" />
	
  </body>
</html>