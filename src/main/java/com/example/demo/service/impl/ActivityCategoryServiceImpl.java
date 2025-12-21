package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryRepository categoryRepository;

    @Override
    public ActivityCategory addCategory(ActivityCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<ActivityCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public String getCategoryNameById(Long id) {
        Optional<ActivityCategory> category = categoryRepository.findById(id);
        return category.map(ActivityCategory::getCategoryName).orElse(null);
    }
}
