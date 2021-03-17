<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord" %>

<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
.result {
	width: 100%;
	border-collapse: collapse;
	background-color: #f2f2f2;
}

.result td {
	text-align: center;
	height: 25px;
	border: 1px solid black;
	padding: 6px 10px;
}

th {
	text-align: center;
	height: 50px;
	border: 1px solid black;
}

 .emp_row:hover{
  cursor: pointer;
  background-color: #ccc;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
  background-color: #4169E1;
}


		</style>
	<title>Home</title>
	</head>
	<body>
		<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>Welcome <c:out value = "${ HrUsername}"/> ! You can manage employees here.</h2>
						</td>
						<td align = "right">
							<form action="SignOut">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<fieldset>
		<legend>   <h3>&nbsp Employee Listings &nbsp</h3>   </legend>
		<div>
  			<div align = "center">

					<div align=center>
					<a href="upload.jsp?HrUsername=${HrUsername}" > <input
						type="submit" value="Upload Employee Details" />
					</a>
					</div>
				
				<br>
				
				<div align="center">
					<form action="Download" >
						<input type="hidden" name="HrUsername" value="${HrUsername}"> 
						<input type="button" value="Download Employee Details" />
					</form>
				</div>
				</div>
  			
  			
  			
  			<br>
  			
  			<table class = "result">
  				<tr>
  					<th>Employee Code</th>
  					<th>Employee Name</th>
  					<th>Employee Location</th>
  					<th>Employee E-mail</th>
  					<th>Employee D.O.B</th>
  					<th>Actions</th>
  				</tr>
  				<c:forEach items = "${employees}" var = "employee">
				
				<tr class = "emp_row">
  					<td>${employee.getEmpId()}</td>
  					<td>${employee.getEmpName()}</td>
  					<td>${employee.getLocation()}</td>
  					<td>${employee.getEmail()}</td>
  					<td>${employee.getDateOfBirth()}</td>
					<td>
						<form action = "EditEmployee" method = "get">
							<input type = "hidden" name = "empId" value = "${employee.getEmpId()}">
							<input type = "hidden" name = "HrUsername" value = "${HrUsername}">
							<input type = "submit" value = "Edit" >
						</form>
						
					</td>
				</tr>
				
				
  			</c:forEach>
  			</table>
  			
		</div>
		
		<br>
		<br>

		</fieldset>
	</body>
	
</html>