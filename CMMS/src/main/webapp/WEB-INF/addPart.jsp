<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add Part</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Add Part</h1>
				<form class="row g-3 needs-validation" novalidate action=persistPart.do method="POST">
					<div class="col-md-4">
						<label for="description" class="form-label">Part Description</label> <input type="text" class="form-control"
							name="description" required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a description for your part.</div>
					</div>
					<div class="col-md-4">
						<label for="partNumber" class="form-label">Part Number</label> <input type="text" class="form-control"
							name="partNumber"  required>
						<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a part number.</div>
					</div>
					<div class="col-md-4">
						<label for="cost" class="form-label">Cost</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								name="cost" required>
								<div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please input a video URL.</div>
						</div>
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Create Part</button><br>
					</div>
				</form>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>