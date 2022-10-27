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
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Update User</h1>
				<form class="row g-3 needs-validation" novalidate
					action="updateUser.do" method="POST">
					<input type = "hidden" value = "${updatedUser.id} " name = "id">
					<div class="col-md-4">
						<label for="firstName" class="form-label">First name</label> <input
							type="text" class="form-control" name="staff.firstName"
							value="${updatedUser.staff.firstName}" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a first name.</div>
					</div>
					<div class="col-md-4">
						<label for="lastName" class="form-label">Last name</label> <input
							type="text" class="form-control" name="staff.lastName"
							value="${updatedUser.staff.lastName}" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a last name.</div>
					</div>
					<div class="col-md-4">
						<label for="username" class="form-label">Username</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								value="${updatedUser.username}" name="username" required>
							<div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div>
						</div>
					</div>
					<div class="col-md-4">
						<label for="role" class="form-label">Role</label> <select
							class="form-select" name="role" required>
							<option selected disabled value="">Choose...</option>
							<option>Supervisor</option>
							<option>Technician</option>
						</select>
						<div class="invalid-feedback">Please select a valid Role.</div>
					</div>
					<div class="col-md-4">
						<!-- <label for="locNumber" class="form-label">Location</label>
						<select class="form-select" name="locNumber" required>
							<option selected disabled value="">Choose...</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select> 
						<div class="invalid-feedback">Please select a valid Location.</div> -->
					</div>
					<div class="col-md-4">
						<label for="password" class="form-label">Password</label> <input
							type="text" class="form-control" name="password"
							value="${updatedUser.password}" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid
							Password.</div>
					</div>
					<div class="col-12">
					
					
					
					
					 <label for="firstName" class="form-label-lg">First Name</label>			
						 <input class="form-control form-control-lg" id="firstName" type="text" placeholder="${updatedUser.staff.firstName}"  required>
						 
						 <label for="lastName" class="form-label-lg">Last Name</label>			
						 <input class="form-control form-control-lg" id="lastName" type="text" placeholder="${updatedUser.staff.lastName}"  required>
						
						 <label for="role" class="form-label-lg">Role</label>			
						 <input class="form-control form-control-lg" id="role" type="text" placeholder="${updatedUser.role}"  required>
						 
						 <label for="role" class="form-label">Role</label> <select class="form-select" name="role" required>
							<option selected disabled value="">Choose Role</option>
							<option>Supervisor</option>
							<option>Technician</option>
						</select>
						 
						 <label for="username" class="form-label-lg">Username</label>			
						 <input class="form-control form-control-lg" id="username" type="text" placeholder="${updatedUser.username}"  required>
						 
						 <label for="password" class="form-label-lg">Password</label>			
					   	 <input type="password" class="form-control form-control-lg" name="password" value="${updatedUser.password }" required> <br><hr>
					
					
						<button class="btn btn-primary" type="submit">Update User</button>
						<br>
					</div>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>