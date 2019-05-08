package com.deno4ka.databaseWebApp.controller;

import com.deno4ka.databaseWebApp.entity.Customer;
import com.deno4ka.databaseWebApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

//	@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customerList = customerService.getCustomers();
		model.addAttribute("customerList", customerList);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveOrUpdateCustomer")
	public String saveOrUpdateCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveOrUpdateCustomer(customer);
		return "redirect:/customer/list";
	}

}
