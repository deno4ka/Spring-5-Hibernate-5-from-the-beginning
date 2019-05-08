package com.deno4ka.databaseWebApp.dao;

import com.deno4ka.databaseWebApp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer getCustomer(int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Customer> query = currentSession.createQuery("from Customer where id =: customerId", Customer.class);
//		query.setParameter("customerId", customerId);
//		Customer customer = query.getSingleResult();
		Customer customer = currentSession.get(Customer.class, customerId);
		return customer;
	}

	@Override
//	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

}
