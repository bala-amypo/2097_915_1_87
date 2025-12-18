package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;

@Service
public class ActivityCategoryServiceImpl
        implements ActivityCategoryService {

    private final ActivityCategoryRepository repo;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repo) {
        this.repo = repo;
    }

    public ActivityCategory create(ActivityCategory c) {
        return repo.save(c);
    }

    public ActivityCategory get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<ActivityCategory> getAll() {
        return repo.findAll();
    }

    public ActivityCategory update(Long id, ActivityCategory c) {
        c.setId(id);
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
