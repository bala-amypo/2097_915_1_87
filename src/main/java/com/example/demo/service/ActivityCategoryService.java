package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import java.util.List;
import java.util.Optional;

public interface ActivityCategoryService {
    ActivityCategory addCategory(ActivityCategory category); // Use addCategory instead of createCategory
    List<ActivityCategory> getAllCategories();
    Optional<ActivityCategory> getCategory(Long id);
    void deleteCategory(Long id);
}
