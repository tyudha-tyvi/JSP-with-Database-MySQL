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
	<div class="container border rounded bg-black-transparent">
	  <h1 class="is-large-text text-center">Update Profile</h1>
	<form action="updatedetails" method="post">
	<div class="row text-center">
	  <div class="col-2">						
	  </div>
	  <div class="col-4 text-left">		  		  
		<h4 class="p-2">First Name</h4>
		<h4 class="p-2">Last Name</h4>
		<h4 class="p-2">Email</h4>
		<h4 class="p-2">User Name</h4>
		<h4 class="p-2">Password</h4>
	  </div>
	  <div class="col-4 text-left">		  		  
		<h4 class="p-1"><input type="text" name="first_name" value='<s:property value="first_name"/>'></h4>
		<h4 class="p-1"><input type="text" name="last_name" value='<s:property value="last_name"/>'></h4>
		<h4 class="p-1"><input type="email"  name="email" value='<s:property value="email"/>'><input type="hidden" name="emailhidden" value='<s:property value="email"/>'></h4>
		<h4 class="p-1"><input type="text" name="user_name" value='<s:property value="user_name"/>'></h4>
		<h4 class="p-1"><input type="password" name="password" value='<s:property value="password"/>'></h4>
	  </div>
	  <div class="col-2">						
	  </div>
	</div>
	<div class="justify-content-center h-100 text-center m-4">	  	  
	  <button name="submitType" value="update" type="submit" class="btn btn-success">Update</button>
	</div>
	</form>
  </div>
  <br />
  <s:include value="footer.jsp" />
		
  </body>
</html>