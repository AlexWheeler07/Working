package com.petshop.backend.service;

import com.petshop.backend.dto.PetDTO;
import com.petshop.backend.dto.GroomingServiceDTO;
import com.petshop.backend.dto.VaccinationDTO;
import java.util.List;

public interface PetService {
    List<PetDTO> getAll();
    PetDTO getById(Long id);
    PetDTO create(PetDTO dto);
    PetDTO update(Long id, PetDTO dto);
    void delete(Long id);
    PetDTO updatePetPrice(Long id, Double price);
    List<PetDTO> getPetsByCategory(String categoryName);
    List<GroomingServiceDTO> getPetGroomingServices(Long id);
    List<VaccinationDTO> getPetVaccinations(Long id);
}
