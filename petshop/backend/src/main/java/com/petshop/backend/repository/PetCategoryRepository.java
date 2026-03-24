package com.petshop.backend.repository;

import com.petshop.backend.entity.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoryRepository extends JpaRepository<PetCategory, Long> {
    PetCategory findByName(String name);
}
