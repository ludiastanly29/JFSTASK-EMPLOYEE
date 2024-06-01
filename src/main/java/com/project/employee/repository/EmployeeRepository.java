package com.project.employee.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.employee.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByEmployeeID(String id);

	void deleteByEmployeeID(String id);
}
