package com.petshop.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetFoodDTO {
    private Long foodId;
    private String name;
    private String brand;
    private String type;
    private Integer quantity;
    private Double price;



}
