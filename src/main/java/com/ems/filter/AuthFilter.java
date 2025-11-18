package com.ems.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String uri = request.getRequestURI();
		String ctx = request.getContextPath();

		// Allow login + static resources
		if (uri.endsWith("login.jsp") || uri.equals(ctx + "/login") || uri.endsWith(".css") || uri.endsWith(".js")
				|| uri.endsWith(".png") || uri.endsWith(".jpg")) {

			chain.doFilter(req, res);
			return;
		}

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(ctx + "/login.jsp");
			return;
		}

		// Get role
		com.ems.model.Employee user = (com.ems.model.Employee) session.getAttribute("user");

		String role = user.getRole();

		boolean isAdmin = "ADMIN".equals(role);

		boolean isEmployeeAllowed = uri.endsWith("profile.jsp") || uri.contains("profile")
				|| uri.endsWith("updateProfile");

		boolean isAdminAllowed = uri.contains("employee") || uri.endsWith("dashboard-admin.jsp")
				|| uri.endsWith("employee-list.jsp") || uri.endsWith("employee-form.jsp");

		// EMPLOYEE trying to access admin pages
		if ("EMPLOYEE".equals(role) && !isEmployeeAllowed && !uri.endsWith("logout")) {
			response.sendRedirect(ctx + "/profile.jsp");
			return;
		}

		// ADMIN is always allowed
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
