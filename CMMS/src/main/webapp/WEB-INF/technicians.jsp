<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Log In</title>
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
					<h2>@Autowired - Please Log In To Access Our Site</h2>
					<br>
					<hr>
					<br>

					<form action="login.do" method="POST">
						<%-- Error messages --%>
						<label for="userName" class="form-label">Username</label> 
						<input type="text" id="userName" name="username" required/>
						<label for="password" class="form-label">Password</label> 
						<input type="password" id="password" name="password" required/><br> 
						<input type="submit" class="btn btn-primary" value="Log In">
					</form>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>