package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS IS CRITICAL
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityLog save(ActivityLog log) {
        return repository.save(log);
    }

    @Override
    public List<ActivityLog> getAll() {
        return repository.findAll();
    }

    @Override
    public ActivityLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityLog not found"));
    }
}
