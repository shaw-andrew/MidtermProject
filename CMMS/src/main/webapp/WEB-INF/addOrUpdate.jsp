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
				<form class="row g-3 needs-validation" novalidate>
					<div class="col-md-4">
						<label for="validationCustom01" class="form-label">First
							name</label> <input type="text" class="form-control"
							id="validationCustom01" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a first name.</div>
					</div>
					<div class="col-md-4">
						<label for="validationCustom02" class="form-label">Last
							name</label> <input type="text" class="form-control"
							id="validationCustom02"  required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a last name.</div>
					</div>
					<div class="col-md-4">
						<label for="validationCustomUsername" class="form-label">Username</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								id="validationCustomUsername" required>
								<div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div>
						</div>
					</div>
					<div class="col-md-6">
						<label for="validationCustom03" class="form-label">Password</label>
						<input type="text" class="form-control" id="validationCustom03"
							required>
							<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid Password.</div>
					</div>
					<div class="col-md-3">
						<label for="validationCustom04" class="form-label">Location</label>
						<select class="form-select" id="validationCustom04" required>
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
							<div class="invalid-feedback">You must agree before
								submitting.</div>
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