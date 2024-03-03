<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>create an account</title>
</head>

<body>
	<br>
	<div class=".container-fluid">
		<form:form action="saveAccount" modelAttribute="userDTO" method="POST" class="form-horizontal">
			<div><form:errors cssClass="error"/></div>
			
			<div class="form-group">
				<label class="control-label col-sm-1">username:</label>
				<div class="col-sm-4">
					<form:input path="username" class="form-control"></form:input>
					<form:errors path="username" cssClass="error"/>
				</div>
			</div>			
			
			<div class="form-group">
				<label class="control-label col-sm-1">password:</label>
				<div class="col-sm-4">
					<form:input path="password" class="form-control"></form:input>
					<form:errors path="password" cssClass="error"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-1">job title:</label>
				<div class="col-sm-4">
					<form:input path="jobTitle" class="form-control"></form:input>
					<form:errors path="jobTitle" cssClass="error"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-8">
					<button type="submit" value="Submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>