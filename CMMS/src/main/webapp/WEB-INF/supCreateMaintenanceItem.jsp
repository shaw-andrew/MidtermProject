<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Add Maintenance Item</h1>
				<form class="row g-3 needs-validation" novalidate action=createMaintenance.do method="POST">
					<div class="col-md-4">
						<label for="completionDate" class="form-label">Completion Date
							</label> <input type="datetime-local" class="form-control"
							name="completionDate" placeholder = "Completion Date">
						<!-- <div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a first name.</div> -->
					</div>
					<div class="col-md-4">
						<label for="duration" class="form-label">Duration
							</label> <input type="number" class="form-control"
							name="duration" step = "0.01">
						<!-- <div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a last name.</div> -->
					</div>
					<div class="col-md-4">
						<label for="techNotes" class="form-label">Technician Notes</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								name="techNotes" placeholder = "Technician Notes">
								<!-- <div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div> -->
						</div>
					</div>
					<div class="col-md-4">
					
						<label for="scheduleStartDate" class="form-label">Start Date</label>
						<input class="form-control" name="scheduleStartDate" type = "datetime-local"
						value = "${maintenanceItem.scheduleEndDate }" maxlength = "10" required>
						
						<label for="scheduleStartDate" class="form-label">Start Date</label>
						<input class="form-control" name="scheduleStartDate" type = "datetime-local"
						value = "${maintenanceItem.scheduleEndDate }" maxlength = "10" required>
					
					</div>
					<div class="col-md-4">
					</div>
					<div class="col-md-4">
					
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" name="password"
							required>
							<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid Password.</div>
					
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Create New User</button><br>
					</div>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>