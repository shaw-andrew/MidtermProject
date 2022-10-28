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
		<div class="container-fluid text-center">
			
				
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
				<!-- 				<th>Safety Section</th> -->
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
									<td>${mrcs.frequency.name}</td>
									<td>${mrcs.equipmentType}</td>
							<%-- 	<!--  -->	<td>${mrcs.safety}</td> --%>
									<td>${mrcs.parts}</td>
									<td>${mrcs.tools}</td>
									<td>
									
									<form action="editMrcPage.do" method="GET">
										<input type="hidden"class="btn btn-secondary" name="id" value="${mrcs.id }" /> 
										<input type="submit" class="btn btn-secondary" value="Edit Maintenance Card" /></form> 

										
										
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				
			<br> <br> <br> <br> <br> <br> <br> <br> 
		
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>