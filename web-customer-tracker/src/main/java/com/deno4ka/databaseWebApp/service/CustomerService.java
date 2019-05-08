package com.deno4ka.databaseWebApp.service;

import com.deno4ka.databaseWebApp.entity.Customer;

import java.util.List;

public interface CustomerService {

	Customer getCustomer(int customerId);

	List<Customer> getCustomers();

	void saveOrUpdateCustomer(Customer customer);

	void deleteCustomer(int customerId);

}
