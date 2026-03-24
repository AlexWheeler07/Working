package com.petshop.backend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private Date hireDate;
    private String phoneNumber;
    private String email;
    private AddressDTO address;

}
