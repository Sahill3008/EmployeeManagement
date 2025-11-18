package com.ems.service;

import com.ems.dao.LoginDAO;
import com.ems.model.Employee;

public class LoginService {

    private LoginDAO dao = new LoginDAO();

    public Employee login(String username, String password) {
        return dao.authenticate(username, password);
    }
}
