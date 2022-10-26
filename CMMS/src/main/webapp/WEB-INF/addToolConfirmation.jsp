<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Tool Confirmation</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<h1>Add Tool Confirmation</h1>

		<div>
		<c:choose>
		<c:when test="${empty newTool}">
		<p>An error occurred. Account was not created. Please try again.</p>
		</c:when>
		<c:otherwise>
		<p>${newTool.name} was added successfully!</p>
		</c:otherwise>
		</c:choose>
	
		</div>
		
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>