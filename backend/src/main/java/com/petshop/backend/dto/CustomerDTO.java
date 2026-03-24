package com.petshop.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressDTO address;



}
