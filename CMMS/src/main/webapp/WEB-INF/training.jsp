<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Training</title>
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
					<br>
					<h2>@Autowired - Training</h2>
					<br>
					<hr>
					<br>
					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>Training ID</th>
								<th>Video URL</th>
								<th>Category</th>
								<th>Description</th>
								<th>Related MRC ID</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="training" items="${training}">
								<tr>
									<td>${training.id}</td>
									<td>${training.videoURL}</td>
									<td>${training.category }</td>
									<td>${training.description}</td>
									<td>${training.mrc}</td>
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