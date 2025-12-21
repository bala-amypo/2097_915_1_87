package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ActivityCategoryController {

    @Autowired
    private ActivityCategoryService categoryService;

    @PostMapping("/add")
    public ActivityCategory addCategory(@RequestBody ActivityCategory category) {
        return categoryService.addCategory(category); // fixed method name
    }

    @GetMapping("/{id}")
    public ActivityCategory getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id).orElse(null); // convert Optional properly
    }

    @GetMapping("/all")
    public List<ActivityCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
