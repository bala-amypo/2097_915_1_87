package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;

@RestController
@RequestMapping("/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory c) {
        return service.create(c);
    }

    @GetMapping("/{id}")
    public ActivityCategory get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<ActivityCategory> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ActivityCategory update(@PathVariable Long id,
                                   @RequestBody ActivityCategory c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
