package com.deno4ka.databaseWebApp.controller;

import com.deno4ka.databaseWebApp.dao.CustomerDAO;
import com.deno4ka.databaseWebApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customerList = customerDAO.getCustomers();
		model.addAttribute("customerList", customerList);
		return "list-customers";
	}

}
