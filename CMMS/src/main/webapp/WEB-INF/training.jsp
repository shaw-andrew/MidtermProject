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
									<td><a href="${training.videoURL}">View Video</a></td>
									<td>${training.category }</td>
									<td>${training.description}</td>
									<td>${training.mrc.description}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

<br><br><br><br><br><br>
				</div>
		
			
		
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>