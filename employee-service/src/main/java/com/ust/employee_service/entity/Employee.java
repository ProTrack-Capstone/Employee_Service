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
@JsonPropertyOrder({
    "employeeid", "firstName", "lastName", "designation", "emailId", "phoneNumber", 
    "skills", "status", "joiningDate", "experience", "projectId", "reportingManager", 
    "currentLocation", "address", "city", "country", "currentSalary", "bankName", 
    "accountNumber", "panNumber"
})
public class Employee {

    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
            name = "custom-id-generator",
            strategy = "com.ust.employee_service.Generator.CustomIdGenerator"
    )
    private String employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String designation;

    @Column(name="email_id",nullable = false)
    private String emailId;


    @Column(name="phone_number",nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String skills;

    @Column(name = "is_available")
    private Status status;

    private LocalDate joiningDate;

    @Column(name="experience",nullable = false)
    private String experience;

    @Column(name = "project_id") // Assuming a foreign key to the project
    private String projectId;

    @Column(name="reporting_manager",nullable = false)
    private String reportingManager;

    @Column(name="current_location",nullable = false)
    private String currentLocation;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="country",nullable = false)  
    private String country;

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

    public Employee(String employeeId, String firstName, String lastName, String designation, String emailId,
            String phoneNumber, String skills, Status status, LocalDate joiningDate, String experience,
            String projectId, String reportingManager, String currentLocation, String address, String city,
            String country, Long currentSalary, String bankName, String accountNumber, String panNumber) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.status = status;
        this.joiningDate = joiningDate;
        this.experience = experience;
        this.projectId = projectId;
        this.reportingManager = reportingManager;
        this.currentLocation = currentLocation;
        this.address = address;
        this.city = city;
        this.country = country;
        this.currentSalary = currentSalary;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.panNumber = panNumber;
    }

    public String getEmployeeid() {
        return employeeId;
    }

    public void setEmployeeid(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
