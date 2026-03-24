package com.petshop.backend.service;

import com.petshop.backend.dto.SupplierDTO;
import com.petshop.backend.entity.Supplier;
import com.petshop.backend.repository.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import com.petshop.backend.repository.AddressRepository;
import com.petshop.backend.dto.AddressDTO;
import com.petshop.backend.entity.Address;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final AddressRepository addressRepository;

    @Override
    public List<SupplierDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public SupplierDTO getById(Long id) {
        Supplier entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public SupplierDTO create(SupplierDTO dto) {
        Supplier entity = new Supplier();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getAddress() != null) {
            Address address = new Address();
            BeanUtils.copyProperties(dto.getAddress(), address);
            entity.setAddress(addressRepository.save(address));
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public SupplierDTO update(Long id, SupplierDTO dto) {
        Supplier entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "supplierId");
        if (dto.getAddress() != null) {
            Address address = entity.getAddress();
            if (address == null) {
                address = new Address();
            }
            BeanUtils.copyProperties(dto.getAddress(), address, "addressId");
            entity.setAddress(addressRepository.save(address));
        } else {
            entity.setAddress(null);
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SupplierDTO mapToDTO(Supplier entity) {
        SupplierDTO dto = new SupplierDTO();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getAddress() != null) {
            AddressDTO addrDto = new AddressDTO();
            BeanUtils.copyProperties(entity.getAddress(), addrDto);
            dto.setAddress(addrDto);
        }
        return dto;
    }
}
