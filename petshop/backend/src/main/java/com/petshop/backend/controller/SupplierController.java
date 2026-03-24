package com.petshop.backend.controller;

import com.petshop.backend.dto.SupplierDTO;
import com.petshop.backend.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/suppliers")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    public List<SupplierDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SupplierDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public SupplierDTO create(@RequestBody SupplierDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public SupplierDTO update(@PathVariable Long id, @RequestBody SupplierDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
