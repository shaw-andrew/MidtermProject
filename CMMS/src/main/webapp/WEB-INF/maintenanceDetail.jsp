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
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<br>
					<hr>
					<h2>@Autowired - Maintenance Item Detail</h2>
					<br>
					<hr>
					<br>
	
		<table class="table table-striped table-hover">
			<thead class="table-dark">
				<tr>
					<th>Equipment ID</th>
					<th>Task Name</th>
					<th>Scheduled Start Date</th>
					<th>Scheduled End Date</th>
					<th>MRC ID</th>
					<th>Staff ID</th>
					<th>Completion Date</th>
					<th>Actual Duration</th>
					<th>Tech Notes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="maintenanceItem" items="${MaintenanceItems}">
					<tr>
						<td>${maintenanceItem.equipmentId}</td>
						<td><a href="getPark.do?pid=${maintenanceItem.id }">${maintenanceItem.name}</a></td>
						<td>${maintenanceItem.scheduledStartDate}</td>
						<td>${maintenanceItem.scheduledEndDate}</td>
						<td>${maintenanceItem.mrcId}</td>
						<td>${maintenanceItem.staffId}</td>
						<td>${maintenanceItem.completionDate}</td>
						<td>${maintenanceItem.actualDuration}</td>
						<td>${maintenanceItem.techNotes}</td>
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