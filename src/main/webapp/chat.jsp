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
<title>chat</title>
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet" />
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

		<h1 class="text-center text-secondary">CHATTING WITH </h1>
		<div class="row m-2 d-flex flex-column align-content-center">
			<img class="round rounded-circle" src="displayImage.action?email=<s:property value='toEmail' />" style="width: 150px;height: 150px;">
		</div>
		
		<div class="container border border-white rounded bg-black d-flex flex-column scroll p-4 w-75" >
			
			
		<s:iterator value="msgList" var="m">
			<s:if test="%{activeEmail.equals(#m.fromEmail)}">

				<div class="bg-secondary border  flex-column w-75 m-3 text-light p-3 align-self-end text-right">				
					<h4 class="m-0 p-0"><s:property value="#m.sender" /></h4>					
					<small class="text-black"><s:property value="#m.msgDate" />, <s:property value="#m.msgTime" /></small>
					<div class="rounded bg-primary p-2 text-left">
					<p><s:property value="#m.msg" /></p>
					</div>				
				</div>								
			</s:if>
			<s:else>
				<div class="bg-secondary border  flex-column w-75 m-3 text-light p-3 align-self-start">				
					<h4 class="m-0 p-0"><s:property value="#m.sender" /></h4>					
					<small class="text-black"><s:property value="#m.msgDate" />, <s:property value="#m.msgTime" /></small>
					<div class="rounded bg-dark p-2">
						<p><s:property value="#m.msg" /></p>
					</div>				
				</div>			</s:else>
			
			


		</s:iterator>
			
			<s:form action="message.action" class="form w-100 d-flex align-self-center p-2" method="post" theme="simple">
				<input class="form-control w-75 h-auto m-1" type="text" placeholder="Message" aria-label="Search" name="msg">
				<input type="hidden" name="act" value="chat" >
				<input type="hidden" name="fromEmail" value="<s:property value='fromEmail' />" >
				<input type="hidden" name="toEmail" value="<s:property value='toEmail' />" >
				<s:submit class="btn btn-primary h-auto w-25 m-1" type="submit" value="SEND"></s:submit>
			</s:form>

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
	<script type="text/javascript">
	$(document).scrollTop($(document).height());
	</script>
</body>
</html>
