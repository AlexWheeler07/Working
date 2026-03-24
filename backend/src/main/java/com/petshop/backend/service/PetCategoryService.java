package com.petshop.backend.service;

import com.petshop.backend.dto.PetCategoryDTO;
import java.util.List;

public interface PetCategoryService {
    List<PetCategoryDTO> getAll();
    PetCategoryDTO getById(Long id);
    PetCategoryDTO create(PetCategoryDTO dto);
    PetCategoryDTO update(Long id, PetCategoryDTO dto);
    void delete(Long id);
}
