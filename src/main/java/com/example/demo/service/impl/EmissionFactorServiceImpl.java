package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS WAS MISSING OR WRONG
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository repository;

    public EmissionFactorServiceImpl(EmissionFactorRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmissionFactor save(EmissionFactor factor) {
        return repository.save(factor);
    }

    @Override
    public List<EmissionFactor> getAll() {
        return repository.findAll();
    }

    @Override
    public EmissionFactor getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found with id " + id));
    }
}
