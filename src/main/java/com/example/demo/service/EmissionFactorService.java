package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

import java.util.List;

public interface EmissionFactorService {

    EmissionFactor save(EmissionFactor factor);

    List<EmissionFactor> getAll();

    EmissionFactor getById(Long id);
}
