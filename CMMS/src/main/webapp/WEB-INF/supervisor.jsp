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
		<div class="container-fluid, text-center">
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
					<br>
					
					
				</div>
				<div class="col"></div>
			</div>
			<div class="row">
					<div class="col-md-4"><a href="supTools.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/my7sDDF/toolbox.png"/><br>Tools & Material</a> </div>
					
					<div class="col-md-4"><a href="supMaintenance.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/t3HK4fq/to-do-list.png"/><br>View Maintenance</a></div>
					
					<div class="col-md-4"><a href="supTraining.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/1Yg3f8D/graduated.png"/><br>Training</a> </div>
				
				</div>
				<br><br>
				<div class="row">
					
					<div class="col-md-4"><a href="supEquipment.do" type="button" class="btn btn-secondary"><img src ="https://i.ibb.co/C52Q13T/conveyor.png"/><br>Equipment</a></div>
					
					<div class="col-md-4"><a href="supMaintenanceDetail.do" type="button" class="btn btn-secondary"><img src="https://i.ibb.co/QKXgJjR/investigation-1.png"/><br>Maintenance</a> </div>
					
					<div class="col-md-4"><a href="supTechnicians.do" type="button" class="btn btn-secondary"><img src="https://i.ibb.co/NZSV8xd/support.png"/><br>Technicians</a></div>
				</div>	<br><br>
					<a href="account.do" type="button" class="btn btn-secondary"><img src="https://i.ibb.co/jrbHKtC/account.png"/><br>Account</a><br><br><br>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>