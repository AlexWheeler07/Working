package com.petshop.backend.service;

import com.petshop.backend.dto.EmployeeDTO;
import com.petshop.backend.entity.Employee;
import com.petshop.backend.repository.EmployeeRepository;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final AddressRepository addressRepository;

    @Override
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getById(Long id) {
        Employee entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee entity = new Employee();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getAddress() != null) {
            Address address = new Address();
            BeanUtils.copyProperties(dto.getAddress(), address);
            entity.setAddress(addressRepository.save(address));
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "employeeId");
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

    private EmployeeDTO mapToDTO(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getAddress() != null) {
            AddressDTO addrDto = new AddressDTO();
            BeanUtils.copyProperties(entity.getAddress(), addrDto);
            dto.setAddress(addrDto);
        }
        return dto;
    }
}
