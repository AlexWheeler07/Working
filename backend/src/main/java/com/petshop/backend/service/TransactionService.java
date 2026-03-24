package com.petshop.backend.service;

import com.petshop.backend.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAll();
    TransactionDTO getById(Long id);
    TransactionDTO create(TransactionDTO dto);
    TransactionDTO update(Long id, TransactionDTO dto);
    void delete(Long id);
}
