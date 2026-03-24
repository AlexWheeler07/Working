package com.petshop.backend.controller;

import com.petshop.backend.dto.CustomerDTO;
import com.petshop.backend.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
