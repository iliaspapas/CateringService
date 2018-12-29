<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Directory Service</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
	</head>
	<body>
	<center>
		<form:form id="changepassForm" method="post" action="passwordChange" modelAttribute="UserCredentials">
			<h1>Change User Password Form</h1>
			<h2>Directory Service</h2>
			<br>
			<br>
			<div>
				<input type="text" placeholder="New Password" required="" id="directoryservice_newpassword" name="username" />
			</div>
			<br>
			<div>
				<input type="text" placeholder="Repeat New Password" required="" id="directoryservice_repeatpassword" name="password"/>
			</div>
			<br>
			<div>
				<input type="submit" value="Update Password" /> <br><br>
			</div>
		</form:form><!-- form -->
		</center>
    <br><br>
	<center><a href="<%=request.getContextPath() %>/changePassBack">BACK</a></center>
	</body>
</html>