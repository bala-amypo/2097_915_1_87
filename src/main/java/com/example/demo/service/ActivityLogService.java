package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.util.List;

public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long typeId, ActivityLog log);
    List<ActivityLog> getLogsByUser(Long userId);
}
