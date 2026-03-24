package com.petshop.backend.repository;

import com.petshop.backend.entity.GroomingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroomingServiceRepository extends JpaRepository<GroomingService, Long> {
}
