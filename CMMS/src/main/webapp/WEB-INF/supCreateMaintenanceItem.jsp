<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Add User</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<%--Edit the file nav.jsp to change nav links --%>
		<div class="container text-center">
			<div class="row">
				<h1>@Autowired - Add Maintenance Item</h1>
				<form class="row g-3 needs-validation" novalidate action=createMaintenance.do method="POST">
					
					
					
					
					
				
						 
						 <label for="completionDate" class="form-label-lg">Completion Date</label>			
						 <input class="form-control form-control-lg" id="completionDate" type="datetime-local" placeholder="Completion Date"  disabled>
						
						 <label for="duration" class="form-label-lg">Duration</label>			
						 <input class="form-control form-control-lg" id="duration" type="number" step = "0.01" placeholder="Duration"  disabled>
						 
						 <label for="techNotes" class="form-label-lg">Technician Notes</label>			
						 <input class="form-control form-control-lg" id="techNotes" type="text" placeholder="Technician Notes}"disabled>
						 
						 <label for="scheduleStartDate" class="form-label-lg">Scheduled Start Date</label>			
					   	 <input type="datetime-local" class="form-control form-control-lg" name="scheduleStartDate" value="Scheduled Start Date " required> <br>
					   	 
						 <label for="mrcId" class="form-label-lg">MRC Id</label>			
						 <input type="number" name="mrcId" value="${mrc.id }" disabled /><br><br>
						 
						 <label for="scheduleEndDate" class="form-label-lg">Scheduled End Date</label>			
					   	 <input type="datetime-local" class="form-control form-control-lg" name="scheduleEndDate" value="Scheduled End Date }" required> <br>
						 
						 
						<div class="dropdown">
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-bs-toggle="dropdown">Select Staff Member</button>
						<ul class="dropdown-menu">
						
							<li><a class="dropdown-item" href="maintenanceDetail.do">View All Staff</a></li>
							
							<c:forEach var="staffMember" items="${staffMembers}">
								<li><a class="dropdown-item" href="viewStaffMember.do?id=${staffMember.id}">${staffMember}</a>
								</li>

							</c:forEach>

						</ul>
					</div>
					</div>
						 
						 
						 
						 
						 
						 <label for="staff" class="form-label-lg">Staff / Needs a Dropdown</label>			
						 <input type="text" name="staff" value="Staff"  /><br><br>
						 
						 <label for="equipment" class="form-label-lg">Equipment / update to string</label>			
						 <input type="text" name="equipment" value="${mrc.equipmentType}"  /><br><br>
						 
					<button class="btn btn-primary" type="submit">Create Maintenance Item</button><br><br>
				</form>
					
					
					
					
					
					<%-- <div class="col-md-4">
						<label for="duration" class="form-label">Duration
							</label> <input type="number" class="form-control"
							name="duration" step = "0.01">
						<!-- <div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please input a last name.</div> -->
					</div>
					<div class="col-md-4">
						<label for="techNotes" class="form-label">Technician Notes</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control"
								name="techNotes" placeholder = "Technician Notes">
								<!-- <div class="valid-feedback">Looks good!</div>
							<div class="invalid-feedback">Please choose a username.</div> -->
						</div>
					</div>
					<div class="col-md-4">
					
						<label for="scheduleStartDate" class="form-label">Start Date</label>
						<input class="form-control" name="scheduleStartDate" type = "datetime-local"
						value = "${maintenanceItem.scheduleEndDate }" maxlength = "10" required>
						
						<label for="scheduleStartDate" class="form-label">Start Date</label>
						<input class="form-control" name="scheduleStartDate" type = "datetime-local"
						value = "${maintenanceItem.scheduleEndDate }" maxlength = "10" required>
					
					</div>
					<div class="col-md-4">
					</div>
					<div class="col-md-4">
					
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" name="password"
							required>
							<div class="valid-feedback">Looks good!</div>
						<div class="invalid-feedback">Please provide a valid Password.</div>
					
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Create New User</button><br>
					</div> --%>
				</form>


			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>