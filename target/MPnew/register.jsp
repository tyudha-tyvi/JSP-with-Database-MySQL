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
    <div class="container d-flex justify-content-center">
      <div class="card">
      	<div class="card-header text-center">
		  <h3>Register</h3>
		</div>
	  	<div class="card-body">
      <s:form action="registeruser" method="post">                          
		<s:textfield label="First Name" name="first_name" class="form-control" placeholder="Firstname" required="required"></s:textfield>
		<s:textfield label="Last Name" name="last_name" class="form-control" placeholder="Lastname" required="required"></s:textfield>
		<s:textfield type="email" label="Email" name="email" class="form-control" placeholder="you@example.com" required="required"></s:textfield>
		<s:textfield label="User Name" name="user_name" class="form-control" placeholder="Username" required="required"></s:textfield>
		<s:password id="password" label="Password" name="password" class="form-control" placeholder="Password" required="required"></s:password>
		<s:password id="password2" label="Confirm Password" class="form-control" placeholder="Password" required="required"></s:password>
		<s:submit class="btn btn-primary btn-lg btn-block" value="Register" onclick="return Validate()"></s:submit> 
	  </s:form>
	  </div>
	  	<div class="card-footer">
	  <p class="lead">Already have an account ? <a href="loginform">Login</a></p>
    </div>
	  </div>
    </div>
    <br />
    <s:include value="footer.jsp" />   
    
    <script type="text/javascript">
	  function Validate() {
	  	var password = document.getElementById("password").value;
	  	var confirmPassword = document.getElementById("password2").value;
	  	if (password != confirmPassword) {
		  alert("Passwords do not match.");
		  	return false;
	  	}
	  	  return true;
	  }
  	</script>
   
  </body>
</html>