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
      <div>
		<h3 class="text-center">Thread Post</h3>
	  </div>
	  <div class="row text-center">
	  <div class="col-3">						
	  </div>
	  <div class="col-6 text-left">
      <s:form action="postthread" method="post">                          
		<s:textfield label="Title" name="title" class="form-control" placeholder="Title"></s:textfield>
		<s:textfield label="Discussion" name="text" class="form-control" placeholder="Text"></s:textfield>
		<s:submit class="btn btn-primary btn-lg btn-block" value="Post"></s:submit> 
	  </s:form>
	  </div>
		<div class="col-3">						
	  </div>
	  </div>
    </div>
    <br />
    <s:include value="footer.jsp" />   
   
  </body>
</html>