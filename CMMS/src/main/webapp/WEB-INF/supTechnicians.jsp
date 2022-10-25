<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Technician Landing Page</title>
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
					<h2>@Autowired - Technician landing page</h2>
					<br>
					<hr>
					<br>
					My To-Do list
					Manager Priorities
					Missed work
					Upcoming schedule
					Training
					
					
					
					<a href="addUser.jsp"><button>Add New Staff Member</button></a>
					<table class="table table-striped table-hover">
						<thead class="table-dark">
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="staff" items="${staff}">
								<tr>
									<td>${staff.id}</td>
									<td><a href="getPark.do?pid=${staff.firstName }">${staff.firstName}</a></td>
									<td>${staff.lastName}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					
					
					
					
					${staff }
					
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>