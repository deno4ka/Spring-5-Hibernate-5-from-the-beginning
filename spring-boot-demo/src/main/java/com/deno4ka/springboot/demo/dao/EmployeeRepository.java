package com.deno4ka.springboot.demo.dao;

import com.deno4ka.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members") // if you need different path than default - entityName + 's' ("employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
