package com.ust.employee_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findByProjectId(String projectId);
}
