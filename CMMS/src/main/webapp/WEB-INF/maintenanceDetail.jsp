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
					<h2>@Autowired - My Scheduled Work</h2>
					<br>
					<hr>
					<br>
	
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
					<th>Submit Completed Task</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="maintenanceItem" items="${maintenanceItems}">
					<tr>
						<td>${maintenanceItem.id}</td>
						<td>${maintenanceItem.equipment }</td>
						<td>${maintenanceItem.mrc}</td>
						<td>${maintenanceItem.staff}</td>
						<td>${maintenanceItem.techNotes}
							<input type="text" id="notes" name="notes" maxlength="200">
 						 	<a href="submitNotes.do" type="button" class="btn btn-secondary">Submit Note</a>
 						 	<a href="editNotes.do" type="button" class="btn btn-secondary">Edit Note</a>
 						 </td>
						<td>${maintenanceItem.scheduleStartDate}</td>
						<td>${maintenanceItem.scheduleEndDate}</td>
						<td>${maintenanceItem.actualDurationInHours}</td>
						<td>${maintenanceItem.completionDate}</td>
						<td><a href="complete.do" type="button" class="btn btn-secondary">Complete Task</a></td>
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