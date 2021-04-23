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
  	<section class="projects-section bg-radian" id="projects">
		<div class="container border rounded bg-black-transparent">
		
			<div class="row text-center pt-3 ">
				<s:form action="search.action" class="form w-100 d-flex align-self-center p-2" method="post" theme="simple">
					<input class="form-control w-75 h-auto m-1" type="text"	placeholder="Search" aria-label="Search" name="basicKeyWord" >
					<s:submit class="btn btn-primary h-auto w-25 m-1" type="submit" theme="simple" value="Search"></s:submit>
					<input type="hidden" name="act" value="basicSearch" >
				</s:form>
			</div>
			
			<button class="btn btn-warning" type="button" data-toggle="collapse"
				data-target="#collapseAdvanceSearch" aria-expanded="false"
				aria-controls="collapseExample">Advance Search</button>
			<div class="collapse" id="collapseAdvanceSearch">
				<s:form action="search.action"  method="post" theme="simple">
					<div class=" row w-100  p-3 text-center">
						<div class="col-12 text-left">
							<h3>Email</h3>
							<input class="p-2 border rounded w-100 m-1" type="text"	name="keyWordEmail">
							<h3>First Name</h3>
							<input class="p-2 border rounded w-100 m-1" type="text" name="keyWordFirst_Name">
							<h3>Last Name</h3>
							<input class="p-2 border rounded w-100 m-1" type="text" name="keyWordLast_Name">
							<h3>User Name</h3>
							<input class="p-2 border rounded w-100 m-1" type="text" name="keyWordUser_Name">
							<input type="hidden" name="act" value="advanceSearch" >
						</div>
						<div class="text-center w-100">
							<s:submit class="btn btn-primary h-auto w-25 m-2" type="submit" value="search" theme="simple"></s:submit>
						</div>

					</div>
				</s:form>
			</div>
			<div class="row text-center pt-3 "></div>
		</div>
	</section>
	<h1 class="text-center">RESULT</h1>
	<s:if test="%{dataResult='true'}">
		<section class="mb-0 w-100">
		<div class="row justify-content-center">
		<s:iterator value="listUser">
				<div class="col-sm-3 border rounded bg-light d-flex flex-column align-items-center m-2">
					<div class="card-body d-flex flex-column align-items-center">
					  <h5 class="card-title"><s:property value="firstName"/> <s:property value="lastName"/></h5>
					  <p class="card-text"><s:property value="company"/></p>
					  <a href="userProfile?email=<s:property value="email" />" class="btn btn-info p-2 mb-1">view</a>
					  <a href="message.action?toEmail=<s:property value="email" />&act=chat" class="btn btn-danger p-2 mt-1">chat</a>
					</div>
				  </div>	
		</s:iterator>
		</div>  
	</section>
	</s:if>
	<s:if test="%{dataResult='false'}">
	<h2 class="text-center text-danger">no data</h2>
	</s:if>
	<br />
	<s:include value="footer.jsp" />

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
  </body>
</html>