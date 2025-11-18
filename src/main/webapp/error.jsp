<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body>
	<div class="container mt-5">
		<div class="alert alert-danger">
			<h3>Error Occurred</h3>
			<p>${exception}</p>
		</div>
	</div>
</body>
</html>
