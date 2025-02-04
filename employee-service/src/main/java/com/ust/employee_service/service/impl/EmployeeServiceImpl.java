package com.ust.employee_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ust.employee_service.entity.Employee;
import com.ust.employee_service.repository.EmployeeRepository;
import com.ust.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getEmployeesByStatus(Employee.Status status) {
        return employeeRepository.findByStatus(status);
    }

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
    public Employee updateEmployee(String employeeId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSkills(employee.getSkills());
        existingEmployee.setStatus(employee.getStatus());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        existingEmployee.setProjectId(employee.getProjectId());
        existingEmployee.setCurrentSalary(employee.getCurrentSalary());  // Ensure this line exists
        existingEmployee.setBankName(employee.getBankName());
        existingEmployee.setAccountNumber(employee.getAccountNumber());
        existingEmployee.setPanNumber(employee.getPanNumber());

        return employeeRepository.save(existingEmployee);
    }


    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }

    @Override
    public List<Employee> getEmployeesByProjectId(String projectId) {
        return employeeRepository.findByProjectId(projectId);
    }

    // @Override
    // public Employee assignEmployeeToProject(String employeeId, String projectId) {
    //     Employee existingEmployee = employeeRepository.findById(employeeId)
    //             .orElseThrow(() -> new RuntimeException("Employee not found"));

    //     // Set the projectId and change availability
    //     existingEmployee.setProjectId(projectId);
    //     existingEmployee.setStatus(Employee.Status.ASSIGNED);

    //     return employeeRepository.save(existingEmployee);
    // }

    @Override
    public void updateEmployeesStatus(List<String> employeeIds, String projectId) {
        List<Employee> employees = employeeRepository.findAllById(employeeIds);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with given IDs");
        }

        // Update projectId and status for all employees
        employees.forEach(employee -> {
            employee.setProjectId(projectId);
            employee.setStatus(Employee.Status.ASSIGNED);
        });

        employeeRepository.saveAll(employees);
    }

    @Override
    public List<Employee> getUnassignedEmployees() {
        List<Employee> employees = employeeRepository.findByStatus(Employee.Status.UNASSIGNED);
        return employees.stream()
                .map(emp -> new Employee(emp.getEmployeeid(), emp.getFirstName(), emp.getLastName(), emp.getDesignation(), emp.getSkills(), null, null, null, null, null, null, null, null, null, null, null, emp.getCurrentSalary(), null, null, null))
                .collect(Collectors.toList());
    }


}
