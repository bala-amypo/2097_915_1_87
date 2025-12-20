package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    private ActivityTypeRepository typeRepository;

    @Override
    public ActivityType saveType(ActivityType type) {
        return typeRepository.save(type);
    }

    @Override
    public List<ActivityType> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public ActivityType getTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategoryName(categoryId.toString()); // if you use categoryName as String
    }
}
