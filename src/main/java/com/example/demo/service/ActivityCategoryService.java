package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import java.util.List;
import java.util.Optional;

public interface ActivityCategoryService {

    ActivityCategory addCategory(ActivityCategory category);

    List<ActivityCategory> getAllCategories();

    Optional<ActivityCategory> getCategoryById(Long id);

    void deleteCategory(Long id);

    String getCategoryNameById(Long id);

    Optional<ActivityCategory> getCategory(Long id);
}
