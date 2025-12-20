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
    public ActivityType getType(Long id) {
        Optional<ActivityType> typeOpt = typeRepository.findById(id);
        return typeOpt.orElse(null);
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        Optional<ActivityCategory> categoryOpt = categoryRepository.findById(categoryId);
        if (categoryOpt.isPresent()) {
            return typeRepository.findByCategory(categoryOpt.get());
        }
        return null;
    }

    @Override
    public ActivityType updateType(Long id, ActivityType typeDetails) {
        ActivityType type = getType(id);
        if (type != null) {
            type.setTypeName(typeDetails.getTypeName());
            type.setUnit(typeDetails.getUnit());
            if (typeDetails.getCategory() != null) {
                type.setCategory(typeDetails.getCategory());
            }
            return typeRepository.save(type);
        }
        return null;
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
