<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg bg-light">
	<style>
</style>

	<div class="container-fluid">
		<a class="navbar-brand" href="#">@Autowired - CMMS</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
			
			<c:choose>
			<c:when test="${loggedInUser.role == 'Supervisor' }">
				<li class="nav-item"><a class="nav-link active" href="supervisor.do">Home</a></li>
				<li class="nav-item"><a class="nav-link active" href="supervisor.do">My Location</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><a class="nav-link active" href="login.do">Home</a></li>
			</c:otherwise>
			</c:choose>		
				<c:choose>
					<c:when test="${not empty loggedInUser }">
						<li class="nav-item"><a class="nav-link active" href="maintenance.do">My To-Do List</a></li>
						<!-- <li class="nav-item"><a class="nav-link active" href="supervisor.do">Tasks</a>

						</li> -->

						<li class="nav-item"><a class="nav-link" href="logout.do">Log
								Out</a></li>
					</c:when>
					<c:otherwise>

						<li class="nav-item"><a class="nav-link" href="login.do">Login</a>
						</li>
					</c:otherwise>

				</c:choose>
			</ul>
		</div>
	</div>
</nav>