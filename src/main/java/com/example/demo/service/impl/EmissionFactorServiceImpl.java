package com.example.carbonfootprint.service.impl;

import com.example.carbonfootprint.entity.EmissionFactor;
import com.example.carbonfootprint.entity.ActivityType;
import com.example.carbonfootprint.repository.EmissionFactorRepository;
import com.example.carbonfootprint.service.EmissionFactorService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepository) {
        this.factorRepository = factorRepository;
    }

    @Override
    public EmissionFactor createFactor(EmissionFactor factor) {
        return factorRepository.save(factor);
    }

    @Override
    public Optional<EmissionFactor> getFactorByActivityType(ActivityType type) {
        return factorRepository.findByActivityType(type);
    }
}
