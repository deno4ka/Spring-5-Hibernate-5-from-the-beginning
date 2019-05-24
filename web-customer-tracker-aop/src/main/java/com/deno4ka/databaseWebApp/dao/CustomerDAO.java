package com.deno4ka.databaseWebApp.dao;

import com.deno4ka.databaseWebApp.entity.Customer;

import java.util.List;

public interface CustomerDAO {

	Customer getCustomer(int customerId);

	List<Customer> getCustomers();

	void saveOrUpdateCustomer(Customer customer);

	void deleteCustomer(int customerId);

}
