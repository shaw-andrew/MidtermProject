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
 					 <input type="text" class="form-control" id="id" placeholder="${mrc.id}" disabled readonly>
					</div>
					<div class="mb-3">
					  <label for="frequency" class="form-label">Periodicity</label>
 					 <input type="text" class="form-control" id="frequency" placeholder="${mrc.frequency}">
					</div>
					<div class="mb-3">
 					 <label for="equipment" class="form-label">Equipment</label>
 					 <input type="text" class="form-control" id="equipment" placeholder="${mrc.equipmentType.equipment}">
					</div>
					<div class="mb-3">
 					 <label for="description" class="form-label">Description</label>
 					 <textarea class="form-control" id="description" placeholder="${id.description}" rows="4"></textarea>
					</div>
					<div class="mb-3">
 					 <label for="estimatedDurationInHours" class="form-label">Estimated Work Duration (hrs)</label>
					  <input type="number" class="form-control" id="estimatedDurationInHours" placeholder="${mrc.estimatedDurationInHours}">
					</div>
<!-- 					<div class="mb-3">
 					 <label for="tool" class="form-label">Tool</label>
						<select class="form-select" id="tool" multiple aria-label="Associated Tools">
 					 		<option selected>Associated Tools</option>
					  		<option value="1">One</option>
  							<option value="2">Two</option>
 					 		<option value="3">Three</option>
						</select> -->
							</form>
						
						
						<h3>Associated Tool Reqs</h3>
						<c:forEach var="tool" items="${mrc.tools}"> 
							<li> ${tools.name}</li>
						</c:forEach>
						<form action="addCardTool.do">
							<input type="hidden" name="mrcId" value="${mrc.id}">
							<select name="toolId">
							<c:forEach var="tool" items="${tools}">
							<option value="tool.id"> ${tool.name}</option>
							</c:forEach>
							</select>
							<button type="submit" value="submit">Add Tool</button>
						</form>
						
						<h3>Associated Part Reqs</h3>
						<c:forEach var="part" items="${mrc.parts}"> 
							<li> ${parts.partNumber}</li>
						</c:forEach>
						<form action="addCardPart.do">
							<input type="hidden" name="mrcId" value="${mrc.id}">
							<select name="partId">
							<c:forEach var="part" items="${parts}">
							<option value="part.id"> ${part.partNumber}</option>
							</c:forEach>
							</select>
							<button type="submit" value="submit">Add Part</button>
						</form>
						
						
						
						
						
						
						
						
						
				
					<!-- <div class="mb-3">
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
		 -->
				<input type="submit" name="submit" value="submit">
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>