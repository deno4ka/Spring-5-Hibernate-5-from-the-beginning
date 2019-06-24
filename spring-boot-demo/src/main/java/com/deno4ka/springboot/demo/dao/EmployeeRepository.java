package com.deno4ka.springboot.demo.dao;

import com.deno4ka.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
