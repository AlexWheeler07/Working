package com.petshop.backend.dto;

import java.util.Date;

public class EmployeeDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private Date hireDate;
    private String phoneNumber;
    private String email;
    private AddressDTO address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String firstName, String lastName, String position, Date hireDate, String phoneNumber, String email, AddressDTO address) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}
