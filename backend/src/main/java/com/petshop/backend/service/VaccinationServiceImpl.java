package com.petshop.backend.service;

import com.petshop.backend.dto.VaccinationDTO;
import com.petshop.backend.entity.Vaccination;
import com.petshop.backend.repository.VaccinationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class VaccinationServiceImpl implements VaccinationService {

    private final VaccinationRepository repository;

    @Override
    public List<VaccinationDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public VaccinationDTO getById(Long id) {
        Vaccination entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Vaccination not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public VaccinationDTO create(VaccinationDTO dto) {
        Vaccination entity = new Vaccination();
        BeanUtils.copyProperties(dto, entity);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public VaccinationDTO update(Long id, VaccinationDTO dto) {
        Vaccination entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Vaccination not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "vaccinationId");
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private VaccinationDTO mapToDTO(Vaccination entity) {
        VaccinationDTO dto = new VaccinationDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
