package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    private ActivityTypeRepository typeRepository;

    @Autowired
    private ActivityCategoryRepository categoryRepository;

    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {
        Optional<ActivityCategory> categoryOpt = categoryRepository.findById(categoryId);
        if (categoryOpt.isPresent()) {
            type.setCategory(categoryOpt.get());
            return typeRepository.save(type);
        }
        return null;
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }

    @Override
    public ActivityType getType(Long id) {
        Optional<ActivityType> type = typeRepository.findById(id);
        return type.orElse(null);
    }

    @Override
    public ActivityType updateType(Long id, ActivityType updatedType) {
        Optional<ActivityType> typeOptional = typeRepository.findById(id);
        if (typeOptional.isPresent()) {
            ActivityType type = typeOptional.get();
            type.setTypeName(updatedType.getTypeName());
            type.setUnit(updatedType.getUnit());
            return typeRepository.save(type);
        }
        return null;
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
