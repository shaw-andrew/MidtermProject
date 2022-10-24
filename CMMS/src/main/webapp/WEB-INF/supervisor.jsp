<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Supervisor Landing Page</title>
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
					<h2>@Autowired - Supervisor Landing Page</h2>
					<br>
					<hr>
					<br>
					
					<a href="supTools.do" type="button" class="btn btn-secondary">Tools & Material</a><br>
					
					<a href="supMaintenance.do" type="button" class="btn btn-secondary">View Maintenance</a><br>
					
					<a href="supTraining.do" type="button" class="btn btn-secondary">Training</a><br>
					
					<a href="supEquipment.do" type="button" class="btn btn-secondary">Equipment</a><br>
					
					<a href="supMaintenanceDetail.do" type="button" class="btn btn-secondary">Maintenance Detail</a><br>
					
					<a href="supTechnicians.do" type="button" class="btn btn-secondary">Technicians</a><br>
					
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>