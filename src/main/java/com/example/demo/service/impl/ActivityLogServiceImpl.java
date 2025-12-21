package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository logRepository;

    @Override
    public ActivityLog logActivity(ActivityLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate startDate, LocalDate endDate) {
        return logRepository.findByUser_IdAndLogDateBetween(userId, startDate, endDate);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepository.findByUser_Id(userId);
    }

    @Override
    public Optional<ActivityLog> getLogById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
