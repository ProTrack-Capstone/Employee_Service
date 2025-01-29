package com.ust.employee_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.employee_service.entity.Employee;
import com.ust.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // PUT endpoint to assign employee to a project
    @PutMapping("/{employeeid}/assign/{projectId}")
    public ResponseEntity<Employee> assignEmployeeToProject(@PathVariable String employeeid, @PathVariable Long projectId) {
        return ResponseEntity.ok(employeeService.assignEmployeeToProject(employeeid, projectId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeid, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeid, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeid) {
        employeeService.deleteEmployee(employeeid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeid) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeid));
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable Long projectId) {
        List<Employee> employees = employeeService.getEmployeesByProjectId(projectId);
        return ResponseEntity.ok(employees);
    }
}
