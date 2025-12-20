package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;

    public ActivityTypeServiceImpl(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActivityType> getAllActivityTypes() {
        return repository.findAll();
    }

    @Override
    public void assignCategory(ActivityType type, ActivityCategory category) {
        // fixed: we store categoryName string instead of full object
        type.setCategoryName(category.getName());
        repository.save(type);
    }

    @Override
    public String getUnit(ActivityType type) {
        // If your ActivityType entity had a unit field, use it
        // Otherwise, remove the call or add a field in the entity
        return type.getUnit(); // Make sure ActivityType.java has: private String unit; + getter/setter
    }
}
