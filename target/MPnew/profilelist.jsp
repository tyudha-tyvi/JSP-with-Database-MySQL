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
  	  <h4 class="is-large-text">Manage Users</h4>
	  <table class="table">
		<thead class="thead-dark"> 
		  <tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Action</th>
		  </tr>
		</thead>
		<s:iterator value="beanList">
		  <tr>
			<td><s:property value="first_name" /></td>
			<td><s:property value="last_name" /></td>
			<td><s:property value="email" /></td>
			<td><s:property value="user_name" /></td>
			<td><s:property value="Password" /></td>
			<td>
			  <a href="updatedetailsadmin?submitType=updatedata&email=<s:property value="email"/>">
			  	<button type="button" class="btn btn-success">Update</button>
			  </a>
			  <a href="deleterecord.action?email=<s:property value="email"/>">
				<button type="button" class="btn btn-danger">Delete</button>
			  </a>
			  <a href="message.action?toEmail=<s:property value="email" />&act=chat">
				<button type="button" class="btn btn-dark">Chat</button>
			  </a>
			</td>
		  </tr>
		</s:iterator>
	  </table> 	
  	</div>
  	<br />
  	<s:include value="footer.jsp" />	
		
  </body>
</html>