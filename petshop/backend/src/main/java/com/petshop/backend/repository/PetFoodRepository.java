package com.petshop.backend.repository;

import com.petshop.backend.entity.PetFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFoodRepository extends JpaRepository<PetFood, Long> {
}
