<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Employees - EMS</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body>

	<nav class="navbar navbar-dark bg-dark px-3">
		<a class="navbar-brand" href="dashboard.jsp">EMS</a> <a href="logout"
			class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-4">

		<h2>Employee List</h2>
		<p>
			Showing <b>${employees.size()}</b> result(s)
		</p>

		<a class="btn btn-primary mb-3" href="employee?action=edit">Add
			Employee</a>

		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Salary</th>
					<th>Dept</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${employees}" var="e">
					<tr>
						<td>${e.id}</td>
						<td>${e.name}</td>
						<td>${e.email}</td>
						<td>${e.salary}</td>
						<td>${e.department}</td>
						<td><a href="employee?action=edit&id=${e.id}"
							class="btn btn-sm btn-warning">Edit</a> <a
							href="employee?action=delete&id=${e.id}"
							onclick="return confirm('Delete employee?')"
							class="btn btn-sm btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>
