<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>login</title>
</head>
<body>
	<div class=".container-fluid">
		<h1 class="col-sm-offset-1">Please Log In</h1>
			
					
			<form action="login" method="POST" class="form-horizontal">
			
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-4">
						<input type="text" name="username" placeholder="Username" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-4">
						<input type="password" name="password" placeholder="Password" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-4">
						<button type="submit" value="login" class="btn btn-default">Log in</button>
					</div>
				</div>
				
			</form>
			<a href="/service-platform/createAccount" class="col-sm-offset-1">no account? create one</a>
	</div>
</body>
</html>