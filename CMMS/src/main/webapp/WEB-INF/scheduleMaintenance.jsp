<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Schedule Item</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<br>
					<hr>
					<h2>Schedule Item</h2>
					<hr>
					<br>

					<c:if test="${loggedInUser.role == 'Supervisor' }">
						<a class="btn btn-secondary" href="scheduleMaintenance.do"
							role="button">Schedule Maintenance</a>
					</c:if><br>

					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th>MRC</th>
								<th>Equipment</th>
								<th>Scheduled Start Date</th>
								<th>Max Compliance Date</th>
								<th>Staff</th>
								<th>Estimated Duration</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							
								<tr>
									<td>${MaintenanceItem.id}</td>
									<td>${MaintenanceItem.mrc}</td>
									<td>${MaintenanceItem.equipment}</td>
									<td><input type="datetime-local" 
										name="scheduleStartDate" form="updateItem${maintenanceItem.id}"
										value="${maintenanceItem.scheduleStartDate }" maxlength="10"></td>
									<td><input type="datetime-local" 
										name="scheduleEndDate" form="updateItem${maintenanceItem.id}"
										value="${maintenanceItem.scheduleEndDate }" maxlength="10"></td>
									<td><select class="form-select" name="role" required>
										<option selected disabled value="">Assign Staff</option>
											<option>${MaintenanceItem.staff}</option>
											<option>Technician</option>
										</select></td>
									<td>${MaintenanceItem.estimatedDurationInHours}</td>
									<td><c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="scheduleMRC.do" 
												role="button">Schedule Item</a><!-- Update me -->
										</c:if>
									</td>
								</tr>
						
						</tbody>
					</table>

				</div>
				<div class="col-2"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>