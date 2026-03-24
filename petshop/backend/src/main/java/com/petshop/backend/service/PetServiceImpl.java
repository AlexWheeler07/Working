package com.petshop.backend.service;

import com.petshop.backend.dto.PetDTO;
import com.petshop.backend.dto.GroomingServiceDTO;
import com.petshop.backend.dto.VaccinationDTO;
import com.petshop.backend.entity.Pet;
import com.petshop.backend.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import com.petshop.backend.repository.PetCategoryRepository;
import com.petshop.backend.entity.PetCategory;


@Service
@Transactional
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository repository;
    private final PetCategoryRepository categoryRepository;


    @Override
    public List<PetDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PetDTO getById(Long id) {
        Pet entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public PetDTO create(PetDTO dto) {
        Pet entity = new Pet();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getCategoryId() != null) {
            PetCategory category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
            entity.setCategory(category);
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public PetDTO update(Long id, PetDTO dto) {
        Pet entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "petId");
        if (dto.getCategoryId() != null) {
            PetCategory category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
            entity.setCategory(category);
        } else {
            entity.setCategory(null);
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PetDTO updatePetPrice(Long id, Double price) {
        Pet entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        entity.setPrice(price);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public List<PetDTO> getPetsByCategory(String categoryName) {
        return repository.findByCategoryName(categoryName).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<GroomingServiceDTO> getPetGroomingServices(Long id) {
        Pet entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        return entity.getGroomingServices().stream().map(s -> {
            GroomingServiceDTO dto = new GroomingServiceDTO();
            BeanUtils.copyProperties(s, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VaccinationDTO> getPetVaccinations(Long id) {
        Pet entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        return entity.getVaccinations().stream().map(v -> {
            VaccinationDTO dto = new VaccinationDTO();
            BeanUtils.copyProperties(v, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    private PetDTO mapToDTO(Pet entity) {
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getCategoryId());
        }
        return dto;
    }
}
