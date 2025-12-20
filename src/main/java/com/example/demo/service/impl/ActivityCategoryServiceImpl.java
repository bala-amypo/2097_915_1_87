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
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        Optional<ActivityCategory> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public ActivityCategory updateCategory(Long id, ActivityCategory updatedCategory) {
        Optional<ActivityCategory> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            ActivityCategory category = categoryOptional.get();
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
