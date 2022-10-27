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
				<h1>@Autowired - Update User</h1>
				  <form action="updateUser.do" method="POST">
					<input type = "hidden" value = "${updatedUser.id} " name = "id">
					
					 <label for="firstName" class="form-label-lg">First Name</label>			
						 <input class="form-control form-control-lg" id="firstName" type="text" placeholder="${updatedUser.staff.firstName}"  required>
						 
						 <label for="lastName" class="form-label-lg">Last Name</label>			
						 <input class="form-control form-control-lg" id="lastName" type="text" placeholder="${updatedUser.staff.lastName}"  required>
						
						 <label for="role" class="form-label-lg">Role</label> <select class="form-select" name="role" required>
							<option selected disabled value="">Choose Role</option>
							<option>Supervisor</option>
							<option>Technician</option>
						</select>
						 
						 <label for="username" class="form-label-lg">Username</label>			
						 <input class="form-control form-control-lg" id="username" type="text" placeholder="${updatedUser.username}"  required>
						 
						 <label for="password" class="form-label-lg">Password</label>			
					   	 <input type="password" class="form-control form-control-lg" name="password" value="${updatedUser.password }" required> <br><hr>
					
						<button class="btn btn-primary" type="submit">Update User</button><br><br><br>
						
						<br>
					</form>
					<br><br><br><br><br><br>
			</div>
		
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>