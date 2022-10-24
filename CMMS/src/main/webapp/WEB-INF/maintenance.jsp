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
				<div class="col"></div>
				<div class="col-6">
					<br>
					<hr>
					Maintenance Items
					<hr>
					<br>
					Maybe complete button? 
					href to view detail
					
					<a href="scheduleMaintenance.jsp"><button>Schedule Maintenance</button></a>
					
					<table class="table table-striped table-hover">
			<thead class="table-dark">
				<tr>
						<th>ID</th>
						<th>Equipment ID</th>
						<th>Frequency</th>
						<th>Safety Precautions</th>
						<th>Certifications</th>
						<th>Training</th>
						<th>Parts</th>
						<th>Tools</th>
						<th>Tasks</th>
						<th>Description</th>
						<th>Estimated Duration(hrs)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="MainItem" items="${MaintenanceItem}">
					<tr>
						<td>${MainItem.id}</td>
						<td>${MainItem.equipmentType}</td>
						<td>${MainItem.frequency}</td>
						<td>${MainItem.safety}</td>
						<td>${MainItem.certifications}</td>
						<td>${MainItem.trainings}</td>
						<td>${MainItem.parts}</td>
						<td>${MainItem.tools}</td>
						<td>${MainItem.tasks}</td>
						<td>${MainItem.description}</td>
						<td>${MainItem.estimatedDurationInHours}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>