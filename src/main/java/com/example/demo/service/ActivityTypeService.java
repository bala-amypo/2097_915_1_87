package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    ActivityType saveType(ActivityType type);
    List<ActivityType> getAllTypes();
    ActivityType getTypeById(Long id);
    void deleteType(Long id);
    List<ActivityType> getTypesByCategory(Long categoryId); // must match impl
}
