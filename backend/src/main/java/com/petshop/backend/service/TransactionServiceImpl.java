package com.petshop.backend.service;

import com.petshop.backend.dto.TransactionDTO;
import com.petshop.backend.entity.Transaction;
import com.petshop.backend.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import com.petshop.backend.repository.CustomerRepository;
import com.petshop.backend.repository.PetRepository;
import com.petshop.backend.repository.CustomerRepository;
import com.petshop.backend.repository.PetRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CustomerRepository customerRepository;
    private final PetRepository petRepository;

    @Override
    public List<TransactionDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getById(Long id) {
        Transaction entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public TransactionDTO create(TransactionDTO dto) {
        Transaction entity = new Transaction();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getCustomerId() != null) {
            entity.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
        }
        if (dto.getPetId() != null) {
            entity.setPet(petRepository.findById(dto.getPetId()).orElse(null));
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public TransactionDTO update(Long id, TransactionDTO dto) {
        Transaction entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "transactionId");
        if (dto.getCustomerId() != null) {
            entity.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
        } else {
            entity.setCustomer(null);
        }
        if (dto.getPetId() != null) {
            entity.setPet(petRepository.findById(dto.getPetId()).orElse(null));
        } else {
            entity.setPet(null);
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TransactionDTO mapToDTO(Transaction entity) {
        TransactionDTO dto = new TransactionDTO();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getCustomer() != null) {
            dto.setCustomerId(entity.getCustomer().getCustomerId());
        }
        if (entity.getPet() != null) {
            dto.setPetId(entity.getPet().getPetId());
        }
        return dto;
    }
}
