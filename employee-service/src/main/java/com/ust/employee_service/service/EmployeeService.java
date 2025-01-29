package com.ust.employee_service.service;

import java.util.List;

import com.ust.employee_service.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee updateEmployee(String employeeid, Employee employee);
    void deleteEmployee(String employeeid);
    Employee getEmployeeById(String employeeid);
    List<Employee> getEmployeesByProjectId(Long projectId);
    Employee assignEmployeeToProject(String employeeid, Long projectId);
}
