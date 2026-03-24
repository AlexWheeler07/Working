package com.petshop.backend.controller;

import com.petshop.backend.dto.EmployeeDTO;
import com.petshop.backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable("id") Long id, @RequestBody EmployeeDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
