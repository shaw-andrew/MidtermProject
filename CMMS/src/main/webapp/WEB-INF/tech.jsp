<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - All Staff Table</title>
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
					<h2>@Autowired - Technician table</h2>
					<br>
					<hr>
					<br>
					All data about all technicians. Maybe their name can be an href to upcoming jobs?
					
					<a href="tools.do" type="button" class="btn btn-secondary">Tools & Material</a><br>
					
					<a href="training.do" type="button" class="btn btn-secondary">Training</a><br>
					
					<a href="equipment.do" type="button" class="btn btn-secondary">Equipment</a><br>
					
					<a href="maintenanceDetail.do" type="button" class="btn btn-secondary">Maintenance Detail</a><br>
					
					<a href="technicians.do" type="button" class="btn btn-secondary">Technicians</a><br>
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>