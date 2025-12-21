package com.example.carbonfootprint.service.impl;

import com.example.carbonfootprint.entity.ActivityCategory;
import com.example.carbonfootprint.repository.ActivityCategoryRepository;
import com.example.carbonfootprint.service.ActivityCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository categoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<ActivityCategory> getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
