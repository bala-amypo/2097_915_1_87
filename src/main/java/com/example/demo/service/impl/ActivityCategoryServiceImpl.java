package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repo;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repo) {
        this.repo = repo;
    }

    public ActivityCategory createCategory(ActivityCategory category) {
        if (repo.existsByCategoryName(category.getCategoryName()))
            throw new ValidationException("Category name must be unique");
        return repo.save(category);
    }

    public ActivityCategory getCategory(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public List<ActivityCategory> getAllCategories() {
        return repo.findAll();
    }
}
