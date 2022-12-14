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

		<h2>@Autowired - Edit Maintenance</h2>
		<br>
		<hr>
		<br>
		<form action="updateMrc.do" method="POST">
			<input type="hidden" name="mrcId" value="${mrcs.id}">

			<div class="mb-3">
				<label for="id" class="form-label">Maintenance Item</label> <input
					type="text" class="form-control" id="id" value="${mrcs.id}"
					disabled readonly>
			</div>
			<div class="mb-3">
				<label for="frequency" class="form-label">Periodicity</label> <select
					name="frequency.id" class="form-select">
					<c:forEach var="frequency" items="${frequencies}">
						<c:choose>
							<c:when test="${mrcs.frequency.id == frequency.id }">
								<option selected value="${frequency.id}">${frequency.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${frequency.id}">${frequency.name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<label for="equipment" class="form-label">Equipment</label> <select
					name="equipmentType.id" class="form-select">
					<c:forEach var="equipment" items="${equipmentTypes}">
						<c:choose>
							<c:when test="${mrcs.equipmentType.id == equipment.id }">
								<option selected value="${equipment.id}">${equipment.equipment}</option>
							</c:when>
							<c:otherwise>
								<option value="${equipment.id}">${equipment.equipment}</option>
							</c:otherwise>
							</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea class="form-control" name="description" rows="4">${mrcs.description}</textarea>
			</div>
			<div class="mb-3">
				<label for="estimatedDurationInHours" class="form-label">Estimated
					Work Duration (hrs)</label> <input type="number" class="form-control"
					name="estimatedDurationInHours"
					value="${mrcs.estimatedDurationInHours}">

				<button type="submit" class="btn btn-secondary" value="submit">Update
					Requirements</button>
			</div>

		</form>

		<h3>Associated Tools Required</h3>
		
		<c:forEach var="tool" items="${mrcs.tools}">
			<li>${tool.name}</li>
		</c:forEach>
		<form action="addCardTool.do" method="POST">
			<input type="hidden" name="mrcId" value="${mrcs.id}"> <select
				name="toolId" class="form-select">
				<c:forEach var="tool" items="${tools}">
					<option value="${tool.id}">${tool.name}</option>
				</c:forEach>
			</select> <input type="hidden" name="id" value="${mrcs.id}">
			<button type="submit" class="btn btn-secondary" value="submit">Add
				Tool</button>
		</form>
		
		
		<h3>Associated Parts Required</h3>
		<c:forEach var="part" items="${mrcs.parts}">
			<li>${part.name}</li>
		</c:forEach>
		<form action="addCardPart.do" method="POST">
			<input type="hidden" name="mrcId" value="${mrcs.id}"> <select
				name="partId" class="form-select">
				<c:forEach var="part" items="${parts}">
					<option value="${part.id}">${part.name}</option>
				</c:forEach>
			</select> <input type="hidden" name="id" value="${mrcs.id}">
			<button type="submit" class="btn btn-secondary" value="submit">Add
				Part</button>
		</form>

		<%-- 		<h3>Associated Training Required</h3>
		<c:forEach var="training" items="${mrcs.trainings}">
			<li>${training.category}</li>
		</c:forEach>
		<form action="addCardTraining.do" method="POST">
			<input type="hidden" name="mrcId" value="${mrcs.id}"> 
			<select name="trainingId" class="form-select">
				<c:forEach var="training" items="${trainings}">
					<option value="${training.id}">${training.category}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-secondary" value="submit">Add Training</button>
		</form> --%>
		<br> <br> <br> <br> <br> <br> <br>
		<br>

	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>