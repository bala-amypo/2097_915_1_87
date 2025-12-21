package com.example.carbonfootprint.service;

import com.example.carbonfootprint.entity.EmissionFactor;
import com.example.carbonfootprint.entity.ActivityType;
import java.util.Optional;

public interface EmissionFactorService {
    EmissionFactor createFactor(EmissionFactor factor);
    Optional<EmissionFactor> getFactorByActivityType(ActivityType type);
}
