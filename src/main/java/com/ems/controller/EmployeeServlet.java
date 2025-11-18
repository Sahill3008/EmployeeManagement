package com.ems.controller;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		switch (action) {

		case "addForm":
			request.getRequestDispatcher("employee-form.jsp").forward(request, response);
			break;

		case "editForm":
			int id = Integer.parseInt(request.getParameter("id"));
			Employee emp = service.get(id);
			request.setAttribute("employee", emp);
			request.getRequestDispatcher("employee-form.jsp").forward(request, response);
			break;

		case "delete":
			service.delete(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("employee?action=list");
			break;

		case "searchForm":
			request.getRequestDispatcher("employee-search.jsp").forward(request, response);
			break;

		case "search":
			String keyword = request.getParameter("keyword");
			List<Employee> results = service.searchEmployees(keyword);
			request.setAttribute("employees", results);
			request.getRequestDispatcher("employee-list.jsp").forward(request, response);
			break;

		case "list":
		default:
			request.setAttribute("employees", service.list());
			request.getRequestDispatcher("employee-list.jsp").forward(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String idStr = req.getParameter("id");

		Employee e = new Employee(req.getParameter("name"), req.getParameter("email"),
				Double.parseDouble(req.getParameter("salary")), req.getParameter("department"));

		if (idStr != null && !idStr.isEmpty()) {
			e.setId(Integer.parseInt(idStr));
		}

		service.save(e);
		resp.sendRedirect("employee?action=list");
	}
}