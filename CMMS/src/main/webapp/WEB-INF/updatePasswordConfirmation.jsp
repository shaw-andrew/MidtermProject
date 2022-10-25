<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Confirmation</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<h1>Change Password Confirmation</h1>

		<div>
		<c:choose>
		<c:when test="${empty update}">
		<p>An error occurred. Password was not updated. Please try again.</p>
		</c:when>
		<c:otherwise>
		<p><a href="getPark.do?pid=${update.id }">${update.username}</a> was updated successfully!</p>
		</c:otherwise>
		</c:choose>
	
		</div>
		
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>