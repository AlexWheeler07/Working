package com.petshop.backend.service;

import com.petshop.backend.dto.AddressDTO;
import com.petshop.backend.entity.Address;
import com.petshop.backend.repository.AddressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public List<AddressDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AddressDTO getById(Long id) {
        Address entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public AddressDTO create(AddressDTO dto) {
        Address entity = new Address();
        BeanUtils.copyProperties(dto, entity);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public AddressDTO update(Long id, AddressDTO dto) {
        Address entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "addressId");
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AddressDTO mapToDTO(Address entity) {
        AddressDTO dto = new AddressDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
