<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ems.model.Employee"%>
<%
    Employee user = (Employee) session.getAttribute("user");
    if (user == null || !"ADMIN".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
</head>
<body>

	<h1>
		Welcome, Admin:
		<%= user.getName() %></h1>

	<hr>

	<h2>Admin Options</h2>
	<ul>
		<li><a href="employee?action=list">View All Employees</a></li>
		<li><a href="employee?action=addForm">Add New Employee</a></li>
		<li><a href="employee?action=searchForm">Search Employee</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>

</body>
</html>
