<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Update User</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
	
			<div class="row">
				<h1>@Autowired - Update User Information </h1>
				<hr>
				<br>
				  <form action="updateUser.do" method="POST">
					<input type = "hidden" value = "${updatedUser.id} " name = "id">
					
					 <label for="userId" class="form-label-lg">User ID</label>			
						 <input class="form-control form-control-lg" id="userId" type="text" value="${updatedUser.id}"  disabled readonly>
						 
					 <label for="firstName" class="form-label-lg">First Name</label>			
						 <input class="form-control form-control-lg" id="firstName" type="text" value="${updatedUser.staff.firstName}"  required>
						 
						 <label for="lastName" class="form-label-lg">Last Name</label>			
						 <input class="form-control form-control-lg" id="lastName" type="text" value="${updatedUser.staff.lastName}"  required>
						
						 <label for="role" class="form-label-lg">Role</label> <select class="form-select" name="role" required>
							<option selected disabled value="">${updatedUser.role}</option>
							<option>Supervisor</option>
							<option>Technician</option>
						</select>
						 
						 <label for="username" class="form-label-lg">Username</label>			
						 <input class="form-control form-control-lg" id="username" type="text" value="${updatedUser.username}"  required>
						 
						 <label for="password" class="form-label-lg">Password</label>			
					   	 <input type="password" class="form-control form-control-lg" name="password" value="${updatedUser.password}" required> <br><hr><br>
					
						<button class="btn btn-secondary" type="submit">Update User</button><br><br>
						<br>
					</form>
					<br><br><br><br><br><br>
					<br><br><br><br><br><br>
			</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>