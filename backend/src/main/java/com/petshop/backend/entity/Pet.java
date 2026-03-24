package com.petshop.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 50)
    private String breed;

    private Integer age;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PetCategory category;

    @ManyToMany
    @JoinTable(
        name = "pet_grooming_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonIgnore
    private List<GroomingService> groomingServices;

    @ManyToMany
    @JoinTable(
        name = "pet_vaccination_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "vaccination_id")
    )
    @JsonIgnore
    private List<Vaccination> vaccinations;

    @ManyToMany
    @JoinTable(
        name = "pet_food_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @JsonIgnore
    private List<PetFood> petFoods;

    @ManyToMany
    @JoinTable(
        name = "pet_supplier_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    @JsonIgnore
    private List<Supplier> suppliers;

    @ManyToMany
    @JoinTable(
        name = "employee_pet_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;



}
