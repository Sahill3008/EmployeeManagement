<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Search Employees</title>
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="p-4">

<h2>Search Employees</h2>
<form action="employee" method="get">
    <input type="hidden" name="action" value="search"/>

    <div class="mb-3">
        <label>Enter name/email/department/username:</label>
        <input type="text" name="keyword" class="form-control" required>
    </div>

    <button class="btn btn-primary">Search</button>
</form>

<br>
<a href="dashboard-admin.jsp">Back to Dashboard</a>

</body>
</html>
