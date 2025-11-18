<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.ems.model.Employee"%>

<%
Employee user = (Employee) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<title>My Profile</title>
</head>

<body>

	<h2>My Profile</h2>

	<p>
		<b>Name:</b>
		<%=user.getName()%></p>
	<p>
		<b>Email:</b>
		<%=user.getEmail()%></p>
	<p>
		<b>Department:</b>
		<%=user.getDepartment()%></p>
	<p>
		<b>Username:</b>
		<%=user.getUsername()%></p>
	<p>
		<b>Role:</b>
		<%=user.getRole()%></p>

	<a href="logout">Logout</a>
	<a href="profile?action=edit">Edit Profile</a>


</body>
</html>
