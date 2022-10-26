<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Equipment Details</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<div class="col"></div>
				
				

					<h2>Equipment and Details</h2>

					<table class="table table-striped table-hover table-responsive w-auto">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th class="col-2">Type</th>
								<th class="col-2">Name</th>
								<th class="col-2">Description</th>
								<th class="col-2">Location ID</th>
								<th class="col-4">Task</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="equipment" items="${equipment}">
								<tr>
									<td>${equipment.id}</td>
									<td>${equipment.equipmentType}</td>
									<td>${equipment.name}</td>
									<td>${equipment.description}</td>
									<td>${equipment.location}</td>
									<td>${equipment.task}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>



				
				
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>