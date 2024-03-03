<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- ModelAttribute : users -->



	<table border=1>
		<tr>
		  <th>id</th>
		  <th>job</th>
		  <th>enabled</th>
		</tr>
		<c:forEach var="user" items="${users }">
			<tr>
			  <td>${user.username}</td>
			  <td>${user.jobTitle}</td>
			  <c:choose>
				  <c:when test="${user.enabled == true}" >
				  	<td>true</td>
				  </c:when>
				  <c:otherwise>
				  	<td>false</td>
				  </c:otherwise>
			  </c:choose>
			</tr>	
		</c:forEach>
	</table>




</body>
</html>