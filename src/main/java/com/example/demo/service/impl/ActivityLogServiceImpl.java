package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl {

    private final ActivityLogRepository logRepo;
    private final EmissionFactorRepository factorRepo;

    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  EmissionFactorRepository factorRepo) {
        this.logRepo = logRepo;
        this.factorRepo = factorRepo;
    }

    public ActivityLog save(ActivityLog log) {

        ActivityType type = log.getActivityType();

        EmissionFactor factor = factorRepo.findByActivityType(type);

        double emission = log.getQuantity() * factor.getFactorValue();
        log.setEstimatedEmission(emission);

        return logRepo.save(log);
    }
}
