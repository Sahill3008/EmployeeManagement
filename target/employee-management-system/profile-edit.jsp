<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.ems.model.Employee"%>

<%
    Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Profile</title>
</head>

<body>

	<h2>Edit My Profile</h2>

	<form action="profile" method="post">

		<label>Name:</label> <input type="text" name="name"
			value="<%= emp.getName() %>" required><br>
		<br> <label>Email:</label> <input type="email" name="email"
			value="<%= emp.getEmail() %>" required><br>
		<br> <label>Department:</label> <input type="text"
			name="department" value="<%= emp.getDepartment() %>"><br>
		<br> <label>Username:</label> <input type="text" name="username"
			value="<%= emp.getUsername() %>" required><br>
		<br> <label>New Password:</label> <input type="password"
			name="password"><br> <small>(Leave empty to keep
			previous password)</small><br>
		<br>

		<button type="submit">Save Changes</button>
	</form>

	<br>
	<a href="profile.jsp">Cancel</a>

</body>
</html>
