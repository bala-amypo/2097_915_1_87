package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping
    public EmissionFactor create(@RequestBody EmissionFactor f) {
        return service.create(f);
    }

    @GetMapping("/{id}")
    public EmissionFactor get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<EmissionFactor> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EmissionFactor update(@PathVariable Long id,
                                 @RequestBody EmissionFactor f) {
        return service.update(id, f);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
