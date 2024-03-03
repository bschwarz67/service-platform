<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
	<title>create help ticket</title>
	<!--  <link href="<spring:url value="/resources/createTicket.css"/>" rel="stylesheet"> -->
	<style>
	
		.dropdown {
			display: none;
			margin-left: 0px;
			width: 100%;
		}
		.wrapper {
			position: relative;
		}
		
		.option {
			background-color: white;
			width: 100%;
		}
		
		
		
		#users {
			position: absolute;
			top: 0 px;
		}
		
		#serviceProviders {
			position: absolute;
			top: 0 px;
		}
		
	
	</style>
</head>



<body>
<br>
	<div class=".container-fluid">
		<form:form action="saveTicket" modelAttribute="ticketDTO" method="POST" autocomplete="off" class="form-horizontal">
			<div><form:errors cssClass="error"/></div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-1">end user:</label>
				<div class="wrapper" onclick="displayOptions(this)" onmouseleave="unDisplayOptions(this)" id="usersWrapper">
					<div class="col-sm-4">
						<form:input path="endUser" id="userInput" class="form-control"></form:input>
						<form:errors path="endUser" cssClass="error"/>
						<div class="dropdown" id="users" style="z-index:3">
							<c:forEach var="user" items="${users }">
								<div class="option" onmouseover="highlight(this)" onmouseleave="unHighlight(this)" onclick="select(this)">${user.username}</div>  
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<label class="control-label col-sm-1">service provider:</label>
				<div class="wrapper" onclick="displayOptions(this)" onmouseleave="unDisplayOptions(this)" id="serviceProvidersWrapper">
					<div class="col-sm-4">
						<form:input path="serviceProvider" id="serviceProviderInput" class="form-control"></form:input>
						<form:errors path="serviceProvider" cssClass="error"/>
						<div class="dropdown" id="serviceProviders" style="z-index:2">
							<c:forEach var="serviceProvider" items="${users }">
								<div class="option" onmouseover="highlight(this)" onmouseleave="unHighlight(this)" onclick="select(this)">${serviceProvider.username}</div>  
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-1">ticket summary:</label>
				<div class="wrapper" style="z-index:1">
					<div class="col-sm-4">
						<div >
							<form:textarea path="ticketSummary" class="form-control" rows="5"></form:textarea>
							<form:errors path="ticketSummary" cssClass="error"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="wrapper">
					<div class="col-sm-offset-1 col-sm-8">
						<button type="submit" value="Submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</div>
		
		</form:form>
	</div>

<script>
	//on click on endUser or serviceProvider input box, insert a drop down menu below it with all the current users
	var menu = null;
	var wasClicked = false;
	document.querySelector("#usersWrapper").style.width = document.querySelector("#usersWrapper").getElementsByTagName("input")[0].offsetWidth + "px";
	document.querySelector("#serviceProvidersWrapper").style.width = document.querySelector("#serviceProvidersWrapper").getElementsByTagName("input")[0].offsetWidth + "px";
	document.querySelector("#users").style.width = document.querySelector("#usersWrapper").getElementsByTagName("input")[0].offsetWidth + "px";
	document.querySelector("#serviceProviders").style.width = document.querySelector("#serviceProvidersWrapper").getElementsByTagName("input")[0].offsetWidth + "px";
	
	function displayOptions(e) {
		if(e.id === "usersWrapper") {
			menu = document.querySelector("#users");
		}
		else{
			menu = document.querySelector("#serviceProviders");
		}
		menu.style.display = "block";
		e.onclick = "";
		wasClicked = true;
	}
	
	
	function unDisplayOptions(e) {
		if(wasClicked === true) {
			e.onclick = function(){return displayOptions(e)};
			menu.style.display = "none";
			wasClicked = false;
		}
	}

	function highlight(e) {
		e.style.backgroundColor = "#ccdcff";
	}
	function unHighlight(e) {
		e.style.backgroundColor = "white";
	}
	
	function select(e) {
		if(menu.id === "users") document.querySelector("#userInput").value = e.innerHTML;
		else document.querySelector("#serviceProviderInput").value = e.innerHTML;
		
		menu.style.display = "none";

	}
	
</script>













</body>
</html>