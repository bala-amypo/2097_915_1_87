package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor create(EmissionFactor f);
    EmissionFactor get(Long id);
    List<EmissionFactor> getAll();
    EmissionFactor update(Long id, EmissionFactor f);
    void delete(Long id);
}
