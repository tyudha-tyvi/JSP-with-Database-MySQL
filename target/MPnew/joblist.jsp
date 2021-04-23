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
  	  <h4 class="is-large-text">Job List</h4>
	  <table class="table">
		<thead class="thead-dark"> 
		  <tr>
			<th>Job Name</th>
			<th>Company</th>
			<th>Address</th>
			<th>Deadline</th>
		  </tr>
		</thead>
		<s:iterator value="beanList">
		  <tr>
			<td><s:property value="job_name" /></td>
			<td><s:property value="company" /></td>
			<td><s:property value="address" /></td>
			<td><s:property value="deadline" /></td>
			<td>
			  <a href="">
				<button type="button" class="btn btn-success">Apply</button>
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