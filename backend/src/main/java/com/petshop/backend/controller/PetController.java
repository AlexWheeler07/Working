package com.petshop.backend.controller;

import com.petshop.backend.dto.PetDTO;
import com.petshop.backend.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/pets")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @GetMapping
    public List<PetDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PetDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PetDTO create(@RequestBody PetDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PetDTO update(@PathVariable Long id, @RequestBody PetDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/category/{name}")
    public List<PetDTO> getPetsByCategory(@PathVariable String name) {
        return service.getPetsByCategory(name);
    }

    @PatchMapping("/{id}/price")
    public PetDTO updatePetPrice(@PathVariable Long id, @RequestBody java.util.Map<String, Double> payload) {
        Double newPrice = payload.get("price");
        return service.updatePetPrice(id, newPrice);
    }

    @GetMapping("/{id}/services")
    public java.util.Map<String, Object> getPetServices(@PathVariable Long id) {
        return java.util.Map.of(
            "grooming", service.getPetGroomingServices(id),
            "vaccinations", service.getPetVaccinations(id)
        );
    }

}
