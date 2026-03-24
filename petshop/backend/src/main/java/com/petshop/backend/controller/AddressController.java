package com.petshop.backend.controller;

import com.petshop.backend.dto.AddressDTO;
import com.petshop.backend.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/addresses")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping
    public List<AddressDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AddressDTO create(@RequestBody AddressDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
