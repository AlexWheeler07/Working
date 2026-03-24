package com.petshop.backend.service;

import com.petshop.backend.dto.PetFoodDTO;
import com.petshop.backend.entity.PetFood;
import com.petshop.backend.repository.PetFoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class PetFoodServiceImpl implements PetFoodService {

    private final PetFoodRepository repository;

    @Override
    public List<PetFoodDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PetFoodDTO getById(Long id) {
        PetFood entity = repository.findById(id).orElseThrow(() -> new RuntimeException("PetFood not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public PetFoodDTO create(PetFoodDTO dto) {
        PetFood entity = new PetFood();
        BeanUtils.copyProperties(dto, entity);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public PetFoodDTO update(Long id, PetFoodDTO dto) {
        PetFood entity = repository.findById(id).orElseThrow(() -> new RuntimeException("PetFood not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "foodId");
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PetFoodDTO mapToDTO(PetFood entity) {
        PetFoodDTO dto = new PetFoodDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
