package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;

@Service
public class EmissionFactorServiceImpl
        implements EmissionFactorService {

    private final EmissionFactorRepository repo;

    public EmissionFactorServiceImpl(EmissionFactorRepository repo) {
        this.repo = repo;
    }

    public EmissionFactor create(EmissionFactor f) {
        return repo.save(f);
    }

    public EmissionFactor get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<EmissionFactor> getAll() {
        return repo.findAll();
    }

    public EmissionFactor update(Long id, EmissionFactor f) {
        f.setId(id);
        return repo.save(f);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
