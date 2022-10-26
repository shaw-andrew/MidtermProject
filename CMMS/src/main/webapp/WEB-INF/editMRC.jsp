<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Edit Work</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
		<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
			<!-- <div class="container text-center"> -->
			<br>
				<hr>
				<h2>@Autowired - Edit Maintenance</h2>
				<br>
				<hr>
				<br>
				<form>
					<div class="mb-3">
					  <label for="id" class="form-label">Maintenance Item</label>
 					 <input type="text" class="form-control" id="id" placeholder="${maintenanceItem.id}" disabled readonly>
					</div>
					<div class="mb-3">
					  <label for="mrc" class="form-label">Requirement Card</label>
 					 <input type="text" class="form-control" id="mrc" placeholder="${maintenanceItem.mrc}">
					</div>
					<div class="mb-3">
 					 <label for="equipment" class="form-label">Equipment</label>
 					 <input type="text" class="form-control" id="equipment" placeholder="${maintenanceItem.equipment}">
					</div>
					<div class="mb-3">
 					 <label for="description" class="form-label">Description</label>
 					 <textarea class="form-control" id="description" placeholder="${maintenanceItem.description }" rows="4"></textarea>
					</div>
					<div class="mb-3">
 					 <label for="estimatedDurationInHours" class="form-label">Estimated Work Duration (hrs)</label>
					  <input type="number" class="form-control" id="estimatedDurationInHours" placeholder="${maintenanceItem.estimatedDurationInHours}">
					</div>
					<div class="mb-3">
 					 <label for="safety" class="form-label">Safety</label>
						<select class="form-select" id="safety" multiple aria-label="Associated Safety Requirements">
 					 		<option selected>Associated Safety Requirements</option>
					  		<option value="1">One</option>
  							<option value="2">Two</option>
 					 		<option value="3">Three</option>
						</select>
							</form>
						
						
						<h3>Associated Safety Reqs</h3>
						<c:forEach var="safetyItem" items="${maintenanceRequirementCard.safety}"> 
							<li> ${safetyItem.category}</li>
						</c:forEach>
						<form action="addCardSafety.do">
							<input type="hidden" name="mrcId" value="${maintenanceRequirementCard.id}">
							<select name="safetyId">
							<c:forEach var="safety" items="${safeties}">
							<option value="safety.id"> ${safety.category}</option>
							</c:forEach>
							</select>
							<button type="submit" value="submit">Add Safety</button>
						</form>
						
						
						
						
						
						
						
						
						
				
					<div class="mb-3">
 					 <label for="tools" class="form-label">Tools</label>
 					 	<select class="form-select" id="tools" multiple aria-label="Required Tools">
  							<option selected>Required Tools</option>
  							<option value="1">One</option>
  							<option value="2">Two</option>
  							<option value="3">Three</option>
						</select>
					</div>
					<div class="mb-3">
 					 <label for="parts" class="form-label">Parts</label>
						<select class="form-select" id="parts" multiple aria-label="Required Parts">
  							<option selected>Required Parts</option>
  							<option value="1">One</option>
  							<option value="2">Two</option>
  							<option value="3">Three</option>
						</select>
					</div>
					<div class="mb-3">
					  <label for="certifications" class="form-label">Certifications</label>
							<select class="form-select" id="certificaitons" multiple aria-label="Required Certifications">
  							<option selected>Required Certifications</option>
  							<option value="1">One</option>
  							<option value="2">Two</option>
  							<option value="3">Three</option>
						</select>
					</div>
				<input type="submit" name="submit" value="submit">
		
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>