<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Maintenance Item</title>
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
					<h2>Maintenance Items</h2>
					<hr>
					<br> Maybe complete button? href to view detail

					<c:if test="${loggedInUser.role == 'Supervisor' }">
						<a class="btn btn-secondary" href="supMaintenanceDetail.do"
							role="button">Schedule Maintenance</a>
					</c:if><br>

					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th>Completion Date</th>
								<th>Duration</th>
								<th>Technician Notes</th>
								<th>Scheduled Start Date</th>
								<th>MRC</th>
								<th>Scheduled End Date</th>
								<th>Staff</th>
								<th>Equipment</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="maintenanceItem" items="${MaintenanceItems}">
								<tr>
									<td>${maintenanceItem.id}</td>
									<td>${maintenanceItem.completionDate}</td>
									<td>${maintenanceItem.actualDurationInHours}</td>
									<td>${maintenanceItem.techNotes}</td>
									<td>
										<input type="datetime-local" 
											name="scheduleStartDate" form="updateItem${maintenanceItem.id}"
											value="${maintenanceItem.scheduleStartDate }" maxlength="10">${maintenanceItem.scheduleStartDate}
									</td>
									<td>${maintenanceItem.mrc}</td>
									<td>
										<input type="datetime-local" 
												name="scheduleEndDate" form="updateItem${maintenanceItem.id}"
												value="${maintenanceItem.scheduleEndDate }" maxlength="10">
									</td>
									<td>${maintenanceItem.staff}</td>
									<td>${maintenanceItem.equipment}</td>
									<td><c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="deleteMRC.do"
												role="button">Delete Maintenance Item</a>
										</c:if><br> <c:if test="${loggedInUser.role == 'Supervisor' }">
											<form action="supUpdateTask.do" id="updateItem${maintenanceItem.id}"
											method="POST" > 
											<input type="hidden" name="mainItemId" value="${maintenanceItem.id}">
											<input type="submit" name="submit" value="submit">
										</form>
										</c:if>
									</td>
								</tr>
							</c:forEach>
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