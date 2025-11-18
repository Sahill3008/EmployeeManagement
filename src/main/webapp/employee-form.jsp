<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Employee Form - EMS</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body>

	<nav class="navbar navbar-dark bg-dark px-3">
		<a class="navbar-brand" href="dashboard.jsp">EMS</a> <a href="logout"
			class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-4">

		<h2>${employee == null ? "Add Employee" : "Edit Employee"}</h2>

		<form action="employee" method="post" class="mt-4">

			<c:if test="${employee != null}">
				<input type="hidden" name="id" value="${employee.id}">
			</c:if>

			<div class="mb-3">
				<label>Name</label> <input name="name" class="form-control"
					value="${employee.name}" required>
			</div>

			<div class="mb-3">
				<label>Email</label> <input name="email" class="form-control"
					value="${employee.email}" required>
			</div>

			<div class="mb-3">
				<label>Salary</label> <input name="salary" class="form-control"
					value="${employee.salary}" required>
			</div>

			<div class="mb-3">
				<label>Department</label> <input name="department"
					class="form-control" value="${employee.department}" required>
			</div>

			<button class="btn btn-success w-100">Save</button>

		</form>
		<a href="dashboard-admin.jsp">Back to Dashboard</a>
	</div>

</body>
</html>
