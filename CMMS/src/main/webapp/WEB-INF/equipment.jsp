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
				<div class="col-6">
					
					<h2>Equipment and Details</h2>

					<table class="table table-striped table-hover">
			<thead class="table-dark">
				<tr>
						<th>ID</th>
						<th>Type</th>
						<th>Name</th>
						<th>Description</th>
						<th>Location ID</th>
						<th>Task</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Equipment}">
					<tr>
						<td>${Equipment.id}</td>
						<td>${Equipment.equipmentType}</td>
						<td>${Equipment.name}</td>
						<td>${Equipment.description}</td>
						<td>${Equipment.location}</td>
						<td>${Equipment.task}</td>
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