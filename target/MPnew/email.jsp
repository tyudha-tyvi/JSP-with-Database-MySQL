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
		<div class="row">
			<div class="col-md-8">
				<div class="well well-sm">
					<form action="sendemail" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="senderEmail">Login</label> <input type="text" name="senderEmail" class="form-control" id="senderEmail" placeholder="Sender email" required="required" />
									<br> <input type="password" class="form-control" id="senderPassword" placeholder="Password" name="senderPassword" required="required" />
								</div>
								<div class="form-group">
									<label for="receiverEmail">Receiver Email</label> <input type="text" name="receiverEmail" class="form-control" id="receiverEmail" placeholder="Receiver email"
										required="required" />
								</div>
								<div class="form-group">
									<label for="subject">Subject</label> <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject" required="required" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="message"> Message</label>
									<textarea name="message" id="message" class="form-control" rows="11" cols="25" required="required" placeholder="Message"></textarea>
								</div>
							</div>
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary pull-right" id="btnContactUs">Send Message</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br />
	<s:include value="footer.jsp" />

  </body>
</html>