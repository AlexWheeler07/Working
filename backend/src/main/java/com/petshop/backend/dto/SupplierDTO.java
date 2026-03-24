package com.petshop.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private Long supplierId;
    private String name;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private AddressDTO address;

}
