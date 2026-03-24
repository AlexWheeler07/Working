package com.petshop.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationDTO {
    private Long vaccinationId;
    private String name;
    private String description;
    private Double price;
    private Boolean available;



}
