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
		<form:form id="adduserForm" method="post" action="updateUser" modelAttribute="DirectoryServiceUser">
			<h1>Update User Form</h1>
			<h2>Directory Service</h2>
			<br>
			<br>
			<div>
				<input type="text" placeholder="Username" required="" id="directoryservice_username" name="username" />
			</div>
			<br>
			<div>
				<input type="text" placeholder="Password" required="" id="directoryservice_password" name="password"/>
			</div>
			<br>
			<div>
				<input type="text" placeholder="Email" required="" id="directoryservice_email" name="email"/>
			</div>
			<br>
<!-- 			<div>
				<input type="text" placeholder="RoleID" required="" id="directoryservice_roleid" name="roleid"/>
			</div>  -->
			<div>
			<select name="roleid">
            <option value="8888">User</option>
            <option value="6666">admin</option>
            </select> 
			</div>
			<br>
			<div>
				<input type="submit" value="UPDATE USER" /> <br><br>
			</div>
		</form:form><!-- form -->
		</center>
    <br><br>
	<center><a href="<%=request.getContextPath() %>/adminBack">BACK</a></center>
	</body>
</html>