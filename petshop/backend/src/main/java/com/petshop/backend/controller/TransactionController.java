package com.petshop.backend.controller;

import com.petshop.backend.dto.TransactionDTO;
import com.petshop.backend.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @GetMapping
    public List<TransactionDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TransactionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TransactionDTO create(@RequestBody TransactionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TransactionDTO update(@PathVariable Long id, @RequestBody TransactionDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private final com.petshop.backend.service.CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public List<com.petshop.backend.dto.TransactionDTO> getCustomerTransactions(@PathVariable Long customerId) {
        return customerService.getCustomerTransactions(customerId);
    }

}
