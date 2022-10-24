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
					"Inspirational quote about how important maintenance and first time quality are."<br>
					
					<a href="tools.do" type="button" class="btn btn-secondary"><img src ="https://ibb.co/Wz19xxp"/><br>Tools & Material</a> 
					
					<a href="training.do" type="button" class="btn btn-secondary"><img src ="https://ibb.co/twGSM87"/><br>Training</a><br><br>
					
					<a href="equipment.do" type="button" class="btn btn-secondary"><img src ="https://ibb.co/GvTRx4b"/><br>Equipment</a> 
					
					<a href="maintenanceDetail.do" type="button" class="btn btn-secondary"><img src ="https://ibb.co/Wz19xxp"/><br>My To-Do List</a><br>
					
					<!-- <a href="technicians.do" type="button" class="btn btn-secondary">Technicians</a><br> -->
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>