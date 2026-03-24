package com.petshop.backend.service;

import com.petshop.backend.dto.VaccinationDTO;
import java.util.List;

public interface VaccinationService {
    List<VaccinationDTO> getAll();
    VaccinationDTO getById(Long id);
    VaccinationDTO create(VaccinationDTO dto);
    VaccinationDTO update(Long id, VaccinationDTO dto);
    void delete(Long id);
}
