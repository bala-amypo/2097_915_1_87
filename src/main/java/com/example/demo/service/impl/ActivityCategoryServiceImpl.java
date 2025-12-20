package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryRepository categoryRepository;

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ActivityCategory updateCategory(Long id, ActivityCategory updatedCategory) {
        ActivityCategory existing = getCategory(id);
        existing.setCategoryName(updatedCategory.getCategoryName());
        existing.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
