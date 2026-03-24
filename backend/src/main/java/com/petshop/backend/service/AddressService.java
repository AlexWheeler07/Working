package com.petshop.backend.service;

import com.petshop.backend.dto.AddressDTO;
import java.util.List;

public interface AddressService {
    List<AddressDTO> getAll();
    AddressDTO getById(Long id);
    AddressDTO create(AddressDTO dto);
    AddressDTO update(Long id, AddressDTO dto);
    void delete(Long id);
}
