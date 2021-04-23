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
	<br />
	<section class="container border rounded bg-black-transparent">
	  <h1 class="is-large-text text-center">User Profile</h1>
	  <div class="row text-center">
	  	<div class="col-2">						
		</div>
	    <div class="col-4 text-left">		  		  
		  <h4 class="p-2">First Name</h4>
		  <h4 class="p-2">Last Name</h4>
		  <h4 class="p-2">Email</h4>
		  <h4 class="p-2">User Name</h4>
		</div>
		<div class="col-4 text-left">		  		  
		  <h4 class="p-2 border rounded"><s:property value="first_name" /></h4>
		  <h4 class="p-2 border rounded"><s:property value="last_name" /></h4>
		  <h4 class="p-2 border rounded"><s:property value="email" /></h4>
		  <h4 class="p-2 border rounded"><s:property value="user_name" /></h4>
		</div>
		<div class="col-2">						
		</div>
	  </div>
	  <div class="justify-content-center h-100 text-center m-4">
		<a href="updatedetails?submitType=updatedata&email=<s:property value="email"/>">
		<button type="button" class="btn btn-danger">Edit</button></a>
	  </div>
	</section>
	<br />
	<s:include value="footer.jsp" />
	
  </body>
</html>