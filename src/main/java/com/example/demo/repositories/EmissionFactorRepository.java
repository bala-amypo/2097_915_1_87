package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorRepository
        extends JpaRepository<EmissionFactor, Long> {

    Optional<EmissionFactor> findByActivityType_Id(Long activityTypeId);
}
