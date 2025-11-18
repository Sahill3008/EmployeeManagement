package com.ems.service;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public void save(Employee e) {
        dao.save(e);
    }

    public List<Employee> list() {
        return dao.list();
    }

    public Employee get(int id) {
        return dao.get(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Employee> searchEmployees(String keyword) {
        return dao.search(keyword);
    }
}
