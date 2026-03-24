package com.petshop.backend.dto;

public class SupplierDTO {
    private Long supplierId;
    private String name;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private AddressDTO address;

    public SupplierDTO() {
    }

    public SupplierDTO(Long supplierId, String name, String contactPerson, String phoneNumber, String email, AddressDTO address) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}
