package com.petshop.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCategoryDTO {
    private Long categoryId;
    private String name;



}
