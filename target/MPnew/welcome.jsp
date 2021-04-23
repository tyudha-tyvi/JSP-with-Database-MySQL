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
  
  	<s:include value="header-2.jsp" />
	<div class="container">
	  <h4 class="is-large-text">Welcome <s:property value="user_name" /></h4>
	  <div class="row border rounded text-center">
    	<div class="col border rounded">
    	  <a class="button" href='profileuser.action?email=<s:property value="email" />'><button type="button" class="btn btn-info">Profile</button></a>
    	</div>
    	<div class="col border rounded">
    	  <a class="button" href="jobform"><button type="button" class="btn btn-warning">Post Job</button></a>
    	  <a class="button" href="joblist"><button type="button" class="btn btn-warning">List Jobs</button></a>
		</div>
    	<div class="col border rounded">
    	  <a class="button" href="threadform"><button type="button" class="btn btn-dark">Post Thread</button></a>
    	  <a class="button" href="threadlist"><button type="button" class="btn btn-dark">List Thread</button></a>
		</div>
    	<div class="col border rounded">
    	  <a class="button" href="searchuser"><button type="button" class="btn btn-secondary">Search User</button></a>
		</div>
		<div class="col border rounded">
    	  <a class="button" href="inbox"><button type="button" class="btn btn-light">Inbox</button></a>
		</div>
  	  </div>
	</div>
	<br />
	<s:include value="footer.jsp" />
	
</body>
</html>