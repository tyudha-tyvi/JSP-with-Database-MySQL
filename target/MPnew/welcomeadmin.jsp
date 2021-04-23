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
	  <h4 class="is-large-text">Welcome <s:property value="user_name" /></h4>
	  <div class="row border rounded text-center">
    	<div class="col border rounded">
    	  <a class="button" href="profilelist"><button type="button" class="btn btn-info">Manage Users</button></a>
    	</div>
    	<div class="col border rounded">
    	  <a class="button" href="email"><button type="button" class="btn btn-warning">Bulk Email</button></a>
		</div>
  	  </div>
	</div>
	<br />
	<s:include value="footer.jsp" />

  </body>
</html>