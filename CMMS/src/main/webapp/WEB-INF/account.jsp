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
<h1>@Autowired - Your Details</h1>
<hr><br>
<%-- Output user details --%>
<c:choose>
<c:when test="${not empty sessionScope.loggedInUser}"> 
<form action="updatePassword.do" method="POST">
<h4>First Name: <c:out value="First Name"/></h4>
<h4>Last Name: <c:out value="Last Name"/></h4><br>
<h4>Role: <c:out value="${loggedInUser.role}"/></h4><br>
<h4>Username: <c:out value="${loggedInUser.username}"/></h4>
<h4>Password:</h4> <input type="password" class="form-control" id="validationCustom01" value="${loggedInUser.password }" required>
<input type="hidden" name="id" value="${logedInUser.id }" />
<button class="btn btn-primary" type="submit">Update Password</button></form> 

<c:if test="${loggedInUser.role == 'supervisor' }"> 
<a class="btn btn-secondary" href="addOrUpdate.do" role="button">Add or Update User</a> </c:if>
<hr>
<br>


</c:when>
<c:otherwise>
<h2>User not logged in.</h2>
</c:otherwise>
</c:choose>
</main>
<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>