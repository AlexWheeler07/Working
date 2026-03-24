package com.petshop.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "grooming_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroomingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    private Boolean available = true;

    @ManyToMany(mappedBy = "groomingServices")
    @JsonIgnore
    private List<Pet> pets;



}
