<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add Equipment</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Equipment</h1>
				<form class="row g-3 needs-validation" novalidate action=persistUser.do method="POST">
					<div class="col-md-4">
						<label for="name" class="form-label">Equipment Name</label> <input type="text" class="form-control"
							name="name" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a name for your equipment.</div>
					</div>
					<div class="col-md-4">
						<label for="description" class="form-label">Description</label> <input type="text" class="form-control"
							name="description"  required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please describe your equipment.</div>
					</div>
					<div class="col-md-4">
						<label for="equipmentType" class="form-label">Type of Equipment</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								name="equipmentType" required>
								<div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div>
						</div>
					</div>
					<div class="col-md-4">
					
		<!-- 					<label for="role" class="form-label">Role</label>
						<select class="form-select" name="role" required>
							<option selected disabled value="">Choose...</option>
							<option>Supervisor</option>
							<option>Technician</option>
							</select>
							<div class="invalid-feedback">Please select a valid Role.</div> -->
					
					</div>
					<div class="col-md-4">
					</div>
					<div class="col-md-4">
					
		<!-- 				<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" name="password"
							required>
							<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid Password.</div> -->
					
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Create Equipment</button><br>
					</div>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>
