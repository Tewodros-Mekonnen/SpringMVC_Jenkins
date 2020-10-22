<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="/resources/assets/favicon.ico?" type="image/x-icon" />
<title>Tewodros Mekonnen - Add Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">

		<div id="header">
			<h2>CRM - Customer Registration Manager</h2>
		</div>

	</div>

	<div>
		<h2>Save Customers</h2>
	</div>

	<div>

		<!-- inside the form, when we click save button, the method inside CustomerController with 'saveCustomer' mapping will run -->
		<form:form action="saveCustomer" modelAttribute="customer"  method="POST" >

			<!-- need to associate this data with customer id, if we don't add this code, when we 
			update data, it will just make it a new entry instead of update -->
			<form:hidden path="id" />


			<table>

				<tbody>

					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>

					</tr>

					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr></tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save " ></td>
					</tr>

				</tbody>


			</table>

		</form:form>
		
		<div style=" clear; both; " ></div>
		<!-- input button: Back To List -->
		<input class="add-button" type="button" value="Back to List"
		       onclick="window.location.href='${pageContext.request.contextPath}/customers/list'; return false; " />

	</div>


</body>
</html>