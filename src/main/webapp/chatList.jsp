<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>inbox</title>
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<s:include value="header.jsp">
		<s:param name="status" value="active" />
	</s:include>
	<!-- Projects-->
	<section class="projects-section bg-radian" id="projects">

		<h1 class="text-center text-secondary">PREVIOUS MESSAGES</h1>
		
		<div class="container border border-white rounded bg-black d-flex flex-column scroll p-4 w-75" >
			<table class="table table-dark text-center">
				<thead>
				  <tr>
					<th scope="col">USER</th>
					<th scope="col">ACTION</th>
				  </tr>
				</thead>
				<tbody>
		<s:iterator value="receiver" status="statusVar">
					<tr>
					<td><s:property/></td>
					<td><a class="round rounded bg-info p-1 text-white" href="message.action?toEmail=<s:property/>&act=chat">read</a></td>
				  	</tr>
		</s:iterator>		  
				  
				</tbody>
			  </table>

		</div>

		

	</section>



	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
