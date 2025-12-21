package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @PostMapping
    public ActivityLog create(@RequestBody ActivityLog log) {
        return activityLogService.save(log);
    }

    @GetMapping
    public List<ActivityLog> getAll() {
        return activityLogService.getAll();
    }

    @GetMapping("/{id}")
    public ActivityLog getById(@PathVariable Long id) {
        return activityLogService.getById(id);
    }
}
