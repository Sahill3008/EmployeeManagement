package com.ems.controller;

import com.ems.dao.LoginDAO;
import com.ems.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginDAO dao = new LoginDAO();
        Employee user = dao.authenticate(username, password);

        if (user == null) {
            // ❗ NO printing — only redirect
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=1");
            return;
        }

        // Store user in session
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        // ADMIN redirect
        if ("ADMIN".equals(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/dashboard-admin.jsp");
            return;
        }

        // EMPLOYEE redirect
        resp.sendRedirect(req.getContextPath() + "/profile.jsp");
    }
}
