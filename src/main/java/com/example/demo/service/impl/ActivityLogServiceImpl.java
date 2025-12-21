package com.example.carbonfootprint.service.impl;

import com.example.carbonfootprint.entity.ActivityLog;
import com.example.carbonfootprint.repository.ActivityLogRepository;
import com.example.carbonfootprint.service.ActivityLogService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepository;

    public ActivityLogServiceImpl(ActivityLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public ActivityLog logActivity(ActivityLog log) {
        return logRepository.save(log);
    }

    @Override
    public Optional<ActivityLog> getLog(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public List<ActivityLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public List<ActivityLog> getLogsForUserBetween(Long userId, LocalDate start, LocalDate end) {
        return logRepository.findByUser_IdAndActivityDateBetween(userId, start, end);
    }
}
