<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add or Update User</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">


				<h1>@Autowired - Create/Update User</h1>
				<form class="row g-3 needs-validation" novalidate action=addOrUpdate.do method="POST">
					<div class="col-md-4">
						<label for="firstName" class="form-label">First
							name</label> <input type="text" class="form-control"
							name="firstName" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a first name.</div>
					</div>
					<div class="col-md-4">
						<label for="lastName" class="form-label">Last
							name</label> <input type="text" class="form-control"
							name="lastName"  required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a last name.</div>
					</div>
					<div class="col-md-4">
						<label for="username" class="form-label">Username</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								name="username" required>
								<div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div>
						</div>
					</div>
					<div class="col-md-6">
						<label for="password" class="form-label">Password</label>
						<input type="text" class="form-control" name="password"
							required>
							<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid Password.</div>
					</div>
					<div class="col-md-3">
						<label for="validationCustom04" class="form-label">Location</label>
						<select class="form-select" name="location" required>
							<option selected disabled value="">Choose...</option>
							<option>Warehouse 1</option>
							<option>Warehouse 2</option>
							<option>Warehouse 3</option>
						</select>
						<div class="invalid-feedback">Please select a valid Location.</div>
					</div>
					<div class="col-md-3">
							<label for="roleSelection" class="form-label">Role</label>
						<select class="form-select" id="roleSelection" required>
							<option selected disabled value="">Choose...</option>
							<option>Supervisor</option>
							<option>Technician</option>
							</select>
							<div class="invalid-feedback">Please select a valid Role.</div>
					</div>
					<!-- <div class="col"> -->
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="invalidCheck" required> <label
								class="form-check-label" for="invalidCheck"> Information is accurate. </label>
							<div class="invalid-feedback">You must agree before submitting.</div>
						</div>
					<!-- </div> -->
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Update User</button>
					</div>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>