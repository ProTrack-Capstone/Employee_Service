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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.employee_service.entity.Employee;
import com.ust.employee_service.repository.EmployeeRepository;
import com.ust.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
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
    // @PutMapping("/{employeeId}/assign/{projectId}")
    // public ResponseEntity<Employee> assignEmployeeToProject(@PathVariable String employeeId, @PathVariable String projectId) {
    //     return ResponseEntity.ok(employeeService.assignEmployeeToProject(employeeId, projectId));
    // }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") String employeeId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employee));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/unassigned")
public ResponseEntity<List<Employee>> getUnassignedEmployees() {
    List<Employee> unassignedEmployees = employeeRepository.findByStatus(Employee.Status.UNASSIGNED);
    return ResponseEntity.ok(unassignedEmployees);
}


    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable String projectId) {
        List<Employee> employees = employeeService.getEmployeesByProjectId(projectId);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update-status")
    public ResponseEntity<String> updateEmployeesStatus(
            @RequestBody List<String> employeeIds,
            @RequestParam String projectId) {

        employeeService.updateEmployeesStatus(employeeIds, projectId);
        return ResponseEntity.ok("Employee statuses updated successfully");
    }

}
