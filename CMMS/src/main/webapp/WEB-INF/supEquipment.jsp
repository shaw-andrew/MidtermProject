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

					<c:if test="${loggedInUser.role == 'Supervisor' }">
						<a class="btn btn-secondary" href="addEquipment.do" role="button">Add
							Equipment</a>
					</c:if>
					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th class="col-lg-2">Type</th>
								<th class="col-lg-1">Name</th>
								<th class="col-lg-2">Description</th>
								<th class="col-lg-3">Location ID</th>
								<th class="col-lg-4">Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="equipment" items="${equipment}">
								<tr>
									<td>${equipment.id}</td>
									<td>${equipment.equipmentType.name}</td>
									<td>${equipment.name}</td>
									<td>${equipment.description}</td>
									<td>${equipment.location}</td>
									<td>${equipment.imageURL}</td>
									<td><c:if test="${loggedInUser.role == 'Supervisor' }">
										<input type="hidden" name="equipmentId" value="${equipment.id }" />
											<a class="btn btn-secondary" href="deleteEquipment.do"
												role="button">Delete Equipment</a>
									
										</c:if><br> <c:if test="${loggedInUser.role == 'Supervisor' }">
											<a class="btn btn-secondary" href="updateEquipment.do"
												role="button">Edit Equipment</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>



				</div>
				<div class="col"></div>
			</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>