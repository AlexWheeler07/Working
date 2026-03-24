package com.petshop.backend.service;

import com.petshop.backend.dto.PetFoodDTO;
import java.util.List;

public interface PetFoodService {
    List<PetFoodDTO> getAll();
    PetFoodDTO getById(Long id);
    PetFoodDTO create(PetFoodDTO dto);
    PetFoodDTO update(Long id, PetFoodDTO dto);
    void delete(Long id);
}
