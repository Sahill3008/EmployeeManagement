package com.ems.startup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.ems.service.EmployeeService;

@WebServlet(urlPatterns="/warmup", loadOnStartup=1)
public class WarmUpServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("🔵 EMS Warm-Up: Initializing Hibernate & Cache...");

        // Warm up Hibernate + fetch employees into cache
        EmployeeService service = new EmployeeService();
        service.list();

        System.out.println(" EMS Warm-Up Completed.");
    }
}
