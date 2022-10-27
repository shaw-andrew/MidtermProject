<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add User</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container">
			<div class="row">
				<h1>@Autowired - Add User</h1><hr><br><br>
				<form  action=persistUser.do method="POST">
					 <label for="firstName" class="form-label-lg">First Name</label>			
						 <input class="form-control form-control-lg" id="firstName" type="text" placeholder="First Name"  required>
						 
						 <label for="lastName" class="form-label-lg">Last Name</label>			
						 <input class="form-control form-control-lg" id="lastName" type="text" placeholder="Last Name"  required>
						
						  <label for="role" class="form-label-lg">Role</label> <select class="form-select" name="role" required>
							<option selected disabled value="">Select Role</option>
							<option>Supervisor</option>
							<option>Technician</option>
						</select>
						 
						 <label for="username" class="form-label-lg">Username</label>			
						 <input class="form-control form-control-lg" id="username" type="text" placeholder="Username"  required>
						 
						 <label for="password" class="form-label-lg">Password</label>			
					   	 <input type="password" class="form-control form-control-lg" name="password" value="Password" required> <br><hr><br>
						<button class="btn btn-primary" type="submit">Create New User</button><br>
					</form>
				</div>
				<br><br><br><br><br><br><br><br>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>