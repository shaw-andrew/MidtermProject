<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Account</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="navbar.jsp" />
<main class="container-fluid">
<h2>@Autowired - Your Details</h2>

<%-- Output user details --%>
<c:choose>
<c:when test="${not empty sessionScope.loggedInUser}"> 
<h4>First name: <c:out value="${loggedInUser.role}"/></h4>
<%-- <h4>Last name:<c:out value="${loggedInUser.active}"/></h4><br> --%>
User ID: <c:out value="${loggedInUser.id }"/><br>
Data: <c:out value="${loggedInUser }"/>

</c:when>
<c:otherwise>
<h2>User not logged in.</h2>
</c:otherwise>
</c:choose>
</main>
<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>