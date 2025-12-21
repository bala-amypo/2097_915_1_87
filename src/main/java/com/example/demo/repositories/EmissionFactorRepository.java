package com.example.carbonfootprint.repository;

import com.example.carbonfootprint.entity.EmissionFactor;
import com.example.carbonfootprint.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {
    Optional<EmissionFactor> findByActivityType(ActivityType activityType);
}
