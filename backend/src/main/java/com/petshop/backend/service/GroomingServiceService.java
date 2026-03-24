package com.petshop.backend.service;

import com.petshop.backend.dto.GroomingServiceDTO;
import java.util.List;

public interface GroomingServiceService {
    List<GroomingServiceDTO> getAll();
    GroomingServiceDTO getById(Long id);
    GroomingServiceDTO create(GroomingServiceDTO dto);
    GroomingServiceDTO update(Long id, GroomingServiceDTO dto);
    void delete(Long id);
}
