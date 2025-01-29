package com.ust.employee_service.entity;


import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
@JsonPropertyOrder({ "employeeId", "name", "designation", "skills", "status", "joiningDate", "projectId" })
public class Employee {

    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
            name = "custom-id-generator",
            strategy = "com.ust.employee_service.Generator.CustomIdGenerator"
    )
    private String employeeid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String skills;

    @Column(name = "is_available")
    private Status status;

    private LocalDate joiningDate;

    @Column(name = "project_id") // Assuming a foreign key to the project
    private Long projectId;


    public enum Status {

        ASSIGNED,

        UNASSIGNED

    }


    public Employee() {
    }

    public Employee(String employeeid, String name, String designation, String skills, Status status, LocalDate joiningDate,
            Long projectId) {
        this.employeeid = employeeid;
        this.name = name;
        this.designation = designation;
        this.skills = skills;
        this.status = status;
        this.joiningDate = joiningDate;
        this.projectId = projectId;
    }

    // Getters and Setters
    public String getemployeeId() {
        return employeeid;
    }

    public void setemployeeId(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
