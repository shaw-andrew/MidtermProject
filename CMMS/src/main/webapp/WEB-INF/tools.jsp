<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Tools</title>
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
					<br>
					<h2>@Autowired - Required Tool(s) for the job</h2>
					<br>
					<hr>
					<br>
				
					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>Tool ID</th>
								<th>Tool Name</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tool" items="${tools}">
								<tr>
									<td>${tool.id}</td>
									<td>${tool.name}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<hr>
					<br>
					<h2>@Autowired - Required Part(s) for the job</h2>
					<br>
					<hr>
					<br>

					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>Part ID</th>
								<th>Description</th>
								<th>Cost</th>
								<th>Part Number</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="part" items="${parts}">
								<tr>
									<td>${part.id}</td>
									<td>${part.description}</td>
									<td>${part.cost}</td>
									<td>${part.partNumber }</td>
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