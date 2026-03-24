package com.petshop.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Long petId;
    private String name;
    private String breed;
    private Integer age;
    private Double price;
    private String description;
    private String imageUrl;
    private Long categoryId; // simplified relationship



}
