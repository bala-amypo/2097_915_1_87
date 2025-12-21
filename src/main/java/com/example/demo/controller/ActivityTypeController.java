package com.example.carbonfootprint.controller;

import com.example.carbonfootprint.entity.ActivityType;
import com.example.carbonfootprint.service.ActivityTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getType(@PathVariable Long id) {
        return typeService.getType(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ActivityType>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(typeService.getTypesByCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<ActivityType> createType(@RequestBody ActivityType type) {
        return ResponseEntity.ok(typeService.createType(type));
    }
}
