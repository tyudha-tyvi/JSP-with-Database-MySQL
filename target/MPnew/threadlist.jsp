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
  	  <h4 class="is-large-text">Thread List</h4>
	  <table class="table">
		<thead class="thead-dark"> 
		  <tr>
			<th>Title</th>
			<th>Discussion</th>
		  </tr>
		</thead>
		<s:iterator value="beanList">
		  <tr>
			<td><s:property value="title" /></td>
			<td><s:property value="text" /></td>
			<td>
			  <a href="">
				<button type="button" class="btn btn-success">View and Comment</button>
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