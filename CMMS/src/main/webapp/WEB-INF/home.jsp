<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="bootstrapHead.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Home</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<div class="container text-center">
			<div class="row">
				<div class="col"></div>
				<div class="col-6">
					<h2>Welcome to the site</h2>
					<hr>
					<blockquote>
						<strong>Our company is the best!</strong>Lorem ipsum dolor sit
						amet, consectetur adipiscing elit, sed do eiusmod tempor
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
						voluptate velit esse cillum dolore eu fugiat nulla p ariatur.
						Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
						officia deserunt mollit anim id est laborum.
					</blockquote>
					<br>
					<hr>
					<br> <br>
					
					<form action="login.do" method="POST">
						<%-- Error messages --%>
						<label for="userName" class="form-label">Username</label> 
						<input type="text" id="userName" name="username" required/>
						<label for="password" class="form-label">Password</label> 
						<input type="password" id="password" name="password" required/><br> 
						<input type="submit" class="btn btn-primary" value="Log In">
					</form>
					
					 <br><br>
					<div id="carouselExampleCaptions" class="carousel slide"
						data-bs-ride="false">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img
									src="https://southernfield.com/wp-content/uploads/2021/01/AdobeStock_411430356-scaled.jpeg"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>First User Testimonial</h5>
									<p>Something really nice about how good @Autowired is and
										how it saved their company</p>
								</div>
							</div>
							<div class="carousel-item">
								<img
									src="https://blog.infraspeak.com/wp-content/uploads/2021/01/maintenance-trends.jpeg"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>Even better testimonial</h5>
									<p>@Autowired was professional and thier program has
										increased out productivity and output by 37% this year.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img
									src="https://www.foodengineeringmag.com/ext/resources/Issues/2019/07-July/Maint1-07-19-EH-SMT70.jpg"
									class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>Third testimonial is a kicker. This is totally from a
										CEO that has a PhD</h5>
									<p>
										<strong>ABSOLUTE BEST</strong> CMMS program our company has
										ever used.
									</p>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
						<br><br><br><br>
					</div>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</main>
	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>