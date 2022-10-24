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
					"Inspirational quote about how important maintenance and first time quality are."<br><br>
					
					<a href="tools.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/my7sDDF/toolbox.png"/><br>Tools & Material</a> 
					
					<a href="training.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/1Yg3f8D/graduated.png"/><br>Training</a><br><br>
					
					<a href="equipment.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/C52Q13T/conveyor.png"/><br>Equipment</a> 
					
					<a href="maintenanceDetail.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/t3HK4fq/to-do-list.png"/><br>My To-Do List</a><br><br><br>
					
					<!-- <a href="technicians.do" type="button" class="btn btn-secondary">Technicians</a><br> -->
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>