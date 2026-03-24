package com.petshop.backend.controller;

import com.petshop.backend.dto.GroomingServiceDTO;
import com.petshop.backend.service.GroomingServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/grooming-services")
@CrossOrigin("*")
@RequiredArgsConstructor
public class GroomingServiceController {

    private final GroomingServiceService service;

    @GetMapping
    public List<GroomingServiceDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GroomingServiceDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public GroomingServiceDTO create(@RequestBody GroomingServiceDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public GroomingServiceDTO update(@PathVariable Long id, @RequestBody GroomingServiceDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
