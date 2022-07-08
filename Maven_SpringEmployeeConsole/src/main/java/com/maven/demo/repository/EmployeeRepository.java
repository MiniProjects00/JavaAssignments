package com.maven.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>,  CustomEmployeeRepository {

}
