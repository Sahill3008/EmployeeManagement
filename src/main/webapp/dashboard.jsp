<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard - EMS</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body>

	<nav class="navbar navbar-dark bg-dark px-3">
		<a class="navbar-brand" href="dashboard.jsp">EMS Dashboard</a> <a
			href="logout" class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-4">

		<h2>Welcome, Admin</h2>

		<div class="mt-3">
			<a href="employee?action=list" class="btn btn-primary">Manage
				Employees</a>
		</div>

	</div>

</body>
</html>
