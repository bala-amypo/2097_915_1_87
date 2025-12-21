package com.example.carbonfootprint.service.impl;

import com.example.carbonfootprint.entity.ActivityType;
import com.example.carbonfootprint.repository.ActivityTypeRepository;
import com.example.carbonfootprint.service.ActivityTypeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public ActivityType createType(ActivityType type) {
        return typeRepository.save(type);
    }

    @Override
    public Optional<ActivityType> getType(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public List<ActivityType> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategoryId(categoryId);
    }
}
