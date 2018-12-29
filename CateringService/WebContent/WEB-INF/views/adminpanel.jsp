<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>DisBook Home Page</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
	</head>
	<body>
	<br><br>
	<center><a href="<%=request.getContextPath() %>/register">Add User</a></center>
	<br><br>
	<center><a href="<%=request.getContextPath() %>/update">Update User</a></center>
	<br><br>
	<center><a href="<%=request.getContextPath() %>/delete">Delete User</a></center>
	<br><br>
	<center><a href="<%=request.getContextPath() %>/changePassword">Change Password</a></center>
	<br><br>
	<center><a href="<%=request.getContextPath() %>/logout">Logout</a></center>
	</body>
</html>