package com.ust.employee_service.service;

import java.util.List;

import com.ust.employee_service.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee updateEmployee(String employeeId, Employee employee);
    void deleteEmployee(String employeeId);
    Employee getEmployeeById(String employeeId);
    
    List<Employee> getEmployeesByProjectId(String projectId);
    //Employee assignEmployeeToProject(String employeeId, String projectId);

    List<Employee> getEmployeesByStatus(Employee.Status status);
    
    void updateEmployeesStatus(List<String> employeeIds, String projectId);
     // Add the method declaration here

    List<Employee>getUnassignedEmployees();

}
