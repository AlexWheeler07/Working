package com.petshop.backend.service;

import com.petshop.backend.dto.SupplierDTO;
import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAll();
    SupplierDTO getById(Long id);
    SupplierDTO create(SupplierDTO dto);
    SupplierDTO update(Long id, SupplierDTO dto);
    void delete(Long id);
}
