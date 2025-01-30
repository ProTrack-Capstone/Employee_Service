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
    private String projectId;

    @Column(name="current_salary",nullable = false)
    private Long currentSalary;

    @Column(name="bankName",nullable = false)
    private String bankName;

    @Column(name="accountNumber",nullable = false)
    private String accountNumber;

    @Column(name="panNumber",nullable = false)
    private String panNumber;

    public enum Status {

        ASSIGNED,

        UNASSIGNED

    }


    public Employee() {
    }

    public Employee(String employeeid, String name, String designation, String skills, Status status,
            LocalDate joiningDate, String projectId, Long currentSalary, String bankName, String accountNumber,
            String panNumber) {
        this.employeeid = employeeid;
        this.name = name;
        this.designation = designation;
        this.skills = skills;
        this.status = status;
        this.joiningDate = joiningDate;
        this.projectId = projectId;
        this.currentSalary = currentSalary;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.panNumber = panNumber;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCurrentSalary() {
        return currentSalary;
    }


    public void setCurrentSalary(Long currentSalary) {
        this.currentSalary = currentSalary;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getPanNumber() {
        return panNumber;
    }


    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

}
