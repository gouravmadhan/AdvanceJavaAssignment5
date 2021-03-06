<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
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

input[type=date], input[type="text"] {
	width: 100%;
	padding: 12px; /* Some padding */
	border: 1px solid #ccc; /* Gray border */
	border-radius: 4px; /* Rounded borders */
	margin-top: 3px; /* Add a top margin */
	margin-bottom: 3px; /* Bottom margin */
}
</style>
<title>Upload Employee</title>
</head>
<body>
	<c:if test="${param.HrUsername != null}">
		<header>
			<div>
				<table width="100%">
					<tr>
						<td>
							<h2>
								Welcome
								<c:out value="${param.HrUsername}" />
								! You can add new Employees here.
							</h2>
						</td>
						<td align="right">
							<form action="SignOut">
								<input type="submit" value="SignOut" />
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<br>

		<div class="container">
			<br> <br>
			<form action="Upload" method="post">
				<table align="center">
					<tr>
						<td>Employee Name :</td>
						<td><input type="text" name="empName" /></td>
					</tr>
					<tr>
						<td>Location :</td>
						<td><input type="text" name="location" /></td>
					</tr>
					<tr>
						<td>E-Mail :</td>
						<td><input type="text" name="email" /></td>
					</tr>

					<tr>
						<td>Date of birth :</td>
						<td><input type="date" name="dateOfBirth" /></td>
					</tr>

					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="upload" /></td>
					</tr>
				</table>
				<input type="hidden" name="HrUsername" value="${param.HrUsername}" />
			</form>
			<br> <br>

		</div>
	</c:if>
	<c:if test="${param.HrUsername == null}">
		<c:redirect url="home.jsp" />
	</c:if>
</body>
</html>