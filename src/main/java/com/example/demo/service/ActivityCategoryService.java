package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import java.util.List;

public interface ActivityCategoryService {

    ActivityCategory createCategory(ActivityCategory category);

    ActivityCategory getCategory(Long id);

    List<ActivityCategory> getAllCategories();

    ActivityCategory updateCategory(Long id, ActivityCategory category);

    void deleteCategory(Long id);
}
