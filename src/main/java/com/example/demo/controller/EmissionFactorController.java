package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
@Tag(name = "Emission Factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping("/{activityTypeId}")
    public EmissionFactor create(@PathVariable Long activityTypeId,
                                 @RequestBody EmissionFactor factor) {
        return service.createFactor(activityTypeId, factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor get(@PathVariable Long id) {
        return service.getFactor(id);
    }

    @GetMapping("/type/{typeId}")
    public EmissionFactor byType(@PathVariable Long typeId) {
        return service.getFactorByType(typeId);
    }

    @GetMapping
    public List<EmissionFactor> all() {
        return service.getAllFactors();
    }
}
