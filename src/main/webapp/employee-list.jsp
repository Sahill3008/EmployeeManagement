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
    <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard-admin.jsp">EMS</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Logout</a>
</nav>

<div class="container mt-4">

    <h2>Employee List</h2>
    <p>Showing <b>${employees.size()}</b> result(s)</p>

    <!-- Correct Add Employee Link -->
    <a class="btn btn-primary mb-3"
       href="${pageContext.request.contextPath}/employee?action=addForm">
        Add Employee
    </a>

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
                <td>
                    <!-- Correct Edit Link -->
                    <a href="${pageContext.request.contextPath}/employee?action=editForm&id=${e.id}"
                       class="btn btn-sm btn-warning">
                        Edit
                    </a>

                    <!-- Delete Link -->
                    <a href="${pageContext.request.contextPath}/employee?action=delete&id=${e.id}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Delete employee?')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Correct Dashboard Link -->
    <a href="${pageContext.request.contextPath}/dashboard-admin.jsp">
        Back to Dashboard
    </a>

</div>

</body>
</html>
