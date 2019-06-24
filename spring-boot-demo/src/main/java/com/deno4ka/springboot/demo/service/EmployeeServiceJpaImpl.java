package com.deno4ka.springboot.demo.service;

import com.deno4ka.springboot.demo.dao.EmployeeRepository;
import com.deno4ka.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceJpaImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceJpaImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
