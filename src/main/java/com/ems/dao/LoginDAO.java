package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class LoginDAO {

    public Employee authenticate(String username, String password) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT e FROM Employee e WHERE e.username = :u AND e.password = :p",
                    Employee.class)
                    .setParameter("u", username)
                    .setParameter("p", password)
                    .getSingleResult();

        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
