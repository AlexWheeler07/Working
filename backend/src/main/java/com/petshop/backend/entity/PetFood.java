package com.petshop.backend.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "pet_food")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 100)
    private String brand;

    @Column(length = 50)
    private String type;

    private Integer quantity;

    private Double price;

    @ManyToMany(mappedBy = "petFoods")
    @JsonIgnore
    private List<Pet> pets;



}
