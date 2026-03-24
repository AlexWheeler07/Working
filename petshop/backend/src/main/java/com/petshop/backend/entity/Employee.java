package com.petshop.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(length = 50)
    private String position;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    private List<Pet> pets;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, String position, Date hireDate, String phoneNumber, String email, Address address, List<Pet> pets) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.pets = pets;
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

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }
}
