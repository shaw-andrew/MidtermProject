<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Autowired - Account</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="navbar.jsp" />
<main class="container-fluid">
<h2>@Autowired - Your Details</h2>

<%-- Output user details --%>
<c:choose>
<c:when test="${not empty sessionScope.loggedInUser}"> 
<h1>Your Details</h1>
<div class="col-md-4"><h4>First Name: <c:out value="${loggedInUser.firstName}"/></h4></div>
<div class="col-md-4"><h4>Last Name: <c:out value="${loggedInUser.lastName}"/></h4></div>
<div class="col-md-4"><h4>Username: <c:out value="${loggedInUser.userName}"/></h4></div>
<div class="col-md-8"><h4>Password:</h4><form><input type="password" class="form-control" id="validationCustom01" value="${loggedInUser.password }" required></form></div>
<div class="col-md-4"><h4>Role: <c:out value="${loggedInUser.role}"/></h4></div>
<button class="btn btn-primary" type="submit">Update Password</button>
<hr>
<br>
<h1>Create/Update User</h1>
<form class="row g-3 needs-validation" novalidate>
  <div class="col-md-4">
    <label for="validationCustom01" class="form-label">First name</label>
    <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  <div class="col-md-4">
    <label for="validationCustom02" class="form-label">Last name</label>
    <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  <div class="col-md-4">
    <label for="validationCustomUsername" class="form-label">Username</label>
    <div class="input-group has-validation">
      <span class="input-group-text" id="inputGroupPrepend">@</span>
      <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
      <div class="invalid-feedback">
        Please choose a username.
      </div>
    </div>
  </div>
  <div class="col-md-6">
    <label for="validationCustom03" class="form-label">Password</label>
    <input type="text" class="form-control" id="validationCustom03" required>
    <div class="invalid-feedback">
      Please provide a valid city.
    </div>
  </div>
  <div class="col-md-3">
    <label for="validationCustom04" class="form-label">Location</label>
    <select class="form-select" id="validationCustom04" required>
      <option selected disabled value="">Choose...</option>
      <option>...</option>
    </select>
    <div class="invalid-feedback">
      Please select a valid state.
    </div>
  </div>
  <div class="col-md-3">
    <label for="validationCustom05" class="form-label">Role</label>
    <input type="text" class="form-control" id="validationCustom05" required>
    <div class="invalid-feedback">
      Please provide a valid zip.
    </div>
  </div>
  <div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
      <label class="form-check-label" for="invalidCheck">
        Agree to terms and conditions
      </label>
      <div class="invalid-feedback">
        You must agree before submitting.
      </div>
    </div>
  </div>
  <div class="col-12">
    <button class="btn btn-primary" type="submit">Submit form</button>
  </div>
</form>

</c:when>
<c:otherwise>
<h2>User not logged in.</h2>
</c:otherwise>
</c:choose>
</main>
<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>