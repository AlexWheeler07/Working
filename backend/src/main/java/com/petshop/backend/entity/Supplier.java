package com.petshop.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "suppliers")
    @JsonIgnore
    private List<Pet> pets;

}
