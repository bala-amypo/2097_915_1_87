package com.example.carbonfootprint.service;

import com.example.carbonfootprint.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    ActivityLog logActivity(ActivityLog log);
    Optional<ActivityLog> getLog(Long id);
    List<ActivityLog> getAllLogs();
    List<ActivityLog> getLogsForUserBetween(Long userId, LocalDate start, LocalDate end);
}
