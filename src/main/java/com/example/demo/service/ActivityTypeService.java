package com.example.carbonfootprint.service;

import com.example.carbonfootprint.entity.ActivityType;
import java.util.List;
import java.util.Optional;

public interface ActivityTypeService {
    ActivityType createType(ActivityType type);
    Optional<ActivityType> getType(Long id);
    List<ActivityType> getAllTypes();
    List<ActivityType> getTypesByCategory(Long categoryId);
}
