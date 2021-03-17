<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Manager Application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style type="text/css">
		.container{
			background-color: #F5F8FB;
		}
		.upper-container{	
			background-color: #EBF1F7;
			width: 100%;
			padding : 1% 0% 1% 1%;
		}		
	</style>
</head>
<body>
	<H1 class = "text-center my-5">HR Manager Application</H1>
	<div class="container mt-5">
		<div class="row">
		<h3 class = "upper-container">Login</h3>
		<hr>
			<section class="col-md-12">
				<form class="horizontal my-3" name="EnrollmentForm" action="processLogin"  method="post">
					
					<div class="row form-group ">
						<label class="col-3 for" for="username">Username:</label>
						<label class="text-danger">*</label> 
						<div class="col-4">
							<input type="text" class="form-control" name = "username" id="username" required/>
						</div>
					</div>
					<div class="row form-group ">
						<label class="col-3 for" for="password">Password:</label> 
						<label class="text-danger">*</label>
						<div class="col-4">
							<input type="password" class="form-control" name = "password" id="password" required	/>
						</div>
					</div>
					<div class="row form-group ">
						<label class="col-3 for"></label>
						<div class="col-4">
							<a href="${pageContext.request.contextPath}/processRegisteration"><label class="text-info"><u> Create new Account</u></label></a>
						</div>
					</div>
					<div class="lower-container">
						<label class="col-4"></label>
						<label class="col-6 for text-danger">
						<c:if test="${param.HrUsername != null}">
						
						</c:if>
							<% if(pageContext.getAttribute("authorized")!=null && pageContext.getAttribute("authorized").equals("false")){%>
							<b>Invalid Credentials</b>
							<%session.setAttribute("authorized", null);} %>
						</label>
						<button type="submit" class="btn btn-info" value="login">Login >></button>
					</div>
				</form>
			</section>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>