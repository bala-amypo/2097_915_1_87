package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorServiceImpl {

    private final EmissionFactorRepository repository;

    public EmissionFactorServiceImpl(EmissionFactorRepository repository) {
        this.repository = repository;
    }

    public EmissionFactor getByActivityType(ActivityType activityType) {
        return repository.findByActivityType(activityType);
    }
}
