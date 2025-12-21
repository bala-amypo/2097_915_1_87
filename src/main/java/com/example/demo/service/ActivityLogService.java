package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    ActivityLog logActivity(ActivityLog log);
    Optional<ActivityLog> getById(Long id);
    List<ActivityLog> getLogsByUser(Long userId);
    List<ActivityLog> getLogsByUserAndDate(Long userId, java.time.LocalDate start, java.time.LocalDate end);
}
