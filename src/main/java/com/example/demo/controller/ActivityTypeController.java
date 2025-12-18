package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;

@RestController
@RequestMapping("/types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityType create(@RequestBody ActivityType t) {
        return service.create(t);
    }

    @GetMapping("/{id}")
    public ActivityType get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<ActivityType> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ActivityType update(@PathVariable Long id,
                               @RequestBody ActivityType t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
