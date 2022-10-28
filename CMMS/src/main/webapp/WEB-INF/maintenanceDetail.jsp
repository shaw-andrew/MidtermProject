<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Maintenance Item Detail</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
	<br><br>
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				
					<br>
					<hr>
					<h2>@Autowired - My Scheduled Work</h2>
					<br>
					<hr>
					<br>

					<div class="dropdown">
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-bs-toggle="dropdown">Select Staff Member</button>
						<ul class="dropdown-menu">
						
							<li><a class="dropdown-item" href="maintenanceDetail.do">View All Staff</a></li>
							
							<c:forEach var="staffMember" items="${staffMembers}">
								<li><a class="dropdown-item" href="viewStaffMember.do?id=${staffMember.id}">${staffMember}</a>
								</li>

							</c:forEach>

						</ul>
					</div>
<br><br>
					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th>Equipment</th>
								<th>MRC</th>
								<th>Staff</th>
								<th>Technician Note</th>
								<th>Scheduled Start Date</th>
								<th>Scheduled End Date</th>
								<th>Actual Duration (hrs)</th>
								<th>Completion Date</th>
								<th>Edit</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="maintenanceItem" items="${maintenanceItems}">

								<tr>

									<td>${maintenanceItem.id}</td>
									<td>${maintenanceItem.equipment}</td>
									<td>${maintenanceItem.mrc}</td>
									<td>${maintenanceItem.staff}</td>

									<td><input type="text"
										form="updateItem${maintenanceItem.id}" name="techNotes"
										value="${maintenanceItem.techNotes}" maxlength="200"></td>

									<td>${maintenanceItem.scheduleStartDate}</td>
									<td>${maintenanceItem.scheduleEndDate}</td>

									<td><input type="text" name="actualDurationInHours"
										form="updateItem${maintenanceItem.id}"
										value="${maintenanceItem.actualDurationInHours}"
										maxlength="10"></td>


									<td><input type="datetime-local" name="completionDate"
										form="updateItem${maintenanceItem.id}"
										value="${maintenanceItem.completionDate }" maxlength="10">
									</td>
									<td>
										<form action="update.do" id="updateItem${maintenanceItem.id}"
											method="POST">
											<input type="hidden" name="mainItemId"
												value="${maintenanceItem.id}"> <input type="submit"
												name="submit" value="submit">
										</form>
									</td>



								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				
		</div>
		<br><br><br><br><br><br><br><br><br><br><br><br>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>