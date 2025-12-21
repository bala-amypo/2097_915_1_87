package com.example.carbonfootprint.service;

import com.example.carbonfootprint.entity.ActivityCategory;
import java.util.List;
import java.util.Optional;

public interface ActivityCategoryService {
    ActivityCategory createCategory(ActivityCategory category);
    Optional<ActivityCategory> getCategory(Long id);
    List<ActivityCategory> getAllCategories();
}
