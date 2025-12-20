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
    public ActivityCategory createCategory(ActivityCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ActivityCategory getCategory(Long id) {   // must match interface
        Optional<ActivityCategory> optional = categoryRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ActivityCategory updateCategory(Long id, ActivityCategory categoryDetails) {
        ActivityCategory category = getCategory(id);  // uses getCategory
        if (category != null) {
            category.setCategoryName(categoryDetails.getCategoryName());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
