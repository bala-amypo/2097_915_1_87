package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ActivityLog;

public interface ActivityLogService {
    ActivityLog create(ActivityLog log);
    ActivityLog get(Long id);
    List<ActivityLog> getAll();
    ActivityLog update(Long id, ActivityLog log);
    void delete(Long id);
}
