package com.petshop.backend.service;

import com.petshop.backend.dto.PetCategoryDTO;
import com.petshop.backend.entity.PetCategory;
import com.petshop.backend.repository.PetCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class PetCategoryServiceImpl implements PetCategoryService {

    private final PetCategoryRepository repository;

    @Override
    public List<PetCategoryDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PetCategoryDTO getById(Long id) {
        PetCategory entity = repository.findById(id).orElseThrow(() -> new RuntimeException("PetCategory not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public PetCategoryDTO create(PetCategoryDTO dto) {
        PetCategory entity = new PetCategory();
        BeanUtils.copyProperties(dto, entity);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public PetCategoryDTO update(Long id, PetCategoryDTO dto) {
        PetCategory entity = repository.findById(id).orElseThrow(() -> new RuntimeException("PetCategory not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "categoryId");
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PetCategoryDTO mapToDTO(PetCategory entity) {
        PetCategoryDTO dto = new PetCategoryDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
