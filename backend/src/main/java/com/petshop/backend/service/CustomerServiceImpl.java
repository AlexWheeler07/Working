package com.petshop.backend.service;

import com.petshop.backend.dto.CustomerDTO;
import com.petshop.backend.entity.Customer;
import com.petshop.backend.repository.CustomerRepository;
import com.petshop.backend.repository.TransactionRepository;
import com.petshop.backend.dto.TransactionDTO;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final TransactionRepository transactionRepository;
    private final AddressRepository addressRepository;


    @Override
    public List<CustomerDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getById(Long id) {
        Customer entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer entity = new Customer();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getAddress() != null) {
            Address address = new Address();
            BeanUtils.copyProperties(dto.getAddress(), address);
            entity.setAddress(addressRepository.save(address));
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        Customer entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "customerId");
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

    @Override
    public List<TransactionDTO> getCustomerTransactions(Long id) {
        getById(id); // verify exists
        return transactionRepository.findByCustomerCustomerId(id).stream()
            .map(t -> {
                TransactionDTO dto = new TransactionDTO();
                BeanUtils.copyProperties(t, dto);
                return dto;
            }).collect(Collectors.toList());
    }

    private CustomerDTO mapToDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getAddress() != null) {
            AddressDTO addrDto = new AddressDTO();
            BeanUtils.copyProperties(entity.getAddress(), addrDto);
            dto.setAddress(addrDto);
        }
        return dto;
    }
}
