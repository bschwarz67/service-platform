<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<title>tickets</title>
</head>
<body>

<!-- ModelAttribute : tickets -->

<div class=".container-fluid">
	<form action="/service-platform/createTicket">
		<input type="submit" value="create ticket">
	</form>
	
	<div align=center>
		<table border=1 class="table table-striped table-bordered table-responsive">
			<tr>
			  <th>ticket id</th>
			  <th>end user</th>
			  <th>service provider</th>
			  <th>ticket summary</th>
			</tr>
			<c:forEach var="ticket" items="${tickets }">
				<tr>
				  <td>${ticket.ticketID}</td>
				  <td>${ticket.endUser}</td>
				  <td>${ticket.serviceProvider}</td>
				  <td>${ticket.ticketSummary}</td>
				  
				</tr>	
			</c:forEach>
		</table>
	</div>
</div>


</body>
</html>