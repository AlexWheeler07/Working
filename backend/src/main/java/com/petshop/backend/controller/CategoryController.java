package com.petshop.backend.controller;

import com.petshop.backend.dto.PetCategoryDTO;
import com.petshop.backend.service.PetCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryController {

    private final PetCategoryService service;

    @GetMapping
    public List<PetCategoryDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PetCategoryDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PetCategoryDTO create(@RequestBody PetCategoryDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PetCategoryDTO update(@PathVariable Long id, @RequestBody PetCategoryDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
