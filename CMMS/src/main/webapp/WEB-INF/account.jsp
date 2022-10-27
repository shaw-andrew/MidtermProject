<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<hr>
		<br>
		<%-- Output user details --%>
		<c:choose>
			<c:when test="${not empty sessionScope.loggedInUser}">
				<form action="updatePassword.do" method="POST">
				
						 <label for="firstName" class="form-label-lg">First Name</label>			
						 <input class="form-control form-control-lg" id="firstName" type="text" placeholder="${loggedInUser.staff.firstName}"  disabled>
						 
						 <label for="lastName" class="form-label-lg">Last Name</label>			
						 <input class="form-control form-control-lg" id="lastName" type="text" placeholder="${loggedInUser.staff.lastName}"  disabled>
						
						 <label for="role" class="form-label-lg">Role</label>			
						 <input class="form-control form-control-lg" id="role" type="text" placeholder="${loggedInUser.role}"  disabled>
						 
						 <label for="username" class="form-label-lg">Username</label>			
						 <input class="form-control form-control-lg" id="username" type="text" placeholder="${loggedInUser.username}"  disabled>
						 
						 <label for="password" class="form-label-lg">Password</label>			
					   	 <input type="password" class="form-control form-control-lg" name="password" value="${loggedInUser.password }" required> <br><hr>
					   	 
						<input type="hidden" name="id" value="${loggedInUser.id }" /><br><br>
					<button class="btn btn-primary" type="submit">Update Password</button><br><br>
				</form>

				<c:if test="${loggedInUser.role == 'Supervisor' }">
					<a class="btn btn-secondary" href="addUser.do" role="button">Add User</a>
				</c:if><br><br><br>
				<hr>
				<br><br><br>

			</c:when>
			<c:otherwise>
				<h2>User not logged in.</h2>
			</c:otherwise>
		</c:choose>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>