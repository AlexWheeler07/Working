package com.petshop.backend.service;

import com.petshop.backend.dto.GroomingServiceDTO;
import com.petshop.backend.entity.GroomingService;
import com.petshop.backend.repository.GroomingServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class GroomingServiceServiceImpl implements GroomingServiceService {

    private final GroomingServiceRepository repository;

    @Override
    public List<GroomingServiceDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public GroomingServiceDTO getById(Long id) {
        GroomingService entity = repository.findById(id).orElseThrow(() -> new RuntimeException("GroomingService not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    public GroomingServiceDTO create(GroomingServiceDTO dto) {
        GroomingService entity = new GroomingService();
        BeanUtils.copyProperties(dto, entity);
        return mapToDTO(repository.save(entity));
    }

    @Override
    public GroomingServiceDTO update(Long id, GroomingServiceDTO dto) {
        GroomingService entity = repository.findById(id).orElseThrow(() -> new RuntimeException("GroomingService not found with id: " + id));
        BeanUtils.copyProperties(dto, entity, "serviceId");
        return mapToDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GroomingServiceDTO mapToDTO(GroomingService entity) {
        GroomingServiceDTO dto = new GroomingServiceDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
