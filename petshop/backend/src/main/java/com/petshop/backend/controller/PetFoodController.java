package com.petshop.backend.controller;

import com.petshop.backend.dto.PetFoodDTO;
import com.petshop.backend.service.PetFoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/pet-food")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PetFoodController {

    private final PetFoodService service;

    @GetMapping
    public List<PetFoodDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PetFoodDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PetFoodDTO create(@RequestBody PetFoodDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PetFoodDTO update(@PathVariable Long id, @RequestBody PetFoodDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
