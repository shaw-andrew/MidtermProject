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
								<th>MRC ID</th>
								<th>Description</th>
								<th>Technicians Required</th>
								<th>Associated Training</th>
								<th>Est. Duration</th>
								<th>Periodicity</th>
								<th>Equipment</th>
								<th>Required Certifications</th>
								<th>Safety Section</th>
								<th>Replacement Parts</th>
								<th>Required Tools</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mrcs" items="${mrcs}">
								<tr>
									<td>${mrcs.id}</td>
									<td>${mrcs.description}</td>
									<td>${mrcs.numberOfTechs}</td>
									<td>${mrcs.trainings}</td>
									<td>${mrcs.estimatedDurationInHours}</td>
									<td>${mrcs.frequency}</td>
									<td>${mrcs.equipmentType}</td>
									<td>${mrcs.safety}</td>
									<td>${mrcs.parts}</td>
									<td>${mrcs.tools}</td>
									<td><c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="deleteMRC.do"
												role="button">Delete Maintenance Card</a>
										</c:if><br> <c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="editMrcPage.do?id=${mrcs.id}"
												role="button">Edit Maintenance Card</a>
												
										<form action="editMrcPage.do" method="GET">
										<input type="hidden" name="id" value="${mrcs.id }" /> 
										<input type="submit" value="Edit Maintenance Card form button" /></form>
										
										</c:if><br> <c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="createMaintenance.do?id=${mrcs.id}"
												role="button">Create Maintenance Item</a>
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