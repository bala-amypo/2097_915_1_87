package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType createType(Long categoryId, ActivityType type);

    List<ActivityType> getTypesByCategory(Long categoryId);

    ActivityType getType(Long id);

    ActivityType updateType(Long id, ActivityType type);

    void deleteType(Long id);
}
