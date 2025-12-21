package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emission-factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping
    public EmissionFactor create(@RequestBody EmissionFactor factor) {
        return service.save(factor);
    }

    @GetMapping
    public List<EmissionFactor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmissionFactor getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
