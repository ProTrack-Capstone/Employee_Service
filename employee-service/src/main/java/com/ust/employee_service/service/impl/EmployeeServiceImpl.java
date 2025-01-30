package com.ust.employee_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.employee_service.entity.Employee;
import com.ust.employee_service.repository.EmployeeRepository;
import com.ust.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getStatus() == null) {
            employee.setStatus(Employee.Status.UNASSIGNED);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(String employeeid, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeid)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSkills(employee.getSkills());
        existingEmployee.setStatus(employee.getStatus());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String employeeid) {
        employeeRepository.deleteById(employeeid);
    }

    @Override
    public Employee getEmployeeById(String employeeid) {
        return employeeRepository.findById(employeeid)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeid));
    }

    @Override
    public List<Employee> getEmployeesByProjectId(String projectId) {
        return employeeRepository.findByProjectId(projectId);
    }

    @Override
    public Employee assignEmployeeToProject(String employeeid, String projectId) {
        Employee existingEmployee = employeeRepository.findById(employeeid)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Set the projectId and change availability
        existingEmployee.setProjectId(projectId);
        existingEmployee.setStatus(Employee.Status.ASSIGNED);

        return employeeRepository.save(existingEmployee);
    }
}
