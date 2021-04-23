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
  	<br />	
	<div class="container text-center d-flex justify-content-center">
		<div class="card">
		  <div class="card-header">
		<h3>Login User</h3>
	  </div>
	  <div class="card-body">
      <s:form action="login" theme="simple">  
      <s:textfield type="email" name="email" class="form-control" placeholder="you@example.com"></s:textfield><br />
      <s:password name="password" class="form-control" placeholder="Password"></s:password> <br />
      <s:submit class="btn btn-lg btn-primary btn-block" value="Login"></s:submit>  
      </s:form>
      </div>
      <div class="card-footer">
      <p class="lead">Don't have an account ? <a href="registerform">Sign Up</a></p>
      <p class="lead"><a href="password">Forgot your password ?</a></p>
      <p class="lead">Or Login as <a href="adminform">Admin</a></p>
      </div> 
    </div> 
    </div>   
    <br /> 
    <s:include value="footer.jsp" />
	
  </body>
</html>