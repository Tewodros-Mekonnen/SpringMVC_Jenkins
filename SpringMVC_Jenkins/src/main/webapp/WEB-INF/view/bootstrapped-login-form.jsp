<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	<link rel="shortcut icon" href="/resources/assets/favicon.ico?" type="image/x-icon" />
	<title>Tewodros Mekonnen - Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div>
				<p>Please use the following credentials to test the app, or feel free to create your own
				   user name and password by clicking "Register New User" button! <br>
				     1.username = kalkidan, password = fun123 (ADMIN)<br>
				     2.username = melkam, password = fun123 (MANAGER) </p>
				<p>Thank you!</p>     
			
			</div>
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form:form 
						  action="${pageContext.request.contextPath}/authenticateTheUser" 
						  method="POST" class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
								
									<!-- Check for login error -->
								
									<c:if test="${param.error != null}">
										
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password.
										</div>
		
									</c:if>
										
									<!-- Check for logout -->

									<c:if test="${param.logout != null}">
										            
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out.
										</div>
								    
									</c:if>
									
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input type="text" name="username" placeholder="username" class="form-control">
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="password" class="form-control" >
						</div>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</div>

						<!-- manually adding tokens ... -->

						<input type="hidden"
							   name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
						
					</form:form>

				</div>
				
			</div>

			<div>
				<a href="${pageContext.request.contextPath}/register/showRegistrationForm" class="btn btn-primary" role="button" aria-pressed="true">Register New User</a>
			</div>
			<div></div>
			<div></div><br><br>
			<div>
				<p>Welcome to Customer Relationship Management app, developed by <span id="my-name" >Tewodros Mekonnen!</span></p>
				<p>Users of this app are classified in three Roles: ADMIN, MANAGER and EMPLOYEE.</p>
				<p>Feel free to register by clicking "Register New User" button! You will be registered as ROLE-EMPLOYEE.<br>
				   Employees can only see registered customers, they are not authorized to add, update or delete the list!</p>
				<p>To get full authorization, you must login as ADMIN or MANAGER. Use the following credentials:<br>
				     1.username = kalkidan, password = fun123 (ADMIN)<br>
				     2.username = melkam, password = fun123 (MANAGER) </p>
				<p>Thank you!</p>     
			
			</div>

		</div>

	</div>

</body>
</html>