<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
<jsp:include page="bootstrapHead.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<main class="container-fluid">
<%--Edit the file nav.jsp to change nav links --%>

<h2>Log In</h2>

<form action="login.do" method="POST">
    <%-- Error messages --%>
    <input type="text" name="username">
    <input type="password" name="password"/>
    <input type="submit" value="Log In" > 
</form>
</main>
<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>