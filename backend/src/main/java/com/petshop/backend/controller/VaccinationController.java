package com.petshop.backend.controller;

import com.petshop.backend.dto.VaccinationDTO;
import com.petshop.backend.service.VaccinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/vaccinations")
@CrossOrigin("*")
@RequiredArgsConstructor
public class VaccinationController {

    private final VaccinationService service;

    @GetMapping
    public List<VaccinationDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VaccinationDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public VaccinationDTO create(@RequestBody VaccinationDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public VaccinationDTO update(@PathVariable Long id, @RequestBody VaccinationDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
