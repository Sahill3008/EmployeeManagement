package com.ems.controller;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Employee user = (Employee) session.getAttribute("user");

        String action = req.getParameter("action");

        if ("edit".equals(action)) {
            req.setAttribute("emp", user);
            req.getRequestDispatcher("profile-edit.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("emp", user);
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        // Logged-in user
        Employee loggedUser = (Employee) session.getAttribute("user");

        // Always load fresh entity from DB (safe!)
        Employee dbUser = service.get(loggedUser.getId());

        // Update only allowed fields
        dbUser.setName(req.getParameter("name"));
        dbUser.setEmail(req.getParameter("email"));
        dbUser.setDepartment(req.getParameter("department"));
        dbUser.setUsername(req.getParameter("username"));

        String newPass = req.getParameter("password");
        if (newPass != null && !newPass.isEmpty()) {
            dbUser.setPassword(newPass);
        }

        // NEVER allow: salary, role changes here

        service.save(dbUser);   // Update DB

        // Refresh session object
        session.setAttribute("user", dbUser);

        resp.sendRedirect("profile.jsp");
    }
}
