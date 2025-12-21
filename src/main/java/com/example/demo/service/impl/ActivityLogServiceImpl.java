package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl {

    @Autowired
    private ActivityLogRepository logRepository;

    public ActivityLog logActivity(long userId, long activityTypeId, ActivityLog log) {
        return logRepository.save(log);
    }

    public List<ActivityLog> getLogsByUser(long userId) {
        return logRepository.findByUser_Id(userId);
    }

    public List<ActivityLog> getLogsByUserAndDate(long userId, LocalDate from, LocalDate to) {
        return logRepository.findByUser_IdAndLogDateBetween(userId, from, to);
    }
}
