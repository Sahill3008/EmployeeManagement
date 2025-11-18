package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDAO {
	public List<Employee> search(String keyword) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		try {
			return em
					.createQuery("SELECT e FROM Employee e WHERE " + "LOWER(e.name) LIKE :kw OR "
							+ "LOWER(e.email) LIKE :kw OR " + "LOWER(e.department) LIKE :kw OR "
							+ "LOWER(e.username) LIKE :kw", Employee.class)
					.setParameter("kw", "%" + keyword.toLowerCase() + "%").getResultList();

		} finally {
			em.close();
		}
	}

	public void save(Employee e) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(e);
			tx.commit();
		} finally {
			if (tx.isActive())
				tx.rollback();
			em.close();
		}
	}

	public Employee find(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Employee e = em.find(Employee.class, id);
		em.close();
		return e;
	}

	public List<Employee> list() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			return em.createQuery("FROM Employee", Employee.class).setHint("org.hibernate.cacheable", true)
					.getResultList();
		} finally {
			em.close();
		}
	}

	public void delete(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Employee e = em.find(Employee.class, id);
			if (e != null)
				em.remove(e);
			tx.commit();
		} finally {
			if (tx.isActive())
				tx.rollback();
			em.close();
		}
	}

	public Employee get(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			return em.find(Employee.class, id);
		} finally {
			em.close();
		}
	}

}
