package com.deno4ka.springboot.demo.dao;

import com.deno4ka.springboot.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee where id:=employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
