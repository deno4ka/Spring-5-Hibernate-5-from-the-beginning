package com.deno4ka.springboot.demo.rest;

import com.deno4ka.springboot.demo.dao.EmployeeDAO;
import com.deno4ka.springboot.demo.entity.Employee;
import com.deno4ka.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/${id}")
	public Employee getEmployees(@PathVariable int id) {
		return employeeService.findById(id);
	}

}
