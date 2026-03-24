package com.petshop.backend.service;

import com.petshop.backend.dto.CustomerDTO;
import com.petshop.backend.dto.TransactionDTO;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();
    CustomerDTO getById(Long id);
    CustomerDTO create(CustomerDTO dto);
    CustomerDTO update(Long id, CustomerDTO dto);
    void delete(Long id);
    List<TransactionDTO> getCustomerTransactions(Long id);
}
