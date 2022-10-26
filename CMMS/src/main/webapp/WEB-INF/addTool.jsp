<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add Tool</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Add Tool</h1>
				<form class="row g-3 needs-validation" novalidate action=persistTool.do method="POST">
					<div class="col-md-4">
						<label for="name" class="form-label">Tool Name</label> <input type="text" class="form-control"
							name="name" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a name for your new tool.</div>
					</div>
					<div class="col-md-4">
						<label for="MRC" class="form-label">What MRCs is this tool associated with?</label> <input type="text" class="form-control"
							name="MRC"  required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please describe your equipment.</div>
					</div>
					
	
					<div class="col-12">  
						<button class="btn btn-primary" type="submit">Create Tool</button><br>
					</div>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>