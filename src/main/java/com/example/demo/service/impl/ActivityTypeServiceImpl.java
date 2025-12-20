package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    private ActivityTypeRepository typeRepository;

    @Autowired
    private ActivityCategoryRepository categoryRepository;

    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        type.setCategory(category);
        return typeRepository.save(type);
    }

    @Override
    public ActivityType getType(Long id) {
        return typeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type not found"));
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }

    @Override
    public ActivityType updateType(Long id, ActivityType updatedType) {
        ActivityType existing = getType(id);
        existing.setTypeName(updatedType.getTypeName());
        existing.setUnit(updatedType.getUnit());
        existing.setCategory(updatedType.getCategory());
        return typeRepository.save(existing);
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
